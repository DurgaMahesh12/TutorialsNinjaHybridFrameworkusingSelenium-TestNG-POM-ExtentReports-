package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {

    public static String generateemailwithtimestamp() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("E_MMM_dd_HH_mm_ss_z_yyyy");
        formatter.setTimeZone(TimeZone.getTimeZone("IST")); // Set to Indian Standard Time
        String timestamp = formatter.format(date);
        return "durgamahesh5451" + timestamp + "@gmail.com";
    }
        public static Object[][] GetTestDataFromExcel(String sheetName) throws IOException {
          
            String filePath = "src" + File.separator + "main" + File.separator + "java" + File.separator + 
                              "com" + File.separator + "testdata" + File.separator + "TutorialsTestData.xlsx";

         
            File excelFile = new File(filePath);
            if (!excelFile.exists()) {
                throw new IOException("File not found at path: " + excelFile.getAbsolutePath());
            }
            
 
            FileInputStream fisExcel = new FileInputStream(excelFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fisExcel);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                workbook.close();
                throw new IOException("Sheet not found: " + sheetName);
            }

         
            int rows = sheet.getLastRowNum(); 
            int cols = sheet.getRow(0).getLastCellNum(); 

            
            Object[][] data = new Object[rows][cols];

            for (int i = 0; i < rows; i++) {
                XSSFRow row = sheet.getRow(i + 1); 
                if (row == null) continue;

                for (int j = 0; j < cols; j++) {
                    XSSFCell cell = row.getCell(j);
                    if (cell == null) {
                        data[i][j] = ""; 
                        continue;
                    }

                    org.apache.poi.ss.usermodel.CellType cellType = cell.getCellType();
                    switch (cellType) {
                        case STRING:
                            data[i][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            data[i][j] = String.valueOf((int) cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            data[i][j] = cell.getBooleanCellValue();
                            break;
                        default:
                            data[i][j] = ""; 
                            break;
                    }
                }
            }

          
            workbook.close();
            fisExcel.close();

            return data;
        }
    

       
 
    }
