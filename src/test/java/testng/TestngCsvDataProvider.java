package testng;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class TestngCsvDataProvider {
	   
    @Test(dataProvider="myDataProvider")
    public void mytest(String[] line) {
      	System.out.println(line[0] + " " + line[1] + " " + line[2] + " " + line[3] + " " + line[4]);				
    }
        

    @DataProvider (name="myDataProvider")     
    public static Iterator<Object[]> createData(){ 
            List<Object[]> myEntries = new ArrayList<Object[]>(); 
            try { 
                    CSVReader reader = new CSVReader(new FileReader("/home/gridfusion/SeleniumTraining/Workspace/selenium/src/test/java/util/data.csv")); 
                    String[] nextLine = null; 
                    while ((nextLine = reader.readNext()) != null){ 
                            myEntries.add(new Object [] {nextLine}); 
                    } 
            } 
            catch (FileNotFoundException e) { 
                    e.printStackTrace(); 
            } catch (IOException e) { 
                    e.printStackTrace(); 
            } 
            
            return myEntries.iterator(); 
    }   
}
