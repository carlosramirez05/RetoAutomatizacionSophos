package pe.promart.www.task;

import pe.promart.www.exceptions.MyBusinessException;
import pe.promart.www.integrations.GorestApiHttpRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static pe.promart.www.exceptions.ExceptionMessages.EXCEPTIONS_ERROR_QUERY_RESPONSE;
import static pe.promart.www.exceptions.ExceptionMessages.EXCEPTIONS_ERROR_CREATE_REQUEST;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 *Esta clase realiza la petición POST en Gorest API
 */

public class PostInformationOnGorestApi implements Task {

    private String json;
    private CloseableHttpClient clientHTTP = HttpClients.createDefault();

    public PostInformationOnGorestApi(String json) {
        this.json = json;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {

            HttpPost httpPost = new GorestApiHttpRequest().setPostAuthorization(json);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws IOException {
                    if (response.getStatusLine().getStatusCode() >= 400){
                        throw new MyBusinessException(EXCEPTIONS_ERROR_CREATE_REQUEST.getMessage());
                    }
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                }
            };

            String responseBody = this.clientHTTP.execute(httpPost,responseHandler);
            new GorestApiHttpRequest().responseHttpPostMethod(responseBody);

        }catch (IOException e){
            throw new MyBusinessException(EXCEPTIONS_ERROR_QUERY_RESPONSE.getMessage());
        }
    }

    public static PostInformationOnGorestApi withData(String json) {
        return instrumented(PostInformationOnGorestApi.class,json);
    }

}
