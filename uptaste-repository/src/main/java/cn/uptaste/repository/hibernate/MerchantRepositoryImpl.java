package cn.uptaste.repository.hibernate;

import cn.uptaste.common.dataaccess.BaseDao;
import cn.uptaste.model.Merchant;
import cn.uptaste.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yudeyang on 14-2-22.
 */
@Repository
public class MerchantRepositoryImpl implements MerchantRepository {

    @Autowired
    private BaseDao baseDao;

    @Override
    public Merchant getMerchantByUsername(String username) {
        String hql="from Merchant c where c.username=:username";
        List<Merchant> merchants= (List<Merchant>)baseDao.findByNamedParam(hql,"username",username);
        return merchants.size()>0?merchants.get(0):null;
    }

    @Override
    public void addMerchant(Merchant merchant) {
        baseDao.save(merchant);
    }

    @Override
    public Merchant getMerchantByUsernameAndPassword(String username, String password) {
        String query="from Merchant c where c.username=:username and c.password=:password";
        String[] names={"username","password"};
        String[] values={username,password};
        List<Merchant> merchants= (List<Merchant>) baseDao.findByNamedParam(query,names,values);
        return merchants.size()>0?merchants.get(0):null;
    }
}
