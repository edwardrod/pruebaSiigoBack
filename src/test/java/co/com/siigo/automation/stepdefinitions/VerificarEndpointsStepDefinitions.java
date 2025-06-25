package co.com.siigo.automation.stepdefinitions;

import co.com.siigo.automation.models.UserData;
import co.com.siigo.automation.questions.ResponseCode;
import co.com.siigo.automation.questions.ValidarDatosUsuario;
import co.com.siigo.automation.questions.ValidarEstructuraListaUsuarios;
import co.com.siigo.automation.tasks.DeleteUser;
import co.com.siigo.automation.tasks.GetUser;
import co.com.siigo.automation.tasks.PostUser;
import co.com.siigo.automation.tasks.PutUser;
import co.com.siigo.automation.utils.DataTransformer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class VerificarEndpointsStepDefinitions {

    private Actor actor;
    private UserData userData;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Eduar")
                .whoCan(net.serenitybdd.screenplay.rest.abilities.CallAnApi.at("https://reqres.in"));
    }

    @When("el usuario envía una solicitud POST")
    public void elUsuarioEnvíaUnaSolicitudPOST(DataTable dataTable) {
        userData = DataTransformer.fromDataTable(dataTable);
        actor.attemptsTo(PostUser.withData(userData));
    }

    @Then("la respuesta debería tener el código {int}")
    public void laRespuestaDeberíaTenerElCódigo(int statusCode) {
        actor.should(
                seeThat("el código de respuesta", ResponseCode.is(), equalTo(statusCode))
        );
    }

    @Then("los datos del usuario deberían coincidir con los enviados")
    public void losDatosDelUsuarioDeberíanCoincidirConLosEnviados() {
        actor.should(
                seeThat("Los datos devueltos deben coincidir",
                        ValidarDatosUsuario.con(userData))
        );
    }

    @When("el usuario envía una solicitud GET pagina {int}")
    public void elUsuarioEnvíaUnaSolicitudGETPagina(int pagina) {
        actor.attemptsTo(GetUser.withPage(pagina));
    }

    @And("la respuesta debería contener los datos del usuario")
    public void laRespuestaDeberíaContenerLosDatosDelUsuario() {
        actor.should(
                seeThat(ValidarEstructuraListaUsuarios.esValida()));
    }

    @When("el usuario envía una solicitud PUT")
    public void elUsuarioEnvíaUnaSolicitudPUT(DataTable dataTable) {
        userData = DataTransformer.fromDataTable(dataTable);
        actor.attemptsTo(PutUser.with(3,userData));

    }

    @When("el usuario envía una solicitud DELETE con ID {int}")
    public void elUsuarioEnvíaUnaSolicitudDELETEConID(int id) {
        actor.attemptsTo(DeleteUser.withId(id));
    }
}
