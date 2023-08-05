package utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RestAPITest {
    public static void main(String[] args) {
        /*
        Make get yard API call.
        Request
          1.URL-> BaseUrl & EndPoint-> http://3.137.169.132/en-us/api/v2/yards/10/
          2.Headers -> Authorisation(Token), Accept(application/json)
          3.Method -> Get
        Response
        1.Status code
        2.Json Data

         */

      Response response = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().header("Accept","application/json")
                .when().get("/yards/10/");
//                .then().log().all();

        System.out.println(response.statusCode());
        System.out.println(response.body().asString());

        /*
        Post call
        Request:
            1.URL -> BaseUrl + Endpoint
            2.Headers -> Authorization(Token), Content - Type (application/json), Accept (application/json)
            3.Payload/Body ->json
            4.Method ->Post
        Response:
        1.Status code
        2.Body->json

         */
        Response postResponse = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6" )
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"location\": \"Hanna3\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"6544 E Lillian Ln\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \"Austin \",\n" +
                        "  \"state\": \"TX\",\n" +
                        "  \"zip_code\": \"09875\",\n" +
                        "  \"spots\": \"127\",\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"yard_picture\": [],\n" +
                        "  \"contacts\": [],\n" +
                        "  \"service_phone_number\": [\n" +
                        "    {\n" +
                        "      \"service_phone\": \"\",\n" +
                        "      \"service_contact_name\": \"\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"owner_phone_number\": [\n" +
                        "    {\n" +
                        "      \"owner_phone\": \"\",\n" +
                        "      \"owner_contact_name\": \"\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when().post("/yards/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.body().asString());


        /*
        Patch Call
        Request:
            1.URL -> BaseUrl + Endpoint
            2.Headers -> Authorization(Token), Content - Type (application/json), Accept (application/json)
            3.Payload/Body ->json
            4.Method -> PATCH
         Response:
            1.Status code -> 200
            2.Body->json
         */

        Response updateResponse = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"id\": 61,\n" +
                        "  \"location\": \"Hanna Bryzitska2\",\n" +
                        "  \"name\": \"Y61\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"26544 E Lillian Ln\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \"Austin\",\n" +
                        "  \"state\": \"TX\",\n" +
                        "  \"zip_code\": \"09875\",\n" +
                        "  \"spots\": 127,\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"contacts\": []\n" +
                        "}")
                .when().patch("/yards/61/");

        System.out.println(updateResponse.statusCode());
        System.out.println(updateResponse.body().asString());
    }
}
