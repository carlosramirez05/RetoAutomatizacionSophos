package pe.promart.www.utils;

import pe.promart.www.model.User;

import java.security.SecureRandom;
import java.util.Map;

/**
 * Clase que contiene métodos comunes para el proyecto
 */

public class CommonFunctions {

    /**
     * Este método de encarga de convertir un MAP en modelo tipo User
     */

    public User convertMapToUserModel(Map<String, String> dataTable) {
        User user = new User();
        user.setFirstName(dataTable.get("first_name"));
        user.setLastName(dataTable.get("last_name"));
        user.setEmail(getRandomString(5) + dataTable.get("email"));
        user.setGender(dataTable.get("gender"));
        user.setStatus(dataTable.get("status"));
        return user;
    }

    /**
     * Este método se encarga de entregar un número aleatorio entre un intervalo determinado
     *
     * @param biggerNumber  Variable tipo int que representa el número mayor del intervalo
     * @param smallerNumber Variable tipo int que representa el número menor del intervalo
     * @return Variable tipo String que representa el número aleatorio elegido entre el intervalo ingresado
     */

    public String getRandomNumberInterval(int biggerNumber, int smallerNumber) {
        int number = (new SecureRandom()).nextInt(biggerNumber - smallerNumber + 1) + smallerNumber;
        return Integer.toString(number);
    }

    /**
     * Este método se encarga de entregar un texto aleatorio con un máximo determinado.
     *
     * @param sizeString Variable tipo int que representa el tamaño que va a tener el texto.
     * @return Variable tipo String que representa el texto aleatorio con su respectivo tamaño.
     */

    public String getRandomString(int sizeString) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "
                + "0123456789 "
                + "abcdefghijklmnopqrstuvxyz ";

        StringBuilder stringBuilder = new StringBuilder(sizeString);

        for (int i = 0; i < sizeString; i++) {
            int index = Integer.parseInt(getRandomNumberInterval(characters.length() - 1, 0));
            stringBuilder.append(characters.charAt(index));
        }

        return stringBuilder.toString().trim();
    }

}
