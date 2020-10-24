package com.ndigital.sdet.app.pages;


import com.ndigital.sdet.app.model.addPet.AddPetModel;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static net.serenitybdd.rest.SerenityRest.given;

public class PetstoreController {

    private String baseUri = "https://petstore.swagger.io/v2";

    public AddPetModel addPet(String bodyRequest) {
        return given()
                .baseUri(baseUri)
                .log().all()
                .body(bodyRequest)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(AddPetModel.class);
    }

    public ValidatableResponse getPathByStatus(String status) {
        return given()
                .baseUri(baseUri)
                .basePath("/pet")
                .log().all()
                .queryParam("status", status)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get("/findByStatus")
                .then()
                .log().all();
    }


}
