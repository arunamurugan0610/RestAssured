package sample;

import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;


public class MySecondRestAssuredClass {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        Response response ;
        response = request.get("/BookStore/v1/Books");

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());

        JSONObject requestParams = new JSONObject();
        /*I have put a unique username and password as below,
        you can enter any as per your liking. */
        requestParams.put("userName", "TOOLSQATest220");
        requestParams.put("password", "Welcome1@");

        request.body(requestParams.toJSONString());
        Response response2 = request.post("/Account/v1/User");

        System.out.println(response2.getStatusCode());
        // We will need the userID in the response body for our tests, please save it in a local variable
        ResponseBody body = response2.getBody();
        System.out.println(body.asString());

    }

}