package utils;

import io.restassured.RestAssured;

public class APIConstants {
    public static final String baseURI = RestAssured.baseURI ="http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String GENERATE_TOKEN_URI = baseURI+"/generateToken.php";
    public static final String CREATE_EMPLOYEE_URI =baseURI+"/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE_URI =baseURI+"/getOneEmployee.php";
    public static final String UPDATE_EMPLOYEE_URI =baseURI+"/updateEmployee.php";
    public static final String GET_ALL_EMPLOYEE_URI =baseURI+"/getAllEmployees.php";
    public static final String DELETE_EMPLOYEE_URI =baseURI+"/deleteEmployee.php";
    public static final String UPDATE_PARTIAL_EMPLOYEE_URI =baseURI+"/updatePartialEmplyeesDetails.php";
    public static final String GET_EMPLOYEE_STATUS_URI =baseURI+"/employeementStatus.php";
    public static final String GET_JOB_TITLE_STATUS_URI =baseURI+"/jobTitle.php";

    public static final String HEADER_CONTENT_TYPE ="Content-Type";
    public static final String HEADER_CONTENT_TYPE_VALUE ="Application/json";

    public static final String HEADER_AUTHORIZATION ="Authorization";
}
