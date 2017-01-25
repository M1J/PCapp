package builder;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Predicate;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.json.simple.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controllers 
	implements Initializable {

	public static ObservableList<String> items = FXCollections.observableArrayList ();
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        
        // initialize your logic here: all @FXML variables will have been injected
    	JSONObject template = _motherboards.get(0);
    	    	
    	Set<Map.Entry<String, JSONObject>> entries = template.entrySet();
    	
    	// Fill combobox
    	for (Map.Entry<String, JSONObject> entry: entries) {
    		componentcombo.getItems().addAll(entry.getKey());
    	}
    	
//    	searchbutton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override public void handle(ActionEvent e) {
//                label.setText("Accepted");
//            }
//        });
    	searchbutton.setOnAction((event) -> { 
    		List<JSONObject> result = _finder.Find(componentcombo.getValue().toString(), searchbar.getText().toString());
    		if(!result.isEmpty())
    		{
    			items.clear();
    			list1.getItems().clear();
    			for (JSONObject motherboard : result)
    			{
    				items.add(motherboard.get("Name").toString());
    			}
    			
    			list1.setItems(items);
    			
    			found.setText("Found " + result.size() + " motherboards");
    		}
    		else
    		{
    			found.setText("Found 0 motherboards");
    		}
    		});
    	
    	
    	list1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    		if(newValue != null)
    		{
    			for (JSONObject motherboard : _motherboards)
    			{
        			if(motherboard.get("Name").toString().equals(newValue.toString()))
        			{
        				list2.getItems().clear();
        				Set<Map.Entry<String, JSONObject>> keys = motherboard.entrySet();
        				for (Map.Entry<String, JSONObject> key: keys) {
        		    		list2.getItems().addAll(key.getKey() + " : " + String.valueOf(key.getValue()));
        		    	}
        			}
    			
    			}
    		}
    	});			
    	
    }
     
    private List<JSONObject> _motherboards = new ArrayList<JSONObject>();
    private Finder _finder;
    
    public Controllers(List<JSONObject> motherboards)
    {
    	_motherboards = motherboards;
    	_finder = new Finder(motherboards);
    }

    @FXML
    private ComboBox componentcombo;
    
    @FXML
    private AnchorPane root;

    @FXML
    private TextField searchbar;

    @FXML
    private Button searchbutton;

    @FXML
    private Label found;

    @FXML
    private ListView<String> list1;

    @FXML
    private ListView<String> list2;

}
