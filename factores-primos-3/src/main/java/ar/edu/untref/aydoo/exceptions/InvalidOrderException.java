package ar.edu.untref.aydoo.exceptions;

public class InvalidOrderException extends Exception{
    public InvalidOrderException() {
        super();
    }

    @Override
    public String getMessage(){
        return "Orden no aceptado. Las opciones posibles son: asc o desc.";
    }
}
