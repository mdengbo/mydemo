package com.example.easypoiexcel;

import com.example.easypoiexcel.entity.DateTest;
import com.example.easypoiexcel.rep.service.impl.SaveImpl;
import com.example.easypoiexcel.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author madengbo
 * @create 2018-12-04 16:52
 * @desc  地区性目录导入  省、市、县
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AreaImportTest {

    @Autowired
    SaveImpl save;

    @Test
    public void importExcelApp() {
        //需要导入的文件绝对路径
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);


        String filePath = "D:\\excel\\贵州省行政区域.xls";
        //解析excel，
        List<DateTest> PdateTest01 = new ArrayList<>();
        List<DateTest> MdateTest01 = new ArrayList<>();
        try {
            List<DateTest> dateTest = FileUtil.importExcel(filePath, 0, 1, DateTest.class);

            //省级目录
            for (int i = 0; i < dateTest.size(); i++) {
                dateTest.get(i).setCreate_time(dateString);
                dateTest.get(i).setUpdate_time(dateString);
                if (dateTest.get(i).getId().length() == 6) {
                    String id = dateTest.get(i).getId();
                    String id0 = dateTest.get(i).getId().substring(2, 6);

                    //第一层的目录信息
                    if (id0.equals("0000")) {
                        dateTest.get(i).setParent_id("-1");
                        dateTest.get(i).setFull_name(dateTest.get(i).getName());
                        dateTest.get(i).setTree_path(",");
                    }
                }
            }

            //省市级目录
            for (int i = 0; i < dateTest.size(); i++) {
                String id = dateTest.get(i).getId();
                String id0 = id.substring(2, 4);
                String id1 = id.substring(4, 6);
                //省级的id
                String id3 = dateTest.get(i).getId().substring(0, 2)+ "0000";
                //省市级目录
                if (!id0.equals("00") && id1.equals("00")) {

                    for (int j = 0; j < dateTest.size(); j++) {
                        if(dateTest.get(j).getId().equals(id3)){
                            dateTest.get(i).setParent_id(dateTest.get(j).getId());
                            dateTest.get(i).setFull_name(dateTest.get(j).getName() + dateTest.get(i).getName());
                            dateTest.get(i).setTree_path(dateTest.get(j).getId());
                        }
                    }
                }
            }



            for (int i = 0; i < dateTest.size(); i++) {
                if (dateTest.get(i).getId().length() == 6) {
                    String sub = dateTest.get(i).getId().substring(5, 6);
                    //市区级目录
                    if (!sub.equals("0")) {
                        //截取父目录
                        String pstr = dateTest.get(i).getId().substring(0, 4);
                        pstr = pstr + "00";
                        //获取省直辖市
                        for (int j = 0; j < dateTest.size() && !dateTest.get(i).getId().equals(dateTest.get(j).getId()); j++) {
                            if (pstr.equals(dateTest.get(j).getId())) {
                                dateTest.get(i).setParent_id(dateTest.get(j).getId());
                                dateTest.get(i).setFull_name(dateTest.get(j).getFull_name() + dateTest.get(i).getName());
                                dateTest.get(i).setTree_path(dateTest.get(j).getTree_path() + "," + dateTest.get(j).getId());
                            }

                        }
                    }
                }
            }

            for (int i = 0; i < dateTest.size(); i++) {
                //获取市直管区
                //截取父目录
                String sub = dateTest.get(i).getId().substring(4, 6);
                if (dateTest.get(i).getId().length() == 6 && !sub.equals("00")) {

                    String pstr01 = dateTest.get(i).getId().substring(0, 4);
                    for (int j = 0; j < dateTest.size() && !dateTest.get(i).getId().equals(dateTest.get(j).getId()); j++) {

                        if (dateTest.get(j).getId().length() == 6) {
                            String str02 = dateTest.get(j).getId();

                            String sub03 = str02.substring(4, 6);
                            String sub05 = str02.substring(2, 6);
                            String sub04 = str02.substring(0, 4);

                            if (!sub05.equals("0000") && sub03.equals("00") && dateTest.get(i).getId().contains(sub04)) {
                                dateTest.get(i).setParent_id(dateTest.get(j).getId());
                                dateTest.get(i).setFull_name(dateTest.get(j).getFull_name() + dateTest.get(i).getName());
                                dateTest.get(i).setTree_path(dateTest.get(j).getTree_path() + "," + dateTest.get(j).getId());
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < dateTest.size(); i++) {

                if (dateTest.get(i).getId().length() == 8) {
                    //获取第二级父目录
                    String p0 = dateTest.get(i).getId().substring(0, 6);
                    for (int j = 0; j < dateTest.size() - 1 && !dateTest.get(i).getId().equals(dateTest.get(j).getId()); j++) {
                        if (dateTest.get(j).getId().equals(p0)) {
                            //设置父id

                            dateTest.get(i).setParent_id(dateTest.get(j).getId());

                            dateTest.get(i).setFull_name(dateTest.get(j).getName() + dateTest.get(i).getName());

                            dateTest.get(i).setTree_path("," + dateTest.get(j).getId());
                        }
                    }
                }

            }


            for (int i = 0; i < dateTest.size() - 1; i++) {
                if (dateTest.get(i).getId().length() == 9) {
                    //获取第三季目录的数据
                    String p1 = dateTest.get(i).getId().substring(0, 6);
                    String p2 = dateTest.get(i).getId().substring(0, 8);
                    for (int j = 0; j < dateTest.size() && !dateTest.get(i).getId().equals(dateTest.get(j).getId()); j++) {
                        if (dateTest.get(j).getId().equals(p2)) {
                            //设置父id

                            dateTest.get(i).setParent_id(dateTest.get(j).getId());

                            dateTest.get(i).setFull_name(dateTest.get(j).getFull_name() + dateTest.get(i).getName());

                            dateTest.get(i).setTree_path("," + dateTest.get(j).getTree_path() + "," + dateTest.get(j).getId());

                            continue;

                        } else if (dateTest.get(j).getId().equals(p1)) {

                            dateTest.get(i).setParent_id(dateTest.get(j).getId());

                            dateTest.get(i).setFull_name(dateTest.get(j).getFull_name() + dateTest.get(i).getName());

                            dateTest.get(i).setTree_path("," + dateTest.get(j).getTree_path() + "," + dateTest.get(j).getId());
                        }
                    }
                }

            }
          /*  for (int i = 0; i < dateTest.size(); i++) {
                save.save(dateTest.get(i));
            }*/

            log.info("导入数据一共 {} 行", dateTest.size());

            //TODO 保存数据库
        } catch (Exception e) {
            e.printStackTrace();
        }
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入

    }
}
