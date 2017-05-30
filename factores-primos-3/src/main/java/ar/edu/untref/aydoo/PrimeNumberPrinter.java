package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.exceptions.InvalidFileException;
import java.io.IOException;
import java.io.PrintWriter;


public class PrimeNumberPrinter {

    PrintWriter printWriter;

    public void printFile(String path, String output) throws InvalidFileException {

        if(path.endsWith(".txt")) {
            String printed = output;
            try {
                printWriter = new PrintWriter(path, "UTF-8");
                printWriter.println(printed);
                printWriter.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
        else{
            throw new InvalidFileException();
        }

    }
}
