package system;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWork {
    public static void writeToCSV(String moduleName, double x, double res) throws IOException {
        String fileName = moduleName + ".csv";
        File file = new File(fileName);
        CSVWriter writer;
        if(file.exists()){
            writer = new CSVWriter(new FileWriter(fileName, true));
        } else {
            writer = new CSVWriter(new FileWriter(fileName));
            writer.writeNext(("x,"+ "Result of " + moduleName + "(x)").split(","));
        }
        String[] newRecord = (Double.valueOf(x).toString() + "," +
                Double.valueOf(res).toString()).split(",");
        writer.writeNext(newRecord);
        writer.close();
    }
}
