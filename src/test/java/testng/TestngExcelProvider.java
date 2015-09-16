package testng;

/**
 * Created by gridfusion on 15/09/15.
 */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class TestngExcelProvider{
    private static WebDriver driver;
    private static String baseUrl;


    @DataProvider(name = "DP")
    public static String[][] excelRead() throws Exception {
        File excel = new File("/Users/gridfusion/Desktop/tmp/exceldata.xlsx");
        FileInputStream fis = new FileInputStream(excel);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheet("Sheet1");

        int rowNum = ws.getLastRowNum() + 1;
        int colNum = ws.getRow(0).getLastCellNum();
        String[][] data = new String[(rowNum - 1)][colNum];

        int k = 0;
        for (int i = 1; i < rowNum; i++) {
            XSSFRow row = ws.getRow(i);
            for (int j = 0; j < colNum; j++) {
                XSSFCell cell = row.getCell(j);
                String value = cellToString(cell);
                data[k][j] = value;
                System.out.println("the value is: " + value);
            }
            k++;
        }

        return data;
    }


    @Test(dataProvider = "DP")
    public void mytest(String username, String password) throws InterruptedException {

        System.out.println("Output from test: ");
    }




    public static String cellToString(XSSFCell cell) {

        Object result;
        switch (cell.getCellType()) {

            case Cell.CELL_TYPE_NUMERIC:
                result = cell.getNumericCellValue();
                break;

            case Cell.CELL_TYPE_STRING:
                result = cell.getStringCellValue();
                break;

            case Cell.CELL_TYPE_BOOLEAN:
                result = cell.getBooleanCellValue();
                break;

            case Cell.CELL_TYPE_FORMULA:
                result = cell.getCellFormula();
                break;

            default:
                throw new RuntimeException("Unknown Cell Type");
        }

        return result.toString();

    }

}



