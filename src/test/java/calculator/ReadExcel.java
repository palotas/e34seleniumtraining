/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package calculator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

	@DataProvider (name = "data", parallel = false)
	public Object[][] getExcelData() throws InvalidFormatException, IOException{
		ReadExcel read = new ReadExcel();
		return read.getCellData("C:\\Users\\mpalotas\\tmp\\axadata-single.xlsx", "Sheet1");
	}


	public String[][] getCellData(String path, String sheet) throws InvalidFormatException, IOException {
		FileInputStream stream = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(stream);
		Sheet s = workbook.getSheet(sheet);
		int rowcount = s.getLastRowNum();
		int cellcount = s.getRow(0).getLastCellNum();
		String data[][] = new String[rowcount][cellcount];
		for (int i = 1; i <= rowcount; i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < cellcount; j++) {
				Cell c = r.getCell(j);
				try {
					if (c.getCellType() == c.CELL_TYPE_STRING) {
						data[i - 1][j] = c.getStringCellValue();
					}
					else
					{
						data[i - 1][j] = String.valueOf(c.getNumericCellValue());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
}