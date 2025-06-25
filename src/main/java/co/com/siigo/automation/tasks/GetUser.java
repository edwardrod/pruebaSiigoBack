package co.com.siigo.automation.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUser implements Task {
    private final int pagina;

    public GetUser(int id) {
        this.pagina = id;
    }

    public static GetUser withPage(int id) {
        return instrumented(GetUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/users/")
                        .with(request -> request
                                .header("x-api-key","reqres-free-v1")
                                .queryParam("page",pagina)
        ));
    }
}

