package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviders {

    @DataProvider(name="Data")
    public String[][] getAllData() throws IOException {
       String path= System.getProperty("user.dir")+"//testData//Userdata.xlsx";
       XLUtility xl= new XLUtility(path);
       int  rowCount= xl.getRowCount("Sheet1");
       int cellCount= xl.getCellCount("Sheet1",1);
       String [][] data= new String[rowCount][cellCount];
       for(int i=1; i<rowCount;i++){
           for(int j=0;j<cellCount;j++){
               data[i-1][j]=xl.getCellData("Sheet1",i,j);
           }
       }
       return  data;
    }

    @DataProvider(name ="userNames")
    public String[] getUserNames() throws IOException {
        String path= System.getProperty("user.dir")+"//testData//Userdata.xlsx";
        XLUtility xl= new XLUtility(path);
      int rowXount=  xl.getRowCount("Sheet1");
      String[] userNames= new String[rowXount];
      for(int i=1;i<rowXount;i++){
          userNames[i-1]= xl.getCellData("Sheet1",i,1);
      }
      return userNames;
    }
}
