package com.example.weixingapi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author madengbo
 * @create 2019-05-21 17:04
 * @desc 请求的素材的接口参数
 * @Version 1.0
 **/
@Data
public class MaterialParam implements Serializable {

    /**
     * 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     * */
    private String type;
    /**
     * 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * */
    private int offset;
    /**
     * 返回素材的数量，取值在1到20之间
     * */
    private int count;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "{"+
                '\"'+"type"+'\"' + ":" +'\"'+type + '\"' +
                ", "+'\"'+"offset"+'\"'+":"+offset +
                ", "+'\"'+"count"+'\"'+":"+count
                +"}"
               ;
    }
}
