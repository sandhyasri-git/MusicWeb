package com.music.musicweb.dao;

import java.util.List;

import com.music.musicweb.model.Category;

public interface CategoryDAO {

	public boolean insertCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public Category getCategory(int categoryid);
	public List<Category>getCategories();
}
