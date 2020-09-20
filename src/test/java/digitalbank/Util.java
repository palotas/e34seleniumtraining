/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbank;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Util {



    public String authenticate_admin() {

        Response token = given().when().post("http://localhost:8080/bank/api/v1/auth?password=Demo123!&username=admin@demo.io").
                            then().
                            contentType(ContentType.JSON).extract().response();

        String tkn = token.path("authToken");
        System.out.println(tkn);
        return tkn;

    }

    public String authenticate_user() {

        Response token = given().when().post("http://localhost:8080/bank/api/v1/auth?password=MyPa$$word123&username=rbi1@test.com").
                then().
                contentType(ContentType.JSON).extract().response();

        String tkn = token.path("authToken");
        System.out.println(tkn);
        return tkn;

    }

    @Test
    public void find_user_rbiclient1() {

        Response response = given().
                auth().oauth2(authenticate_admin()).
                when().get("http://localhost:8080/bank/api/v1/user/find?username=palotas@gmail.com").then().assertThat().statusCode(200).and().
                contentType(ContentType.JSON).extract().response();

        response.print();
        int id = response.path("id");
        System.out.println("UserID: " + id );

        //return id;
    }



    @Test(groups = "prep")
    public void createUser(String username) {

        RestAssured.baseURI ="http://localhost:8080/bank/api/v1";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("address", "Teichweg 8, 8853 Lachen");
        requestParams.put("country", "Switzerland");
        requestParams.put("dob", "08/28/1972");
        requestParams.put("emailAddress", username);
        requestParams.put("firstName",  "Michael");
        requestParams.put("gender",  "M");
        requestParams.put("homePhone",  "0796690708");
        requestParams.put("lastName",  "Palotas");
        requestParams.put("locality",  "none");
        requestParams.put("mobilePhone",  "0796690708");
        requestParams.put("password",  "MyPa$$word123");
        requestParams.put("postalCode",  "8853");
        requestParams.put("region",  "SZ");
        requestParams.put("ssn",  "123-45-6789");
        requestParams.put("title",  "Mr.");
        requestParams.put("workPhone",  "0796690708");

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());

        Response response = request.auth().oauth2(authenticate_admin()).
                when().post("/user?role=USER").
                then().assertThat().statusCode(201).and().
                contentType(ContentType.JSON).extract().response();

                response.print();
    }



    public int findUser(String username) {
        RestAssured.baseURI ="http://localhost:8080/bank/api/v1";
        RequestSpecification request = RestAssured.given();
        Response response = request.auth().oauth2(authenticate_admin()).
                when().get("/user/find?username=" + username).
                then().assertThat().statusCode(200).and().
                contentType(ContentType.JSON).extract().response();


        int id = response.path("id");
        System.out.println("USER ID: " + id);
        return id;
    }



/*    public void deleteUser(int id) {
        RestAssured.baseURI ="http://localhost:8080/bank/api/v1";
        RequestSpecification request = RestAssured.given();
        request.auth().oauth2(authenticate_admin()).
                when().delete("/user/"+ id).
                then().assertThat().statusCode(204);

    }*/

    public void deleteUser(String username) {
        RestAssured.baseURI ="http://localhost:8080/bank/api/v1";
        RequestSpecification request = RestAssured.given();
        request.auth().oauth2(authenticate_admin()).
                when().delete("/user/"+ findUser(username)).
                then().assertThat().statusCode(204);

    }
    @Test
    public void createAccountAndMake10KInitialDeposit() {

        RestAssured.baseURI ="http://localhost:8080/bank/api/v1";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("accountName", "main checking account");
        requestParams.put("accountTypeCode", "SCK");
        requestParams.put("openingDeposit", "10000");
        requestParams.put("ownerTypeCode", "IND");


        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());

        Response response = request.auth().oauth2(authenticate_admin()).
                when().post("/user/" + findUser("rbi1@test.com") + "/account").
                then().contentType(ContentType.JSON).extract().response();
        //then().assertThat().statusCode(201);
        response.print();
    }

    public void getCheckingAccountsAndVerify5KBalance() {

        RestAssured.baseURI ="http://localhost:8080/bank/api/v1";
        RequestSpecification request = RestAssured.given();
        Response response = request.auth().oauth2(authenticate_admin()).
                when().get("/user/" + findUser("rbi1@test.com") + "/account/checking").
                then().assertThat().statusCode(200).and().
                assertThat().body("", Matchers.hasSize(1)).and().extract().response();

        //System.out.println((response.path("currentBalance")).toString());
        Assert.assertEquals((response.path("currentBalance")).toString(), "[5000.0]");

    }

    @Test(groups = {"prep"})
    public void wholeChain() {
        deleteUser("joesmith@test.com");
        //deleteUser("rbi1@test.com");
        //createUser("rbi1@test.com");
        //createAccountAndMake10KInitialDeposit();
        //getCheckingAccountsAndVerify5KBalance();


    }



}
