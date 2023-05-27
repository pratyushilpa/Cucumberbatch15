package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUxOTI4MjQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTIzNjAyNCwidXNlcklkIjoiNTI2MyJ9._1Re44Ihh55XgaVKi2YezLJ2aHhAMCOwEgObi62uIP4";
    static String employee_id="";

    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification preparedRequest = given().header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);

        // hitting the endPoint
        Response response= preparedRequest.when().get("getOneEmployee.php");

        response.prettyPrint();

        // verify the response

        response.then().assertThat().statusCode(200);

        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(employee_id,tempEmpId);

    }
    @Test
    public void acreateEmployee(){
        // prepare the request

        RequestSpecification preparedRequest = given().header("Content-type","application/json").
                header("Authorization",token).body("{\n" +
                        "  \"emp_firstname\": \"Joseph475689\",\n" +
                        "  \"emp_lastname\": \"Girgis47345\",\n" +
                        "  \"emp_middle_name\": \"Joe133\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2011-01-01\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"Mechanical Engineer\"\n" +
                        "}");


        // hitting the endPoint
        Response response = preparedRequest.when().post("/createEmployee.php");

        // verifying the assertions
        response.then().assertThat().statusCode(201);

        // we are capturing employee id from the response

       employee_id= response.jsonPath().getString("Employee.employee_id");

        // it will print the output in the console
        response.prettyPrint();

        response.then().assertThat().body("Employee.emp_firstname",equalTo("Joseph475689"));

        response.then().assertThat().body("Employee.emp_lastname",equalTo("Girgis47345"));

        // verify the response headers
        response.then().assertThat().header("Content-Type","application/json");

    }
    @Test
    public void cupdateEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "\"employee_id\": \""+employee_id+"\",\n" +
                        "\"emp_firstname\": \"Joseph235688\",\n" +
                        "\"emp_middle_name\": \"Joe1134\",\n" +
                        "\"emp_lastname\": \"bad\",\n" +
                        "\"emp_birthday\": \"2010-01-01\",\n" +
                        "\"emp_status\": \"Confirmed\",\n" +
                        "\"emp_gender\":\"M\",\n" +
                        "\"emp_job_title\":\"CEO\"\n" +
                        "}");
        Response response =preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);

        // for verification
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));

    }
    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}
