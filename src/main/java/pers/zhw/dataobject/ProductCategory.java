package pers.zhw.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Data 省略getter,setter和toString
 * @Entity 实体类,又数据表对应
 * @DynamicUpdata 动态更新,先查数据,更新后一个字段,时间也会更新
 */
@Data
@Entity
@DynamicUpdate
public class ProductCategory {
    /** 类目id. */
    @Id
    @GeneratedValue
    private Integer categoryId;
    /** 类目名字. */
    private String categoryName;
    /** 类目编号. */
    private Integer categoryType;

    public ProductCategory(){}
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
