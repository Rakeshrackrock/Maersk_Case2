package com.ApachePOI;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

public class case2 {
    public static void main(String[] args) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Output");
        XSSFRow row = sheet.createRow(0);

        XSSFCell cell = row.createCell(0);
        cell.setCellValue("Fibo Series");

        // a.Generate Fibonacci series upto 20
        int n = 20, firstTerm = 0, secondTerm = 1;
        int[] arr = new int[20];
        int[] fin = new int[20];
        for (int i = 0; i < n; ++i) {
            arr[i] = firstTerm;
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }

        // b.converting to desc order
        for (int i = 0; i < n; ++i) {
            fin[i] = arr[n - i - 1];
        }
        /*for (int i = 0; i < n; i++) {
            System.out.println(fin[i]);
        }*/

        // c. highlight cell of all the odd numbers in red color
        for (int i = 1; i <= n; i++) {
            sheet.createRow(i);
            if ((fin[i - 1] % 2) != 0) {
                XSSFCellStyle style = workbook.createCellStyle();
                style.setFillForegroundColor(IndexedColors.RED.getIndex());
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                cell = sheet.getRow(i).createCell(0);
                cell.setCellValue(fin[i - 1]);
                cell.setCellStyle(style);
                }
            else {
                sheet.getRow(i).createCell(0).setCellValue(fin[i - 1]);
            }
        }

        // d.Save the excel as 'output.xlsx'
        FileOutputStream file = new FileOutputStream("C:\\Users\\Rakes\\IdeaProjects\\Rakesh_Maersk\\Ouput\\output.xlsx");
        workbook.write(file);
        file.close();
    }
}