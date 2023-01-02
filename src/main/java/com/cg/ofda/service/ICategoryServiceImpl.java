package com.cg.ofda.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ofda.dto.CategoryDto;
import com.cg.ofda.exception.CategoryException;
import com.cg.ofda.repository.ICategoryRepository;

@Service
public class ICategoryServiceImpl implements ICategoryService {
	@Autowired
	ICategoryRepository categoryRepository;
	

/* @author : Swetha
 * @return : true 
 * @description : This method is to add category.
 */
	@Override
	public CategoryDto addCategory(CategoryDto cat) throws CategoryException{
		if(categoryRepository.existsById(cat.getCatId()))
			throw new CategoryException("Category already exists");
		else {
			return categoryRepository.save(cat);
		
		}
	}
	

/* @author : Swetha
 * @return : true 
 * @description : This method is to update category.
 */
	@Override
	public CategoryDto updateCategory(CategoryDto cat) {
		categoryRepository.save(cat);
		return cat;
	}

	
	/* @author : Swetha
	 * @return : true 
	 * @description : This method is to remove category.
	 */
	@Override
	public CategoryDto removeCategory(String catId) throws CategoryException {
		if(categoryRepository.existsById(catId)) {
		CategoryDto cat = categoryRepository.findById(catId).get();
		categoryRepository.delete(cat);
		return cat;
		}
		else
			throw new CategoryException("Category Id not found");
		
	}
	/* @author : Swetha
	 * @return : true 
	 * @description : This method is to view category.
	 */
	
	@Override
	public CategoryDto viewCategory(String catId) {
		Optional<CategoryDto> findById = categoryRepository.findById(catId);

		return findById.orElseThrow(() -> new CategoryException("There are no category having id:" + catId));
	}

	/* @author : Swetha
	 * @return : true 
	 * @description : This method is to viewAll category.
	 */

	@Override
	public List<CategoryDto> viewAllCategory() throws CategoryException{
		if(categoryRepository.count() > 0) {
		List<CategoryDto> cts = categoryRepository.findAll();
		return cts;
		}
		else throw new CategoryException("Category Records not found");
	}

}
