package co.com.siigo.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUser implements Task {
    private final int id;

    public DeleteUser(int id) {
        this.id = id;
    }

    public static DeleteUser withId(int id) {
        return instrumented(DeleteUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/api/users/" + id)
        );
    }
}
