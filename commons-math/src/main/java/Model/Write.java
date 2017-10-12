package Model;
//thiti
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Controller.Control;

public class Write {
    public void writeToFile() {
        try {
            Path file = Paths.get("C:\\Users\\USER\\git\\calendar\\commons-math\\test.txt");
            BufferedWriter writer = Files.newBufferedWriter(file, 
                    StandardCharsets.UTF_8);   
            for (int i = 0; i < Control.day1.size(); i++) {
                writer.write(Control.day1.get(i));
                writer.newLine();
                writer.write(Control.month1.get(i));
                writer.newLine();
                writer.write(Control.year1.get(i));
                writer.newLine();
            }
                  
            writer.close();       
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}