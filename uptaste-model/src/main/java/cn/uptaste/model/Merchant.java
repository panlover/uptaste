package cn.uptaste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

/**
 * 商户
 */
@Entity
@Table(name = "merchant")
public class Merchant extends User{
    @Column
    private Date createTime;

    @OneToMany(mappedBy = "merchant")
    private Set<Shop> shops;

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
