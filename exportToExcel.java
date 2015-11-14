

import java.io.File;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class exportToExcel {
	
	public exportToExcel(double[][] data) {
		try{
			WritableWorkbook w = Workbook.createWorkbook(new File("data.xls"));
			WritableSheet sheet = w.createSheet("data", 0);
			sheet.addCell(new Label(1,0,"pi_j"));
			sheet.addCell(new Label(2,0,"p_0j"));
//			sheet.addCell(new Label(3,0,"service time of start at state 0"));
//			sheet.addCell(new Label(4,0,"service time of start at state 1"));
//
			for(int i=1;i<data[0].length+1;i++)
				sheet.addCell(new jxl.write.Number(0,i,i));
			
			for(int i=0;i<data.length;i++)
				for(int j=1;j<data[i].length+1;j++)
					sheet.addCell(new jxl.write.Number(i+1,j,data[i][j-1]));
				
			w.write();
			w.close();
		
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
