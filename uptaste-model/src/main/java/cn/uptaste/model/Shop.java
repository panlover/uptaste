package cn.uptaste.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 普通的店铺
 */
@Entity
@Table(name = "shop")
public class Shop extends NamedEntity {

    //Todo:需要评价系统设计，暂时没有实现
    private Date createTime;
    @Column
    private String status;
    @Column
    private String shortDesc;
    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;
    @OneToMany(mappedBy = "shop")
    private Set<Category> categories;//商店内的物品分类

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
