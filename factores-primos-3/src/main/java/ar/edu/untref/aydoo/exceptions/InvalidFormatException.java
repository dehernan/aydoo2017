package ar.edu.untref.aydoo.exceptions;

public class InvalidFormatException extends Exception{

    public InvalidFormatException() {
        super();
    }

    @Override
    public String getMessage(){
        return "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
    }
}
