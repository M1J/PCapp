package builder;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class Parser {
	//https://examples.javacodegeeks.com/core-java/json/java-json-parser-example/
	
	private String filePath = "/Users/marek/Documents/workspace/PCapp/src/basebase.json";
	
	public List<JSONObject> ParseJson() {
		
		List<JSONObject> resultList = new ArrayList<JSONObject>();
		
		try {
			// read the json file
			FileReader reader = new FileReader(filePath);

			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			JSONObject mobo1 = (JSONObject) jsonObject.get("ASUS MAXIMUS VIII HERO");
			JSONObject mobo2 = (JSONObject) jsonObject.get("MSI X99S SLI PLUS");
			JSONObject mobo3 = (JSONObject) jsonObject.get("Gigabyte GA-Q87N");
			JSONObject mobo4 = (JSONObject) jsonObject.get("ASRock Fatal1ty Z68 Professional Gen3");
			JSONObject mobo5 = (JSONObject) jsonObject.get("MSI X58 PRO-E");
			JSONObject mobo6 = (JSONObject) jsonObject.get("ASUS P7P55D");
			
			//System.out.println("Ram " + mobo1.get("RAM type"));		
			//System.out.println("CPU " + mobo1.get("CPU"));		

			
			resultList.add(mobo1);
			resultList.add(mobo2);
			resultList.add(mobo3);
			resultList.add(mobo4);
			resultList.add(mobo5);
			resultList.add(mobo6);
			
			


		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		
		return resultList;

	}

}