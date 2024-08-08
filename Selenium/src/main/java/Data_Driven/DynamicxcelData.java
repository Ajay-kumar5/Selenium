package Data_Driven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DynamicxcelData
{
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet();

        Scanner src = new Scanner(System.in);

        System.out.println("Enter the number of row");
        int noofrows = src.nextInt();

        System.out.println("Enter the number of cells");
        int noofcells = src.nextInt();

        for(int r = 0; r<=noofrows;r++)
        {
            XSSFRow crow = sheet.createRow(r);
            for (int c = 0;c<noofcells;c++)
            {
                XSSFCell value = crow.createCell(c);
                value.setCellValue(src.next());

            }
        }
        FileOutputStream file = new FileOutputStream("./DynamicExcel.xlsx");
        workbook.write(file);
        workbook.close();
        file.close();

        System.out.println("File is created........");
    }
}
