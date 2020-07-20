package pe.promart.www.integrations;

import pe.promart.www.model.User;
import com.google.gson.Gson;
import net.serenitybdd.core.Serenity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static pe.promart.www.utils.Constants.*;

/**
 * Esta clase contiene los métodos necesarios para realizar peticiones
 * HTTP en el consumo de las API's
 */

public class GorestApiHttpRequest {

    /**
     * Método que setea los header y la autorizacion para el consumo de la api.
     * @param json = Cuerpo del mansaje.
     * @return Retorna un metodo httpPost.
     */

    public HttpPost setPostAuthorization(String json) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(BASE_URL + POST_PATH);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Authorization", TOKEN_ACCES);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        return httpPost;
    }

    /**
     * Método que guarda la respuesta de la api y asigna el id del usuario creado
     * en una variable global llamada "id".
     */

    public void responseHttpPostMethod(String responseBody){
        Gson gson = new Gson();
        Map<String, Object> mapResponse =  gson.fromJson(responseBody, Map.class);
        Map<String, Object> result = (Map<String, Object>) mapResponse.get("result");
        String id = result.get("id").toString();
        Serenity.setSessionVariable("id").to(id);
    }

    /**
     * Método que realiza la autorizacion de acceso a la api.
     * @return Retorna un metodo httpGet.
     */

    public HttpGet setGetAuthorization(){
        String id = Serenity.sessionVariableCalled("id");
        HttpGet httpGet = new HttpGet(BASE_URL + GET_PATH + id);
        httpGet.setHeader("Authorization", TOKEN_ACCES);
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        return httpGet;
    }


    /**
     * Método que se encarga de guardar los valores de la respuesta Get.
     * @param responseBody
     */

    public void responseHttpGetMethod(String responseBody){
        User user = new User();
        Gson gson = new Gson();
        Map<String, Object> mapResponse =  gson.fromJson(responseBody, Map.class);
        Map<String,Object> result=  (Map<String,Object>) mapResponse.get("result");
        user.setFirstName(result.get("first_name").toString());
        user.setLastName(result.get( "last_name").toString());
        user.setStatus(result.get("status").toString());
        user.setGender(result.get("gender").toString());
        user.setEmail(result.get("email").toString());
        Serenity.setSessionVariable("userResultApi").to(user);
    }
}
