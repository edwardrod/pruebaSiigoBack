package co.com.siigo.automation.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Then;
import io.cucumber.java.es.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.hamcrest.Matchers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerificarServiciosStepDefinitions {

    private static final String BASE_URL = "https://reqres.in";

    @When("el usuario envía una solicitud POST al endpoint {string}")
    public void enviarSolicitudPOST(String endpoint, DataTable dataTable) {
        Actor usuario = Actor.named("usuario").whoCan(CallAnApi.at(BASE_URL));
        Map<String, String> body = dataTable.asMaps().get(0);

        usuario.attemptsTo(
                Post.to(endpoint)
                        .with(request -> request.header("Content-Type", "application/json")
                                .body(body))
        );
    }

    @When("el usuario envía una solicitud GET al endpoint {string}")
    public void enviarSolicitudGET(String endpoint) {
        Actor usuario = Actor.named("usuario").whoCan(CallAnApi.at(BASE_URL));

        usuario.attemptsTo(
                Get.resource(endpoint)
        );
    }

    @When("el usuario envía una solicitud PUT al endpoint {string}")
    public void enviarSolicitudPUT(String endpoint, DataTable dataTable) {
        Actor usuario = Actor.named("usuario").whoCan(CallAnApi.at(BASE_URL));
        Map<String, String> body = dataTable.asMaps().get(0);

        usuario.attemptsTo(
                Put.to(endpoint)
                        .with(request -> request.header("Content-Type", "application/json")
                                .body(body))
        );
    }

    @When("el usuario envía una solicitud DELETE al endpoint {string}")
    public void enviarSolicitudDELETE(String endpoint) {
        Actor usuario = Actor.named("usuario").whoCan(CallAnApi.at(BASE_URL));

        usuario.attemptsTo(
                Delete.from(endpoint)
        );
    }

    @Then("la respuesta debería tener el código {int}")
    public void validarCodigoRespuesta(int statusCode) {
        Actor usuario = Actor.named("usuario");
        usuario.should(
                ResponseConsequence.seeThatResponse("Código de respuesta esperado",
                        response -> response.statusCode(statusCode))
        );
    }
}
