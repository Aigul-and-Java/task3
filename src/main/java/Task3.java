import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;

public class Main {


    private static final String jsonValueFilePath = "I:\\new folder\\values.json";

    private static final String jsonTestFilePath = "I:\\new folder\\tests.json";
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        FileReader valueReader = new FileReader(jsonValueFilePath);
        FileReader testReader = new FileReader(jsonTestFilePath);
        JSONObject valObj = (JSONObject) parser.parse(valueReader);

        JSONArray arr = (JSONArray) valObj.get("values");
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i);

        }
        Iterator iter = arr.iterator();
        while (iter.hasNext()) {
            JSONObject obj = (JSONObject) iter.next();
            obj.get("id");
            obj.get("value");
        }

       JSONObject testObj = (JSONObject) parser.parse(testReader);

        JSONArray tArr = (JSONArray)testObj.get("tests");
        for (int i = 0; i < tArr.size(); i++)
        {
            tArr.get(i);
        }
        Iterator tter = tArr.iterator();
        while (tter.hasNext()) {
            JSONObject test = (JSONObject) tter.next();
            test.get("id");
            test.get("title");
            test.get("value");

        }



        JSONObject report = new JSONObject();
        report.put("tests",testObj);
        report.put("values",valObj);



        try (
            FileWriter file = new FileWriter("report.json")){
            file.write(report.toJSONString());
            file.flush();
        } catch ( Exception e){
            e.printStackTrace();
        }
    }


}
