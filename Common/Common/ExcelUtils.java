package Common;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    private static Sheet ExcelWSheet;
    private static Workbook ExcelWBook;
    private static org.apache.poi.ss.usermodel.Cell Cell;
    private static org.apache.poi.ss.usermodel.Row Row;


    public static void setExcelFile(String Path, String SheetName) {
        try {
            ExcelWBook = new XSSFWorkbook(Path);
            ExcelWSheet = ExcelWBook.getSheet("Sheet1");
        }
        catch (Exception e) {
        }
    }

   public static int getNumRow() {
       return ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum() ;
   }

    public static String getCellData(int RowNum, int ColNum) {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(Cell);
        } catch (Exception e) {
            return "";
        }
    }

}
