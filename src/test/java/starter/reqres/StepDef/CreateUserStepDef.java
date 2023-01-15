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

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/RequestCreateUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USERS);
    }

    @And("Response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("validate json schema create user")
    public void validateJsonSchemaCreateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/CreateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Case with file json_01
    @Given("Post create user with invalid json_01")
    public void postCreateUserWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/RequestCreateUserInvalid_01.json");
        reqresAPI.postCreateUser(json);
    }

    //Negative Case with file json_02
    @Given("Post create user with invalid json_02")
    public void postCreateUserWithInvalidJson_() {
        File json = new File(Constant.JSON_REQUEST + "/RequestCreateUserInvalid_02.json");
        reqresAPI.postCreateUser(json);
    }

    @And("Response body name should be {string}")
    public void responseBodyNameShouldBe(String arg0) {
        File json = new File(Constant.JSON_REQUEST + "/RequestCreateUserInvalid_02.json");
        reqresAPI.postCreateUser(json);
    }

}
