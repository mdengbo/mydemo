package com.example.easypoiexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author madengbo
 * @create 2018-11-29 13:56
 * @desc
 * @Version 1.0
 **/
@Controller
@RequestMapping("")
public class ImportByChromeController {

    @RequestMapping("/")
    public String importExcel(){

        return "importExcel";
    }



}
