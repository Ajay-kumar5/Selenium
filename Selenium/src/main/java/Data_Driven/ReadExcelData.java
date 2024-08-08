package Data_Driven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelData
{
    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream("D:\\Test Data\\Excel TestData1.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet Sheet = workbook.getSheet("Sheet1");
        //XSSFSheet sheet = workbook.getSheetAt(0);

        int totalrows = Sheet.getLastRowNum();

        int totalcells = Sheet.getRow(1).getLastCellNum();

        System.out.println("number of rows: "+totalrows);
        System.out.println("number of cells: "+totalcells);

        for(int r = 0;r<=totalrows;r++)
        {
            XSSFRow crows = Sheet.getRow(r);

            for(int c = 0;c<totalcells;c++)
            {
                XSSFCell ccells = crows.getCell(c);
                System.out.print(ccells.toString()+"\t");
            }
            System.out.println();
        }

        workbook.close();
        file.close();


    }
}
