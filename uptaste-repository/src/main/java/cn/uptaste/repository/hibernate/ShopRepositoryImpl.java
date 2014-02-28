package cn.uptaste.repository.hibernate;

import cn.uptaste.common.dataaccess.BaseDao;
import cn.uptaste.model.Shop;
import cn.uptaste.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 14-2-24.
 */
@Repository(value = "shopRepository")
public class ShopRepositoryImpl implements ShopRepository {

    @Autowired
    private BaseDao baseDao;
    @Override
    public void addShop(Shop shop) {
        baseDao.save(shop);
    }

    @Override
    public Shop getShopById(Long id) {
        return baseDao.get(Shop.class,id);
    }
}
