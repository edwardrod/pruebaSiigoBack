package co.com.siigo.automation.tasks;

import co.com.siigo.automation.models.UserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostUser implements Task {
    private final UserData userData;

    public PostUser(UserData userData) {
        this.userData = userData;
    }

    public static PostUser withData(UserData userData) {
        return instrumented(PostUser.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/users").with(request -> request
                        .header("Content-Type", "application/json")
                        .body(userData))
        );
    }
}

