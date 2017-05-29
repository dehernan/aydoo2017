package ar.edu.untref.aydoo.exceptions;

public class InvalidFileException extends Exception {
    public InvalidFileException() {
        super();
    }

    @Override
    public String getMessage(){
        return "El archivo debe ser especificado con formato .txt";
    }
}
