package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class LoginUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Login with valid user json")
    public void postLoginWithUserValid() {
        File json = new File(Constant.JSON_REQUEST + "/RequestLoginUser.json");
        reqresAPI.loginUser(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USERS);
    }

    @And("Response body name should be token {string}")
    public void responseBodyNameShouldBeToken(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN_USER, equalTo(token)); // TOKEN
    }

    @And("Validate json schema login user")
    public void validateJsonSchemaLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/LoginUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
