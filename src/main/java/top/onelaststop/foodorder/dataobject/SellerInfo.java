package top.onelaststop.foodorder.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class SellerInfo {
    @Id
    /*卖家ID*/
    private String sellerid;

    /*用户名*/
    private String username;

    /*密码*/
    private String password;

    /*openId*/
    private String openid;


}
