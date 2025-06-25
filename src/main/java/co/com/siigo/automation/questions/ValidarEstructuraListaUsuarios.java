package co.com.siigo.automation.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import org.json.JSONArray;
import org.json.JSONObject;

public class ValidarEstructuraListaUsuarios {

    public static Question<Boolean> esValida() {
        return actor -> {
            JSONObject response = new JSONObject(SerenityRest.lastResponse().getBody().asString());

            // Nivel raíz
            if (!response.has("page") || !response.has("per_page") || !response.has("total")
                    || !response.has("total_pages") || !response.has("data") || !response.has("support")) {
                return false;
            }

            JSONArray data = response.getJSONArray("data");
            if (data.isEmpty()) return false;

            for (int i = 0; i < data.length(); i++) {
                JSONObject usuario = data.getJSONObject(i);
                if (!(usuario.has("id") && usuario.has("email")
                        && usuario.has("first_name") && usuario.has("last_name")
                        && usuario.has("avatar"))) {
                    return false;
                }
            }

            return true;
        };
    }
}
