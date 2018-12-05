package com.example.easypoiexcel.img;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.easypoiexcel.entity.ExportImgModel;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 带有图片的测试服务
 *
 * Created by JueYue on 2017/8/25.
 */
public class ExcelExportHasImgTest {

    List<ExportImgModel> list;

    @Before
    public void initData() {
        list = new ArrayList<>();
        list.add(new ExportImgModel("百度", "http://139.159.241.21:6080/group1/M00/00/B6/wKgANVv_TjGAVGxvAAO6SUSVk_g559.png", "北京市海淀区西北旺东路10号院百度科技园1号楼"));
        list.add(new ExportImgModel("阿里巴巴", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2035844616,1442845443&fm=27&gp=0.jpg", "帅胡歌我"));
        list.add(new ExportImgModel("Lemur", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=778452736,2601703675&fm=26&gp=0.jpg", "你是来搞笑的吗"));
        list.add(new ExportImgModel("一众", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2241109463,438081199&fm=26&gp=0.jpg", "嘿嘿嘿嘿"));

    }

    @Test
    public void exportCompanyImg() throws Exception {

        File savefile = new File("D:/excel/image");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), ExportImgModel.class, list);
        FileOutputStream fos = new FileOutputStream("D:/excel/image/ExcelExportHasImgTest.exportCompanyImg.xls");
        workbook.write(fos);
        fos.close();
    }



}
