package com.example.study.Utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.xssf.usermodel.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liujie
 * @title: ExcelUtils
 * @projectName mall
 * @description: 导出工具类
 * @date 2019/10/1617:21
 */
public class ExcelUtils {

    public static InputStream getUploadExportData(String title, List<Map<String, Object>> list) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        getExcelData(title, wb, list);
        InputStream in = null;
        //临时缓冲区
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //创建临时文件
        wb.write(out);
        byte[] bookByteAry = out.toByteArray();
        in = new ByteArrayInputStream(bookByteAry);
        return in;
    }

    private static void getExcelData(String sheetTitle, XSSFWorkbook wb, List<Map<String, Object>> list) {
        if (CollectionUtils.isEmpty(list)) return;

        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet(sheetTitle);
        sheet.setDefaultColumnWidth(20);
        sheet.createFreezePane(0, 1, 0, 1);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        XSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        XSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        style.setFont(font);
        Set<String> keys = list.get(0).keySet();
        int keyIndex = 0;
        XSSFCell cell = null;
        for (String key : keys) {
            if (key.contains("no_export")) {
                continue;
            }
            sheet.setColumnWidth(keyIndex, (key.length() + 1) * 40 * 15);
            cell = row.createCell(keyIndex++);
            cell.setCellValue(key);
            cell.setCellStyle(style);
        }
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        int index = 1;
        String format = "yyyy-MM-dd HH:mm:ss";
        for (Map<String, Object> map : list) {
            row = sheet.createRow(index++);
            Set<String> sets = list.get(0).keySet();
            int setIndex = 0;
            for (String setKey : sets) {
                if (setKey.contains("no_export")) {
                    continue;
                }
                Object obj = map.get(setKey);
                if (obj == null) {
                    obj = "";
                }
                if (obj instanceof Date) {
                    row.createCell(setIndex++).setCellValue(DateUtil.formate((Date) obj, format));
                } else if (obj instanceof BigDecimal) {
                    XSSFCell cell1 = row.createCell(setIndex++);
                    cell1.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
                    cell1.setCellValue(((BigDecimal) obj).doubleValue());
                } else if (obj instanceof Integer) {
                    XSSFCell cell1 = row.createCell(setIndex++);
                    cell1.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
                    cell1.setCellValue(((Integer) obj).doubleValue());
                } else if (obj instanceof Double) {
                    XSSFCell cell1 = row.createCell(setIndex++);
                    cell1.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
                    cell1.setCellValue(((Double) obj).doubleValue());
                } else if (obj instanceof Instant) {
                    Instant instant = (Instant) obj;
                    row.createCell(setIndex++).setCellValue(DateUtil.formate(Date.from(instant), format));
                } else {
                    row.createCell(setIndex++).setCellValue(String.valueOf(obj));
                }
            }
        }
    }
}
