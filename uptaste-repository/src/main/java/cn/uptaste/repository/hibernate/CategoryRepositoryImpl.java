package cn.uptaste.repository.hibernate;

import cn.uptaste.common.dataaccess.BaseDao;
import cn.uptaste.model.Category;
import cn.uptaste.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by yudeyang on 14-2-22.
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    private BaseDao baseDao;

    @Override
    public void addCategory(Category category) {
        baseDao.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        baseDao.delete(Category.class,id);
    }

    @Override
    public Category getCategoryById(Long id) {
        return baseDao.get(Category.class,id);
    }
}
