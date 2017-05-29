package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.exceptions.InvalidFileException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class PrimeNumberPrinter {

    PrintWriter printWriter;

    public void printFile(String path, String output) throws InvalidFileException {

        try {
            printWriter = new PrintWriter(path, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(path.endsWith(".txt")) {
            String printed = output;
            try {
                PrintWriter writer = new PrintWriter(path, "UTF-8");
                writer.println(printed);
                writer.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
        else{
            throw new InvalidFileException();
        }

    }
}
