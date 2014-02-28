package cn.uptaste.repository.hibernate;

import cn.uptaste.common.dataaccess.BaseDao;
import cn.uptaste.model.Address;
import cn.uptaste.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yudeyang on 14-2-22.
 */
@Repository(value = "addressRepository")
public class AddressRepositoryImpl implements AddressRepository {

    @Autowired
    private BaseDao baseDao;

    @Override
    public void addAddress(Address address) {
        baseDao.save(address);
    }

    @Override
    public void deleteAddressById(Long id) {
        baseDao.delete(Address.class,id);
    }

    @Override
    public void updateAddress(Address address) {
        baseDao.update(address);
    }

    @Override
    public List<Address> getAddressesByComsomerId(Long id) {
        //todo
        return null;
    }

    @Override
    public Address getAddressById(Long id) {
        return baseDao.get(Address.class,id);
    }
}
