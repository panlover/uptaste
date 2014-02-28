package cn.uptaste.repository;

import cn.uptaste.model.Customer;

/**
 * Created by yudeyang on 14-2-22.
 */
public interface CustomerRepository {

    public void addCustomer(Customer customer);

    public Customer getCustomerByUsernameAndPassword(String username, String password);

    Customer getCustomerByUsername(String username);
}
