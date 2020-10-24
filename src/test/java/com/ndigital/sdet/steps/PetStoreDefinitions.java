package com.ndigital.sdet.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndigital.sdet.app.model.addPet.AddPetModel;
import com.ndigital.sdet.app.pages.PetstoreController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertEquals;

public class PetStoreDefinitions extends ScenarioSteps {

    @Steps
    private PetstoreController petstoreController = new PetstoreController();
    private AddPetModel addPetResponse;
    private ValidatableResponse findPetByStatusResponse;

    @Given("User Add new Pet API with data:")
    public void userAddNewPetAPIWithData(String body) {
        addPetResponse = petstoreController.addPet(body);
    }

    @Then("Pet response should be:")
    public void petResponseShouldBe(String responseBody) {
        ObjectMapper mapper = new ObjectMapper();
        AddPetModel expected = null;
        try {
            expected = mapper.readValue(responseBody, AddPetModel.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        assertEquals(expected.getCategory().getId(), addPetResponse.getCategory().getId());
        assertEquals(expected.getCategory().getName(), addPetResponse.getCategory().getName());
        assertEquals(expected.getName(), addPetResponse.getName());
        assertEquals(expected.getStatus(), addPetResponse.getStatus());
        for (int i = 0; i == expected.getTags().size(); i++) {
            assertEquals(expected.getTags().get(i), addPetResponse.getTags().get(i));
        }
        for (int i = 0; i == expected.getPhotoUrls().size(); i++) {
            assertEquals(expected.getPhotoUrls().get(i), addPetResponse.getPhotoUrls().get(i));
        }
    }

    @Given("User Find Pet by Status {string}")
    public void userFindPetByStatus(String status) {
        findPetByStatusResponse = petstoreController.getPathByStatus(status);
    }

    @Then("User response should be same with schema and status code {int}")
    public void userResponseShouldBeSameWithSchemaAndStatusCode(int statusCode) {
        findPetByStatusResponse.statusCode(statusCode).assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("scheme/petScheme.json"));
    }


}
