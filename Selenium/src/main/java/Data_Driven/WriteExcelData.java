package Data_Driven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelData
{
    public static void main(String[] args) throws IOException {



        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet();

        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Java");
        row1.createCell(1).setCellValue("123");
        row1.createCell(2).setCellValue("Tester");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("Selenium");
        row2.createCell(1).setCellValue("2562");
        row2.createCell(2).setCellValue("Automation");

        FileOutputStream file = new FileOutputStream("./Excel.xlsx");
        workbook.write(file);

        workbook.close();
        file.close();

        System.out.println("File is created..........");

    }
}
