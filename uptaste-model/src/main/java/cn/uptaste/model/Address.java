package cn.uptaste.model;

/**
 * Created by yudeyang on 14-2-21.
 */

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends NamedEntity {
    @Column
    private String cellPhone;
    @Column
    private String telphone;
    @Column
    private String isDefault;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
