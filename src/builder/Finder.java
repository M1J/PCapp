package builder;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;

public class Finder {
	
	private List<JSONObject> _source;
	
	public Finder(List<JSONObject> source)
	{
		_source = source;
	}
	
	public List<JSONObject> Find(String component, String text)
	{
		List<JSONObject> result = new LinkedList<JSONObject>();
		
		for(int i = 0; i < _source.size(); i++) {
		
			Set<Map.Entry<String, String>> element = _source.get(i).entrySet();
			
			for (Map.Entry<String, String> _component: element) {
	    		if(_component.getKey().equals(component))
	    		{
	    			String value = String.valueOf(_component.getValue());
	    			if(value.toLowerCase().contains(text.toLowerCase())) 
	    			{
	    				result.add(_source.get(i));
	    			}
	    		}
	    	}
		}
		
		return result;
	}
}
