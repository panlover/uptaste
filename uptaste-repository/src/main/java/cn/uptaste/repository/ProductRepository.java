package cn.uptaste.repository;

import cn.uptaste.model.Product;

/**
 * Created by yudeyang on 14-2-21.
 */
public interface ProductRepository {
    public void addProduct(Product product);
    public void deleteProductById(Long id);
    public void updateProduct(Product product);
    public Product getProductById(Long id);
}
