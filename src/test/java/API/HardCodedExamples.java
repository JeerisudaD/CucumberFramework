package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.stringContainsInOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTUzOTY2NzEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY1NTQzOTg3MSwidXNlcklkIjoiMzg2NyJ9.GreGsfHIFLn7uGoF796ycIeVL-nVq-Ocbq50AZEDPe8";
    static String employee_id;

    @Test
    public void aCreateEmployee() {
        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"Rose\",\n" +
                        "  \"emp_lastname\": \"Blackpink\",\n" +
                        "  \"emp_middle_name\": \"L\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2002-03-06\",\n" +
                        "  \"emp_status\": \"Fulltime\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");

        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(201);

        //Hamcrest matchers
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Rose"));

        //using jsonPath(), to specify the key in the body so that it returns the value against it
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
    }

    @Test
    public void bGetCreatesEmployee() {
        RequestSpecification preparedRequest = given().header("Content-Type", "Application/json").
                header("Authorization", token).queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        String tempId = response.jsonPath().getString("employee.employee_id");
        System.out.println(tempId);
        Assert.assertEquals(tempId, employee_id);
    }

    @Test
    public void cUpdateEmployee() {
        RequestSpecification preparedRequest = given().header("Content-Type", "Application/json").
                header("Authorization", token).body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Rose\",\n" +
                        "  \"emp_lastname\": \"BlackPink\",\n" +
                        "  \"emp_middle_name\": \"R\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2001-03-12\",\n" +
                        "  \"emp_status\": \"Part-time\",\n" +
                        "  \"emp_job_title\": \"Entertainment\"\n" +
                        "}");

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void dGetUpdatedEmployee() {
        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void eGetAllEmployee() {
            RequestSpecification request = given().header("Content-Type", "application/json").
                    header("Authorization", token);
            Response response = request.when().get("/getAllEmployees.php");
            //it returns string of response
        String allEmployee = response.prettyPrint();
        //jasonPath() vs jsonPath
        //jsonPath is a class that contains method for converting the values into json object
        //jsonPath() is a method belong to jsonPath class

        //creating object of jsonPath class
        JsonPath js = new JsonPath(allEmployee);

        //retrieving the total number of employees
        int count = js.getInt("Employees.size()");
        System.out.println(count);

        for(int i=0;i<count;i++){
            String empID =js.getString("Employees["+i+"].employee.id");
            System.out.println(empID);
        }
        }
}
