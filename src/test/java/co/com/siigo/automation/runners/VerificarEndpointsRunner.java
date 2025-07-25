package co.com.siigo.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/validacion_apis_reqres.feature",
        glue = "co.com.siigo.automation.stepdefinitions",
        tags = "@ValidacionApisReqres",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class VerificarEndpointsRunner {
}

