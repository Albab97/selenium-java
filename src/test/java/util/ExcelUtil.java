package util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {
    @Test
    public static Object[][] readDataFromExcel(String sheetname){
        Object[][] obj=null;
        File file = new File("src/main/resources/testdata/NewExcelFile.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetname);
            obj=new Object[sheet.getLastRowNum()][];
            for (int i=1;i<=sheet.getLastRowNum();i++){
                obj[i-1]=new Object[sheet.getRow(i).getPhysicalNumberOfCells()];
                for (int j=0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++){
                    System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
                    obj[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
}
