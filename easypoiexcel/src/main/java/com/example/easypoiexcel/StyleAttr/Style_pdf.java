package com.example.easypoiexcel.StyleAttr;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.pdf.styler.IPdfExportStyler;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * @author madengbo
 * @create 2018-11-28 17:32
 * @desc
 * @Version 1.0
 **/
public class Style_pdf implements IPdfExportStyler {

    @Override
    public Document getDocument() {
        return null;
    }

    @Override
    public void setCellStyler(PdfPCell iCell, ExcelExportEntity entity, String text) {
        iCell.setBackgroundColor(BaseColor.GRAY);
        iCell.setColspan(1);
    }

    @Override
    public Font getFont(ExcelExportEntity entity, String text) {

        return null;
    }
}
