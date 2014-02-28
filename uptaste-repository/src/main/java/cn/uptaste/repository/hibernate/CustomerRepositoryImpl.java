package cn.uptaste.repository.hibernate;

import cn.uptaste.common.dataaccess.BaseDao;
import cn.uptaste.model.Customer;
import cn.uptaste.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yudeyang on 14-2-22.
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private BaseDao baseDao;

    @Override
    public Customer getCustomerByUsernameAndPassword(String username, String password) {
        String query="from Customer c where c.username=:username and c.password=:password";
        String[] names={"username","password"};
        String[] values={username,password};
        List<Customer> customers= (List<Customer>) baseDao.findByNamedParam(query,names,values);
        return customers.size()>0?customers.get(0):null;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        String hql="from Customer c where c.username=:username";
        List<Customer> customers= (List<Customer>)baseDao.findByNamedParam(hql,"username",username);
        return customers.size()>0?customers.get(0):null;
    }

    @Override
    public void addCustomer(Customer customer) {
        baseDao.save(customer);
    }
}
