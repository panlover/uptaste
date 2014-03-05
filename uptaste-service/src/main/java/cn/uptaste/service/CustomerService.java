package cn.uptaste.service;

import cn.uptaste.model.Customer;
import cn.uptaste.model.Product;
import org.springframework.stereotype.Service;

/**
 * 客户服务类
 * Created by yudeyang on 14-2-22.
 */
@Service
public interface CustomerService {
    /**
     * 添加用户
     * @param customer
     */
    public void addCustomer(Customer customer);

    /**
     * 通过用户名和密码找到用户
     * @param username
     * @param password
     * @return
     */
    public Customer getCustomerByUsernameAndPassword(String username,String password);

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    Customer getCustomerByUsername(String username);

    /**
     * 获取产品信息
     * @param id
     * @return
     */
    Product getProductById(Long id);


}
