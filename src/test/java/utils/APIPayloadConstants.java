package utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    public static String createEmployeePayload() {
        String createEmployee = "{\n" +
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

    public static String createEmployeePayloadViaJson () {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Lisa");
        obj.put("emp_lastname", "Blackpink");
        obj.put("emp_middle_name", "L");
        obj.put("emp_gender", "female");
        obj.put("emp_birthday", "002-03-06");
        obj.put("emp_status", "fulltime");
        obj.put("emp_job_title", "QA");

        return obj.toString();
    }

    public static String createEmployeeDynamic
            (String firstName, String lastName, String middleName,
             String gender, String dob, String status, String jobTitle) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstName);
        obj.put("emp_lastname", lastName);
        obj.put("emp_middle_name", middleName);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status", status);
        obj.put("emp_job_title", jobTitle);

        return obj.toString();
    }

}
