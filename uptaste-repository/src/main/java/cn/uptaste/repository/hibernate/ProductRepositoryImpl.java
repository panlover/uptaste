package cn.uptaste.repository.hibernate;

import cn.uptaste.common.dataaccess.BaseDao;
import cn.uptaste.model.Product;
import cn.uptaste.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by yudeyang on 14-2-22.
 */
@Repository(value = "productRepository")
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private BaseDao baseDao;

    @Override
    public void addProduct(Product product) {
        baseDao.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        baseDao.delete(Product.class,id);
    }

    @Override
    public void updateProduct(Product product) {
        baseDao.update(product);
    }

    @Override
    public Product getProductById(Long id) {
       return baseDao.get(Product.class,id);
    }
}
