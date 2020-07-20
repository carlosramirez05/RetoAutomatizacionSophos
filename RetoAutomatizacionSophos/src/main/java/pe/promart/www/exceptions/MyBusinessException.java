package pe.promart.www.exceptions;

/**
 * Clase que maneja las excepciones
 */

public class MyBusinessException extends RuntimeException{

    public MyBusinessException(String message) {
        super(message);
    }

}
