package cn.uptaste.repository;

import cn.uptaste.model.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yudeyang on 14-2-21.
 */
@Repository
public interface AddressRepository {
    public void addAddress(Address address);
    public void deleteAddressById(Long id);
    public void updateAddress(Address address);
    public List<Address> getAddressesByComsomerId(Long id);
    public Address getAddressById(Long id);
}
