package com.main;

import com.Utilities.APIBase;
import com.Utilities.JsonIgnoreAttribute;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import org.junit.Assert;

import javax.xml.crypto.Data;


public class StepDefinition {

    public static Logger logger = Logger.getLogger(StepDefinition.class.getName());

    APIBase apiBase = new APIBase();

    @Given("User wants to query product API with {string}")
    public void user_has_product_api_with(String filterCriteria) {
        String finalURI = "http://localhost:3030/products?".concat(filterCriteria);
        DataObjects.setURL(finalURI);
        logger.info("The final URL is : "+ finalURI);
        Assert.assertNull(finalURI);
    }

    @When("User hit the {string} API {string}")
    public void user_hit_api(String HTTPMethod, String testName) throws IOException {
        logger.info("The http method is : "+ HTTPMethod);
        DataObjects.setTestName(testName);
        Boolean testFlag = apiBase.testAPI(DataObjects.getURL(),HTTPMethod, testName);
        Assert.assertTrue(testFlag);
    }

    @Then("User gets successful response")
    public void user_gets_successful_response() {
        if(DataObjects.getTypeOfMethod().equals("POST")){
            Assert.assertEquals(DataObjects.getStatusCode(),201);
        }else{
            Assert.assertEquals(DataObjects.getStatusCode(),200);
        }

    }

    @And("User is able to validate the Output")
    public void validate_output_response() throws IOException {
        String ignoreTags = "updatedAt,createdAt";
        List attributesToIgnore = Arrays.asList(ignoreTags.split(","));
        JSONCompareMode mode = JSONCompareMode.LENIENT;
        JSONCompareResult compareResult;
        String baselineContent = null;
        String compareContent = null;

        baselineContent = new String(Files.readAllBytes(Paths.get("StoredReports/"+DataObjects.getTestName()+"_Set1"+".json")),"UTF-8");
        compareContent = new String(Files.readAllBytes(Paths.get("StoredReports/"+DataObjects.getTestName()+"_Set2"+".json")),"UTF-8");

        if(DataObjects.getTypeOfMethod().equals("POST")){
            compareResult = JSONCompare.compareJSON(baselineContent,compareContent,new JsonIgnoreAttribute(mode, new HashSet<>(attributesToIgnore)));
        }else{
            compareResult = JSONCompare.compareJSON(baselineContent,compareContent,mode);
        }

        String result = compareResult.getMessage();
        String[] finalResult = result.split(";");
        int length = finalResult.length;

        for(int i=0; i< length; i++){
            logger.info("Differences : "+ finalResult[i]);
        }

        if(compareResult.passed()){
          Assert.assertTrue(true);
        }else{
            Assert.fail("There are mismatches in the expected and actual responses");
        }

    }

    @Given("User wants to query category API with {string}")
    public void user_has_category_api(String filterCriteria) {
        String finalURI = "http://localhost:3030/categories?".concat(filterCriteria);
        DataObjects.setURL(finalURI);
        logger.info("The final URL is : "+ finalURI);
        Assert.assertNull(finalURI);
    }

    @Given("User wants to query stores API with {string}")
    public void user_has_stores_api(String filterCriteria) {
        String finalURI = "http://localhost:3030/stores?".concat(filterCriteria);
        DataObjects.setURL(finalURI);
        logger.info("The final URL is : "+ finalURI);
        Assert.assertNull(finalURI);
    }

    @Then("User wants to create new {string} in the database")
    public void create_new_entry(String typeOfEntry) {
        ResourceBundle rb = ResourceBundle.getBundle("requestpayload");
        DataObjects.setTypeOfMethod("POST");

        switch (typeOfEntry){
            case "Product":
                DataObjects.setURL("http://localhost:3030/products");
                DataObjects.setRequestPayload(rb.getString("productRequestPayload"));
                break;
            case "Store":
                DataObjects.setRequestPayload(rb.getString("storeRequestPayload"));
                DataObjects.setURL("http://localhost:3030/stores");
                break;
            case "Service":
                DataObjects.setRequestPayload(rb.getString("serviceRequestPayload"));
                DataObjects.setURL("http://localhost:3030/services");
                break;
            case "Category":
                DataObjects.setRequestPayload(rb.getString("categoryRequestPayload"));
                DataObjects.setURL("http://localhost:3030/categories");
                break;
            default:
                logger.info("Invalid entry");
                break;
        }

    }

}
