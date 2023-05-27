package Utils;

import org.json.JSONObject;

public class APiPayloadConstants {

    // We will pass the body in multiple formats  , for this we have  created this class
    public static String createEmployeePayload(){
        String payload = "{\n" +
                "  \"emp_firstname\": \"Joseph405689\",\n" +
                "  \"emp_lastname\": \"Girgis49345\",\n" +
                "  \"emp_middle_name\": \"Joe133\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2011-01-01\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"Mechanical Engineer\"\n" +
                "}";
        return payload;

    }
    public static String createEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Pratyush12");
        obj.put("emp_lastname","Singh12");
        obj.put("emp_middle_name","MN");
        obj.put("emp_gender","M");
        obj.put("emp_birthday", "2011-01-01");
        obj.put("emp_status", "Confirmed");
        obj.put( "emp_job_title","Mechanical Engineer");

        return obj.toString();


    }

}
