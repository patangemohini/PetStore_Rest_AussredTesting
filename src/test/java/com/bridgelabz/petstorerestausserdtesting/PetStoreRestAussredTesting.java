package com.bridgelabz.petstorerestausserdtesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetStoreRestAussredTesting {

    @Test(priority = 0)
    public void acreateUser() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"Mohini\",\n" +
                        "  \"firstName\": \"Mohini\",\n" +
                        "  \"lastName\": \"Patange\",\n" +
                        "  \"email\": \"Mohinipatange39@gmail.com\",\n" +
                        "  \"password\": \"Mohi@1234\",\n" +
                        "  \"phone\": \"9350127300\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test(priority = 1)
    public void buserName() {
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/user/Mohini");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 5)
    public void eupdatedUser() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"Rohini\",\n" +
                        "  \"firstName\": \"Rohini\",\n" +
                        "  \"lastName\": \"Patange\",\n" +
                        "  \"email\": \"rose23@gmail.com\",\n" +
                        "  \"password\": \"rose@1234\",\n" +
                        "  \"phone\": \"9349592321\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/Mohini");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test(priority = 6)
    public void fdeleteUser() {
        Response response = given()
                .accept("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/Rohini");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 3)
    public void ccreateWithList() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 10,\n" +
                        "    \"username\": \"Pooja\",\n" +
                        "    \"firstName\": \"Pooja\",\n" +
                        "    \"lastName\": \"Swami\",\n" +
                        "    \"email\": \"pooja@gmail.com\",\n" +
                        "    \"password\": \"swami@1234\",\n" +
                        "    \"phone\": \"9653645300\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithList");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test(priority = 4)
    public void dlogin() {
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/user/login?username=Mohini&password=Mohi%401234");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void placeAnOrderForAPet() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        " \"id\": 0,\n" +
                        " \"petId\":1,\n" +
                        " \"quantity\": 2,\n" +
                        " \"shipDate\": \"2022-08-23T07:55:34.195Z\",\n" +
                        " \"status\": \"placed\",\n" +
                        " \"complete\": true\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void deletePet() {
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/88230638");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void returnPetinventoriesbystatus() {
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void findPurchesById() {
        Response response = given()
                .accept(ContentType.JSON)
                .queryParam("orderId", "3")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/3");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}

