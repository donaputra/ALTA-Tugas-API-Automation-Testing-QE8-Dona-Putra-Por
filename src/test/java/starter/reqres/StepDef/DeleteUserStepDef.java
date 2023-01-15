package starter.reqres.StepDef;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USERS);
    }


    //Negative Case

    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidId(int id) {
        reqresAPI.deleteUser(id);
    }
}
