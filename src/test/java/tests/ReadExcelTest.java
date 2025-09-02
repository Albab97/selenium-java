package tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;

public class ReadExcelTest {
    @Test
    public void testReadDataFromExcel(){
        File file = new File("src/main/resources/testdata/NewExcelFile.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("TestData");
//            System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
//            System.out.println(sheet.getLastRowNum());
//            System.out.println(sheet.getRow(0).getFirstCellNum());
//            System.out.println(sheet.getRow(0).getLastCellNum());
//            System.out.println(sheet.getRow(0).getPhysicalNumberOfCells());
            for (int i = 0; i <=sheet.getLastRowNum();i++){
                for (int j = 0; j<sheet.getRow(i).getPhysicalNumberOfCells();j++){
                    System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t\t");
                }
                System.out.println();
            }

            sheet.getRow(0).createCell(2).setCellValue("Type");
            sheet.getRow(1).createCell(2).setCellValue("user");
            sheet.getRow(2).createCell(2).setCellValue("admin");
            sheet.getRow(3).createCell(2).setCellValue("guest");
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
            workbook.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
