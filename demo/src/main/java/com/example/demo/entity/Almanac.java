package com.example.demo.entity;

import lombok.Data;

/**
 * @author madengbo
 * @create 2019-01-27 17:07
 * @desc 日历实体
 * @Version 1.0
 **/
@Data
public class Almanac {
    private String solar;        /* 阳历 e.g.2016年 4月11日 星期一 */
    private String lunar;        /* 阴历 e.g. 猴年 三月初五*/
    private String chineseAra;    /* 天干地支纪年法 e.g.丙申年 壬辰月 癸亥日*/
    private String should;        /* 宜e.g. 求子 祈福 开光 祭祀 安床*/
    private String avoid;        /* 忌 e.g. 玉堂（黄道）危日，忌出行*/

    public Almanac(String solar, String lunar, String chineseAra, String should,
                   String avoid) {
        this.solar = solar;
        this.lunar = lunar;
        this.chineseAra = chineseAra;
        this.should = should;
        this.avoid = avoid;
    }
}
