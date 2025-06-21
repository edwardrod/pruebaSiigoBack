package co.com.siigo.automation.tasks;


import co.com.siigo.automation.models.UserData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUser implements Task {
    private final int id;
    private final UserData userData;

    public PutUser(int id, UserData userData) {
        this.id = id;
        this.userData = userData;
    }

    public static PutUser with(int id, UserData userData) {
        return instrumented(PutUser.class, id, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/api/users/" + id).with(request -> request
                        .header("Content-Type", "application/json")
                        .body(userData))
        );
    }
}
