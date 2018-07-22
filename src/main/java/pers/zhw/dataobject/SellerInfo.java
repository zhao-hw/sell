package pers.zhw.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class SellerInfo {
    @Id
    private String id;
    private String username;
    private String password;
    private String openid;
}
