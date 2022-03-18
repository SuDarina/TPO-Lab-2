package system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class CsvWork {
    public static void writeToCSV(String moduleName, double x, double res) throws IOException {
        String fileName = moduleName + ".csv";
        File file = new File(fileName);
        FileWriter writer;
        if(file.exists()){
           writer = new FileWriter(fileName, true);
        } else {
            writer = new FileWriter(fileName);
            writer.write("\"x\","+ "\"Result of " + moduleName + "(x)\"\n");
        }
        writer.write(Double.valueOf(x).toString() + "," + res + "\n");
        writer.flush();

        writer.close();
    }
}
