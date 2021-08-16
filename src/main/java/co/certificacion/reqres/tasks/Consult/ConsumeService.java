package co.certificacion.reqres.tasks.Consult;

import co.certificacion.reqres.tasks.post.EnterData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;

public class ConsumeService implements Task {
    private String endpoint;

    public ConsumeService(String endpoint) {

        this.endpoint = endpoint;
    }

    public static ConsumeService withTheFollowingEndPoint(String endpoint) {
        return Tasks.instrumented(ConsumeService.class, endpoint);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (endpoint) {

            case "post":
                String registerNewUser = OnStage.theActorInTheSpotlight().recall("bodyPost");
                actor.attemptsTo(EnterData.withTheInformationOfThe(registerNewUser).andTheEndPoint(endpoint));
                break;
        }
    }
}
