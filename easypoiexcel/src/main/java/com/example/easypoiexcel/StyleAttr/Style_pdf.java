package com.example.easypoiexcel.StyleAttr;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.pdf.styler.IPdfExportStyler;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author madengbo
 * @create 2018-11-28 17:32
 * @desc .pdf 导出文本样式 utils
 * @Version 1.0
 **/
@Slf4j
public class Style_pdf implements IPdfExportStyler {

    private static final short FONT_SIZE_FIVE= 5;

    private static final short FONT_SIZE_TEN = 10;

    private static final short FONT_SIZE_ELEVEN = 11;

    private static final short FONT_SIZE_TWELVE = 12;

    private static final short FONT_SIZE_TWETY = 20;

    @Override
    public Document getDocument() {
        Document document = new Document(PageSize.A4, 36, 36, 24, 36);
        return document;
    }

    @Override
    public void setCellStyler(PdfPCell iCell, ExcelExportEntity entity, String text) {
        iCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        iCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        iCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
    }

    @Override
    public Font getFont(ExcelExportEntity entity, String text) {
        try {
            //用以支持中文
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);
            Font font = new Font(bfChinese);
            font.setSize(FONT_SIZE_TEN);
            return font;
        } catch (DocumentException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        Font font = new Font(Font.FontFamily.UNDEFINED);
        return font;
    }


}
