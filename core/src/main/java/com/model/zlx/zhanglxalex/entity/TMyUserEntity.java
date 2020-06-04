package com.model.zlx.zhanglxalex.entity;

import lombok.Data;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @ClassName TMyUserEntity
 * @Author zhang_lx
 * @Date 2020-06-04 10:20
 * @Version 1.0
 */
@Data
public class TMyUserEntity {

    /**
     * 主键
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

    /**
     * 性别
     */
    private String sex;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
