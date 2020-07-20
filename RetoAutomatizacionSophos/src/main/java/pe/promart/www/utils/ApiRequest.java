package pe.promart.www.utils;

import pe.promart.www.model.User;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase donde se encuentran los métodos necesarios para realizar
 * los queries de una API
 */

public class ApiRequest {

    /**
     * Query para crear un usuario en Gorest API
     */

    public String createAnUserWithGorestApi(User user) {

        Map<String, String> userGorest = new HashMap<>();
        Gson gson = new Gson();

        userGorest.put("first_name", user.getFirstName());
        userGorest.put("last_name", user.getLastName());
        userGorest.put("gender", user.getGender());
        userGorest.put("email", user.getEmail());
        userGorest.put("status", user.getStatus());

        return gson.toJson(userGorest);
    }

}
