package utils;

public class APIPayloadConstants {
    public static String createEmployeePayload(){
        String createEmployee="{\n" +
                "  \"emp_firstname\": \"Lisa\",\n" +
                "  \"emp_lastname\": \"Blackpink\",\n" +
                "  \"emp_middle_name\": \"L\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2002-03-06\",\n" +
                "  \"emp_status\": \"Fulltime\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "}";
    return createEmployee;
    }
}
