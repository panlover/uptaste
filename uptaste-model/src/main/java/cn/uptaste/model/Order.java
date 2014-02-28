package cn.uptaste.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by yudeyang on 14-2-21.
 */
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column
    private Date createTime;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private Set<Product> products;
    @Column
    private String status;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
