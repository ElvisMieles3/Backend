package co.certificacion.reqres.endpoints;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class ConsumeApi {

    public static void typeGet(String endPoint, String foo1, String foo2, Actor actor) {

        actor.attemptsTo(Get.resource(endPoint)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .queryParam("foo1", foo2, " foo1", foo2)));
    }

    public static void typePOST(String endPoint, String body, Actor actor) {

        actor.attemptsTo(Post.to(endPoint)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .relaxedHTTPSValidation("TLS")
                        .body(body)
                        .log().all()));
        SerenityRest.lastResponse().body().prettyPrint();
    }
}
