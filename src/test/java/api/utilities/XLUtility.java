package api.utilities;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class XLUtility {
     public FileInputStream fis;
     public XSSFWorkbook workbook;
     public XSSFSheet sheet;
     public XSSFRow row;
     public XSSFCell cell;
     public String path;
     public CellStyle style;


        //"C:\\Users\\MANMATH\\IdeaProjects\\API\\APIAutomation\\testData\\Userdata.xlsx"


    public XLUtility(String path){
        this.path=path;
    }

    public int getRowCount(String sheetName) throws FileNotFoundException {
        try{
            fis=new FileInputStream(path);
            workbook=new XSSFWorkbook(fis);
            sheet= workbook.getSheet(sheetName);
           int rowCount= sheet.getLastRowNum();
           workbook.close();
           fis.close();
           return rowCount;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCellCount(String sheetname, int rowNumber) throws IOException {
        fis=new FileInputStream(path);
        workbook=new XSSFWorkbook(fis);
        sheet= workbook.getSheet(sheetname);
         row= sheet.getRow(rowNumber);
        int cellCount= row.getLastCellNum();
        workbook.close();
        fis.close();
        return cellCount;
    }

    public String getCellData(String sheetname, int rownum, int column) throws IOException {
        fis=new FileInputStream(path);
        workbook=new XSSFWorkbook(fis);
        sheet= workbook.getSheet(sheetname);
        row=sheet.getRow(rownum);
        cell=row.getCell(column);
        DataFormatter formatter=new DataFormatter();
        String data="";
        try {
          data= formatter.formatCellValue(cell);
        }
        catch (Exception e){
            data="";
        }
        workbook.close();
        fis.close();
        return data;
    }

//    public void setCellData(String sheetname, int rownum, int column, String data) throws IOException {
//
//        File xlfile= new File(path);
//        if(!xlfile.exists()){
//            workbook=new XSSFWorkbook();
//            fo=new FileOutputStream(path);
//            workbook.write(fo);
//        }
//             fis=new FileInputStream(xlfile);
//            workbook=new XSSFWorkbook(fis);
//            if(workbook.getSheetIndex(sheetname)==-1)
//                workbook.createSheet(sheetname);
//          sheet= workbook.getSheet(sheetname);
//          if(sheet.getRow(rownum)==null)
//              sheet.createRow(rownum);
//         row= sheet.getRow(rownum);
//    }

}
