package cn.uptaste.service;

import cn.uptaste.model.Customer;
import cn.uptaste.model.Product;
import cn.uptaste.repository.CustomerRepository;
import cn.uptaste.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yudeyang on 14-2-22.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerRepository.getCustomerByUsername(username);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public Customer getCustomerByUsernameAndPassword(String username, String password) {
        return customerRepository.getCustomerByUsernameAndPassword(username,password);
    }

    @Override
    public Product getProductById(Long id){
        return  productRepository.getProductById(id);
    }
}
