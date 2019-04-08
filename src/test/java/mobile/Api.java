/*
 * Copyright (c) 2014 - 2019.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package mobile;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Api {

    @Test(enabled = true)
    public void restassured() {
        // Create new JSON Object
        JsonObject loginCredentials = new JsonObject();


        loginCredentials.addProperty("type", "hourly");
        loginCredentials.addProperty("model", "Galaxa S7");
        loginCredentials.addProperty("date", "-1");
        loginCredentials.addProperty("startHour", "18");
        loginCredentials.addProperty("noOfHours", "1");

        RestAssured.baseURI = "https://testondemand.corp.intraxa/api/reserve";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        //httpRequest.body(loginCredentials.toString());

        Response response = httpRequest.get("/");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().prettyPrint());

    }
}
