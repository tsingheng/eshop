package net.shangtech.eshop.manager.spider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.shangtech.eshop.manager.spider.suport.CategoryBrandWrapper;
import net.shangtech.eshop.manager.spider.suport.CategoryWrapper;
import net.shangtech.eshop.manager.spider.suport.ProductWrapper;
import net.shangtech.eshop.product.entity.Brand;
import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.BrandService;
import net.shangtech.eshop.product.service.CategoryService;
import net.shangtech.eshop.product.service.InventoryService;
import net.shangtech.eshop.product.service.SkuService;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.htmlparser.util.ParserException;
import org.springframework.util.CollectionUtils;

public class CategoryProcessor {
	
	private static final String CATEGORY_EXCEL_PATH = "/Users/tsingheng/Documents/vip部分商品分类.xls";
	
	private CategoryService categoryService;
	private SkuService productService;
	private InventoryService inventoryService;
	private BrandService brandService;
	
	public CategoryProcessor(CategoryService categoryService, SkuService productService, InventoryService inventoryService, BrandService brandService){
		this.categoryService = categoryService;
		this.productService = productService;
		this.inventoryService = inventoryService;
		this.brandService = brandService;
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
			
			if(wrapper.getCategory().getId() > 21){
				processCategory(wrapper);
			}
//			Thread.sleep(2000);
		}
	}
	
	private void processCategory(CategoryWrapper wrapper) throws ParserException, ClientProtocolException, IOException, InterruptedException{
		if(!BooleanUtils.isTrue(wrapper.getCategory().getLeaf())){
			return;
		}
		CategoryBrandParser parser = new CategoryBrandParser(wrapper.getUrl());
		List<CategoryBrandWrapper> brands = parser.parse();
		for(CategoryBrandWrapper brand : brands){
			processBrand(brand.getBrand());
			ProductListParser productListParser = new ProductListParser(brand.getUrl());
			while(productListParser.hasMore()){
				List<ProductWrapper> list = productListParser.parse();
				saveProducts(wrapper.getCategory().getId(), brand.getBrand(), list);
			}
		}
	}
	
	private void processBrand(Brand brand){
		Brand old = brandService.findBySn(brand.getSn());
		if(old == null){
			brandService.save(brand);
		}else{
			brand.setId(old.getId());
		}
	}
	
	private void saveProducts(Long categoryId, Brand brand, List<ProductWrapper> list) throws ParserException, ClientProtocolException, IOException, InterruptedException{
		for(ProductWrapper wrapper : list){
			Sku product = wrapper.getProduct();
			Sku old = productService.findByVid(product.getVid());
			if(old != null){
				continue;
			}
			
			new ProductDetailParser(wrapper).parse();
			
			product.setCategoryId(categoryId);
			product.setBrandId(brand.getId());
			productService.save(product);
			if(!CollectionUtils.isEmpty(wrapper.getInventories())){
				for(Inventory inventory : wrapper.getInventories()){
					inventory.setSkuId(product.getId());
					inventoryService.save(inventory);
				}
			}
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
        Iterator<Row> it = sheet.rowIterator();
		it.next();
		while(it.hasNext()){
			Row row = it.next();
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
		book.close();
		return list;
	}
	private String getString(Row row, int index){
		Cell cell = row.getCell(index);
		if(cell == null){
			return null;
		}
		return StringUtils.trim(cell.getRichStringCellValue().toString());
	}
	private Long getLong(Row row, int index){
		Cell cell = row.getCell(index);
		if(cell == null){
			return null;
		}
		return new Double(cell.getNumericCellValue()).longValue();
	}
	private Boolean getBoolean(Row row, int index){
		Cell cell = row.getCell(index);
		if(cell == null){
			return null;
		}
		return cell.getBooleanCellValue();
	}
}