package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

public class UpdateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File( Constant.JSON_REQUEST+"/RequestUpdateUser.json");
        reqresAPI.putUpdatUser(id,json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USERS);
    }

    @And("Validate json schema update user")
    public void validateJsonSchemaUpdateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/UpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Case
    @Given("Put update user with invalid json with id {int}")
    public void putUpdateUserWithInvalidJsonWithId(int id) {
        File json = new File( Constant.JSON_REQUEST+"/RequestUpdateUserInvalid.json");
        reqresAPI.putUpdatUser(id,json);
    }
}
