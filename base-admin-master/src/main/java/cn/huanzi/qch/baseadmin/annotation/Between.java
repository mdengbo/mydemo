package cn.huanzi.qch.baseadmin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
//运行时作用  会写入class 信息
@Retention(RetentionPolicy.RUNTIME)
public @interface Between {

    /**
     * 最小值的实体属性名
     */
    String min();

    /**
     * 最大值的实体属性名
     */
    String max();
}
