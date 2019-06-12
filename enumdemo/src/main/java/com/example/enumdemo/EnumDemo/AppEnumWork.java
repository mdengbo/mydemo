package com.example.enumdemo.EnumDemo;

import lombok.extern.slf4j.Slf4j;
/**
 * @author madengbo
 * @DESC  每一个枚举属性 就是一个单独的实例  拥有 AppEnumWork 父类的所有方法和属性，
 */

@Slf4j
public enum AppEnumWork {
    //加班，加班申请必须一天申请一次，不能跨天
    overtime("overtime", "加班") {
        @Override
        public String setWorkInfo(String str) {
           log.info("加班");
            return str;
        }
    },
    //请假，1：可以跨天请，2：去权限系统判断每天是否是假期，假期不算请假时间，3：每天的请假时间按照正常上班时间和申请请假时间取
    //4:统计是按天，所有要分别每天执行统计  5:如果请假了又来打卡，不管他，还是算请假了
    leave("leave", "请假") {
        @Override
        public String setWorkInfo(String str) {
            log.info("请假");
            return str;
        }
    },
    //出差
    //1:出差不需要打外勤卡
    //2:出差可以夸天申请
    business("business", "出差") {
        @Override
        public String setWorkInfo(String str) {
            log.info("出差");
            return str;
        }
    },
    //外勤
    //1:外勤不可以跨天申请，只能一天一天申请
    //2:外勤需要打卡，时间和正常上班时间一样
    outside("outside", "外勤") {
        @Override
        public String setWorkInfo(String str) {
            log.info("外勤");
            return str;
        }
    },
    //supply:补签
    supply("supply", "补签") {
        @Override
        public String setWorkInfo(String str) {
            log.info("补签");
            return str;
        }
    },;

    AppEnumWork(String name, String chineseName) {
        this.name = name;
        this.chineseName = chineseName;
    }

    public String name;
    public String chineseName;

    public abstract String setWorkInfo(String str);

    public static AppEnumWork getApprAppWorkByName(String name) {
        AppEnumWork aaw = null;
        for (AppEnumWork aw : values()) {
            if (aw.name.equals(name)) {
                aaw = aw;
                break;
            }
        }
        return aaw;
    }

}
