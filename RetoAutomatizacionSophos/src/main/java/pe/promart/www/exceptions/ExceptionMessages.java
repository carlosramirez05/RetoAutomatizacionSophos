package pe.promart.www.exceptions;

/**
 * Esta clase se usa para controlar los mensajes que se mostrarán cuando
 * la automatización falle en unos casos específicos
 */

public enum ExceptionMessages {

    EXCEPTIONS_ERROR_CREATE_REQUEST( "The user creation was failed"),
    EXCEPTIONS_ERROR_QUERY_REQUEST( "The query request was failed"),
    EXCEPTIONS_ERROR_QUERY_RESPONSE("The response was failed");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
