package co.com.siigo.automation.questions;


import co.com.siigo.automation.models.UserData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import org.json.JSONObject;

public class ValidarDatosUsuario {

    public static Question<Boolean> con(UserData esperado) {
        return actor -> {
            String respuesta = SerenityRest.lastResponse().getBody().asString();
            JSONObject json = new JSONObject(respuesta);

            String name = json.optString("name");
            String job = json.optString("job");

            return esperado.getName().equals(name) && esperado.getJob().equals(job);
        };
    }
}

