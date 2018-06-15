import java.io.File;
import java.io.IOException;
import jxl.*;
import jxl.write.*;
import jxl.read.biff.BiffException; 
import java.util.Scanner;


public class Validator {

	private static String prePath = "C:\\Users\\Aaron\\workspace\\Excel\\";
	/**
	 * Does NOT work with .xlsx!! only .xls. Sipmle listing of contents for foundation of other project.
	 * 
	 * 
	 * @param args
	 * @throws IOException
	 * @throws BiffException
	 */
	public static void main(String[] args) throws IOException, BiffException {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the file name : ");

		String filename = scn.nextLine();
		//.xlsx does not work
		String path = prePath + filename + ".xls";
		System.out.println(path);
		Workbook workbook = Workbook.getWorkbook(new File(path));
		
		for(Sheet s : workbook.getSheets())
		{
			System.out.println("Entering sheet : " + s.getName());
			System.out.println("num rows = " + s.getRows());
			System.out.println("num cols = " + s.getColumns());

			for(int row = 0; row < s.getRows(); row++)
			{
				for(int column = 0; column < s.getColumns(); column++)
				{
					if(s.getCell(column, row) == null || s.getCell(column, row).getContents() == "")
					{
						continue;
					}
					System.out.println(s.getCell(column, row).getContents());
				}
			}
			System.out.println("-----end of current sheet-----");
		}
		
		
		
		workbook.close();
		scn.close();
	}

}
