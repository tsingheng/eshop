package net.shangtech.shop.product.service.impl;

import java.util.LinkedList;
import java.util.List;

import net.shangtech.framework.service.BaseService;
import net.shangtech.shop.product.dao.ICategoryDao;
import net.shangtech.shop.product.entity.Category;
import net.shangtech.shop.product.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService extends BaseService<Category> implements ICategoryService {

	@Autowired private ICategoryDao dao;
	
	@Override
	public List<Category> findByParentId(Long parentId) {
		if(parentId == null){
			parentId = Category.DEFAULT_PARENT_ID;
		}
		return dao.findByParentId(parentId);
	}
	
	@Override
	public void save(Category category){
		if(category.getParentId() == null){
			category.setParentId(Category.DEFAULT_PARENT_ID);
		}
		dao.save(category);
	}
	
	@Override
	public void update(Category category){
		if(category.getId() == null){
			save(category);
		}
		else {
			Category old = dao.find(category.getId());
			if(old != null){
				old.setCategoryCode(category.getCategoryCode());
				old.setCategoryName(category.getCategoryName());
				old.setPriority(category.getPriority());
				dao.update(old);
			}
		}
	}
	
	@Override
	public void delete(long id){
		Category category = dao.find(id);
		if(category != null) {
			LinkedList<Category> list = new LinkedList<>();
			list.add(category);
			while(!list.isEmpty()){
				category = list.remove();
				list.addAll(dao.findByParentId(category.getId()));
				dao.delete(category.getId());
			}
		}
	}

	@Override
    public boolean hasChildren(Long id) {
		List<Category> children = dao.findByParentId(id);
	    return children.size() > 0;
    }
	
}
