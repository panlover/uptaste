package cn.uptaste.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 每个店铺可以有自己商店的菜肴分类
 */
@Entity
@Table(name = "category")
public class Category extends NamedEntity{
    @Column
    private String shortDesc;
    @Column
    private String status;
    @ManyToOne
    @JoinColumn(name ="shop_id")
    private Shop shop;
    @ManyToOne //多对一的关联
    @JoinColumn(name="pid")//这是自关联的pid列名设置
    private Category parent;
    @OneToMany(mappedBy="parent")//一对多，mappedBy="parent"表示由parent主导（即在parent端有值）
    private Set<Category> children=new HashSet<Category>();

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Set<Category> getChildren() {
        return children;
    }

    public void setChildren(Set<Category> children) {
        this.children = children;
    }
}
