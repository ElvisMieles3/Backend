package co.certificacion.reqres.stepdefinitions;

import co.certificacion.reqres.endpoints.ConsumeApi;
import co.certificacion.reqres.endpoints.EndPoint;
import co.certificacion.reqres.models.AutenticacionModels;
import co.certificacion.reqres.utils.CreateBody;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.es.Cuando;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.io.File;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class PostmanEcho {

    private EnvironmentVariables envVars;
    private Actor analyst;

    @Before
    public void setUpTheStage() {

        String baseUrl = envVars.optionalProperty("restapi.baseurl").orElseThrow(IllegalArgumentException::new);
        SerenityRest.useRelaxedHTTPSValidation("TLS");
        OnStage.setTheStage(new OnlineCast());
        analyst = Actor.named("Elvis").whoCan(CallAnApi.at(baseUrl));

    }

    @When("The analyst performs the query of the service '(.*)' with the following parameters foo1 = '(.*)' and foo2 = '(.*)'")
    public void theAnalystPerformsTheQueryOfTheServiceClientIdWithTheFollowingParametersFoo1AndFoo2(String service, String foo1, String foo2) {
        ConsumeApi.typeGet(EndPoint.getEndPoint(service), foo1, foo1, analyst);
    }

    @Then("should return the status code '(.*)'")
    public void shouldReturnTheStatusCode(int statusCode) {
        analyst.should(
                seeThatResponse("The user observes the following statusCode",
                        response -> response.statusCode(statusCode))
        );
    }

    @When("The Analyst sends the request with the data:")
    public void theAnalystSendsTheRequestWithTheData(List<Map<String, String>> data) {

        String bodyPost = CreateBody.withTheTemplate(AutenticacionModels.POST).andTheValues(data);
        analyst.remember("bodyPost", bodyPost);

    }

    @Cuando("the Analyst must consume the service '(.*)'")
    public void theAnalystMustConsumeTheService(String service) {
        String bodyCreate = analyst.recall("bodyPost");
        ConsumeApi.typePOST(EndPoint.getEndPoint(service), bodyCreate, analyst);
    }

    @Then("validate response schema")
    public void validateResponseSchema() {
        String resp = SerenityRest.lastResponse().body().asString();
        analyst.should(
                seeThatResponse("The user observes the following response",
                        response -> response.body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/templates/responseSchemaPost.json")))));
    }
}
