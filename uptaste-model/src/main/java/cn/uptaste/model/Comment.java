package cn.uptaste.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户对产品的评论
 */
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity{
    @Column
    private String content;
    @Column
    private Date createTime;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
