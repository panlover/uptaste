package cn.uptaste.service;

import cn.uptaste.model.Category;
import cn.uptaste.model.Merchant;
import cn.uptaste.model.Product;
import cn.uptaste.model.Shop;
import cn.uptaste.repository.CategoryRepository;
import cn.uptaste.repository.MerchantRepository;
import cn.uptaste.repository.ProductRepository;
import cn.uptaste.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商户所具有的操作（门面模式）
 * Created by yudeyang on 14-2-22.
 */
@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private ShopRepository shopRepository;

    @Override
    public void addShop(Shop shop) {
        shopRepository.addShop(shop);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Shop getShopById(Long id) {
        return shopRepository.getShopById(id);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.getCategoryById (id);
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.addCategory(category);
    }

    @Override
    public Merchant getMerchantByUsernameAndPassword(String username, String password) {
        return merchantRepository.getMerchantByUsernameAndPassword(username, password);
    }

    @Override
    public Merchant getMerchantByUsername(String username) {
        return merchantRepository.getMerchantByUsername(username);
    }

    @Override
    public void addMerchant(Merchant merchant) {
        merchantRepository.addMerchant(merchant);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
