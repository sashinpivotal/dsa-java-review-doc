package utilities;

import com.hr.personnel.Employee;
import com.hr.personnel.SalariedEmployee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class SimpleJSONUtility {

    private static JSONArray salariedEmployeesJSONArray;

    public static JSONArray readSalariedEmployeesJSON(String filePath)  {
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(filePath)) {

            Object object = jsonParser.parse(fileReader);
            salariedEmployeesJSONArray = (JSONArray) object;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return salariedEmployeesJSONArray;
    }

    public static Employee parseEmployeeObject(JSONObject salariedEmployeeJSONObject) {
        JSONObject employeeObject = (JSONObject) salariedEmployeeJSONObject.get("employee");
        String name = (String) employeeObject.get("name");
        String hireDate = (String) employeeObject.get("hireDate");
        String salary = (String) employeeObject.get("salary");
        return new SalariedEmployee(name, LocalDate.parse(hireDate), Double.valueOf(salary));
    }

}
