package pe.promart.www.exceptions;

public class ArticleNotFoundException extends AssertionError{

	/**
	 * Esta clase maneja la excepción si no encuentra el articulo en el carro de compras
	 */

	public static final String ARTICLE_NOT_FOUND = "ERROR, EL ARTICULO NO SE ENCUENTRA EN EL CARRITP DE COMPRAS";
	
	public ArticleNotFoundException(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}

}
