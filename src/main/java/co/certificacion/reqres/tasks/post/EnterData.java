package co.certificacion.reqres.tasks.post;

import co.certificacion.reqres.endpoints.EndPoint;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class EnterData implements Task {
    private String endpoint;
    private String newRegistration;

    public EnterData(String newRegistration) {

        this.newRegistration = newRegistration;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.to(EndPoint.getEndPoint(endpoint)).with(request -> request
                .header("Content-Type", "application/json").body(newRegistration)));

    }

    public static EnterData withTheInformationOfThe(String newRegistration) {
        return Tasks.instrumented(EnterData.class, newRegistration);
    }

    public EnterData andTheEndPoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }
}
