package cn.uptaste.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * Created by yudeyang on 14-2-21.
 */
@MappedSuperclass
public class User extends NamedEntity {

    @Column
    @NotNull
    protected String username;
    @Column
    @NotNull
    protected String password;
    @Column
    private String status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
