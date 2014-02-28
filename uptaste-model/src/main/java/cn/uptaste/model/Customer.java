package cn.uptaste.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by yudeyang on 14-2-21.
 */
@Entity
@Table(name = "customer")
public class Customer extends User{
    @Column
    @Email
    private String email;
    @Column
    private Date createTime;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Order> orders;
    @OneToMany(mappedBy = "customer")
    private Set<Comment> comments;
    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
