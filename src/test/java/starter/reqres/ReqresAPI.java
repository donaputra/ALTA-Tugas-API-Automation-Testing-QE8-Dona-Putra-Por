package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {

    public static  String BASE_URL ="https://reqres.in"; // ini base url

    public static final String DIR = System.getProperty("user.dir"); //ini untuk mendapatkan sstem properti location project

    //path
    public static String JSON_REQUEST = DIR+"/src/test/resources/JSON/Request"; //path json Request

    public  static  String GET_LIST_USERS =  BASE_URL+ "/api/users?page={page}"; // untuk URL get list users

    public static String POST_CREATE_USERS = BASE_URL + "/api/users"; // untuk URL post create users
    public static String PUT_UPDATE_USERS = BASE_URL+ "/api/users/{id}"; // untuk URL put create users

    public static String DELETE_USERS = BASE_URL+ "/api/users/{id}"; // untuk URL delete users

    //Method
    @Step("Get list users")
    public  void getListUsers(int page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Post create user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public  void putUpdatUser(int id, File json){
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON )
                .body(json);
    }

    @Step ("Delet user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }

}
