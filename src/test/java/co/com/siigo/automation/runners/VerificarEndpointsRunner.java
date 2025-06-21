package co.com.siigo.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/back/verificar_endpoints.feature",
        glue = "co.com.siigo.automation.stepdefinitions.back",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class VerificarEndpointsRunner {
}
