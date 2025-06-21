package co.com.siigo.automation.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUser implements Task {
    private final int id;

    public GetUser(int id) {
        this.id = id;
    }

    public static GetUser withId(int id) {
        return instrumented(GetUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/users/" + id)
        );
    }
}

