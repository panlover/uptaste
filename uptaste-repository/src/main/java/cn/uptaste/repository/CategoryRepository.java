package cn.uptaste.repository;

import cn.uptaste.model.Category;
import cn.uptaste.model.Merchant;

/**
 * Created by yudeyang on 14-2-21.
 */
public interface CategoryRepository {

    public void addCategory(Category category);

    public void deleteCategory(Long id);

    Category getCategoryById(Long id);
}
