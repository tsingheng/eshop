package net.shangtech.eshop.manager.spider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.entity.Product;
import net.shangtech.eshop.product.service.ICategoryService;
import net.shangtech.eshop.product.service.IProductService;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ScriptTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ProductSpider {
	
	private static final String CATEGORY_EXCEL_PATH = "/Users/tsingheng/Documents/vip部分商品分类.xls";
	
	private ICategoryService categoryService;
	private IProductService productService;
	
	public ProductSpider(ICategoryService categoryService, IProductService productService){
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	public void exec() throws FileNotFoundException, IOException, ParserException, InterruptedException{
		List<CategoryWrapper> wrappers = new CategoryXlsReader(CATEGORY_EXCEL_PATH).read();
		for(CategoryWrapper wrapper : wrappers){
			Category parent = wrapper.getParent();
			if(parent != null && parent.getId() == null){
				categoryService.save(parent);
			}
			Category category = wrapper.getCategory();
			if(parent != null){
				category.setParentId(parent.getId());
			}
			categoryService.save(category);
			processCategory(wrapper);
			Thread.sleep(2000);
		}
	}
	
	private void processCategory(CategoryWrapper wrapper) throws ParserException{
		if(!BooleanUtils.isTrue(wrapper.getCategory().getLeaf())){
			return;
		}
		List<Product> list = new ProductListParser(wrapper.getUrl()).parse();
		for(Product product : list){
			product.setCategoryId(wrapper.getCategory().getId());
			productService.save(product);
		}
	}
	
}

class CategoryXlsReader{
	private String path;
	public CategoryXlsReader(String path){
		this.path = path;
	}
	public List<CategoryWrapper> read() throws FileNotFoundException, IOException{
		List<CategoryWrapper> list = new LinkedList<CategoryWrapper>();
		HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(path));
		HSSFSheet sheet = book.getSheetAt(0);
		@SuppressWarnings("unchecked")
        Iterator<HSSFRow> it = sheet.rowIterator();
		it.next();
		while(it.hasNext()){
			HSSFRow row = it.next();
			Category category = new Category();
			category.setName(getString(row, 2));
			category.setLeaf(BooleanUtils.isTrue(getBoolean(row, 5)));
			CategoryWrapper wrapper = new CategoryWrapper();
			wrapper.setId(getLong(row, 0));
			wrapper.setParentId(getLong(row, 1));
			wrapper.setUrl(getString(row, 6));
			wrapper.setCategory(category);
			String code = wrapper.getUrl();
			code = code.substring(46, 50);
			category.setCode(code);
			list.add(wrapper);
		}
		Map<Long, CategoryWrapper> map = new HashMap<Long, CategoryWrapper>();
		for(CategoryWrapper wrapper : list){
			map.put(wrapper.getId(), wrapper);
		}
		for(CategoryWrapper wrapper : list){
			CategoryWrapper parentWrapper = map.get(wrapper.getParentId());
			if(parentWrapper == null){
				wrapper.setParent(null);
			}else{
				wrapper.setParent(parentWrapper.getCategory());
			}
		}
		return list;
	}
	private String getString(HSSFRow row, int index){
		HSSFCell cell = row.getCell(index);
		if(cell == null){
			return null;
		}
		return StringUtils.trim(cell.getRichStringCellValue().toString());
	}
	private Long getLong(HSSFRow row, int index){
		HSSFCell cell = row.getCell(index);
		if(cell == null){
			return null;
		}
		return new Double(cell.getNumericCellValue()).longValue();
	}
	private Boolean getBoolean(HSSFRow row, int index){
		HSSFCell cell = row.getCell(index);
		if(cell == null){
			return null;
		}
		return cell.getBooleanCellValue();
	}
}
class CategoryWrapper {
    private Long id;
    
    private Long parentId;
	
    private Category category;
    
    private Category parent;
    
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}

class ProductListParser{
	private String url;
	public ProductListParser(String url){
		this.url = url;
	}
	public List<Product> parse() throws ParserException{
		List<Product> list = new LinkedList<Product>();
		Parser parser = new Parser();
		parser.setURL(url);
		NodeFilter filter = new TagNameFilter("body");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		String html = nodes.elementAt(0).toHtml().replaceAll("figure|figcaption", "div");
		list.addAll(parseJs(html));
		return list;
	}
	
	private List<Product> parseJs(String html) throws ParserException{
		List<Product> list = new LinkedList<Product>();
		Parser parser = new Parser();
		parser.setInputHTML(html);
		NodeFilter filter = new TagNameFilter("script");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null){
			for(int i = 0; i < nodes.size(); i++){
				ScriptTag script = (ScriptTag) nodes.elementAt(i);
				String content = script.getScriptCode();
				if(content.contains("allData")){
					content = content.substring(content.indexOf("data"));
					content = content.substring(content.indexOf("[{"), content.indexOf("}]")+2);
					JSONArray array = JSONArray.parseArray(content);
					array.forEach(item -> {
						JSONObject obj = (JSONObject) item;
						Product product = new Product();
						product.setImage(obj.getString("list_img"));
						product.setMarketPrice(obj.getDouble("market_price"));
						product.setName(obj.getString("name"));
						product.setSellPrice(obj.getDouble("sell_price"));
						product.setBrandId(obj.getLong("brand_id"));
						String img = product.getImage();
						String imgName = img.substring(img.lastIndexOf("/")+1);
						String brandCode = imgName.substring(0, imgName.indexOf("-"));
						String productCode = imgName.substring(imgName.indexOf("-")+1, imgName.lastIndexOf("-"));
						product.setImage(img.substring(0, img.lastIndexOf("-")));
						product.setCode(productCode);
						product.setBrandCode(brandCode);
						list.add(product);
					});
				}
			}
		}
		return list;
	}
}