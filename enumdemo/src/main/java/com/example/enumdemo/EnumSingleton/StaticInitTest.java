package com.example.enumdemo.EnumSingleton;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madengbo
 * @create 2019-05-31 08:20
 * @desc
 * @Version 1.0
 **/
@Data
public class StaticInitTest {
    private static List<Integer> dataList = null;

    static{
        dataList = Singleton.INSTANCE.init();
    }

    /**
     *
     * 单例模式来填充数据
     *
     * @author madengo
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    private static enum Singleton {
        /**
         * 实例
         * */
        INSTANCE;
        private List<Integer> list;

        private Singleton(){
            fillData();
        }
        /**
         *
         * 初始化数据
         *
         * @see [相关类/方法](可选)
         * @since [产品/模块版本](可选)
         */
        private void fillData(){
            list = new ArrayList<Integer>(5);
            for(int i =1; i<6; i++){
                list.add(i);
            }
        }

        /**
         *
         * 初始化的入口
         *
         * @see [相关类/方法](可选)
         * @since [产品/模块版本](可选)
         */
        public List<Integer> init(){
            return list;
        }
    }
}