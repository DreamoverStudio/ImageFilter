package co_uk.ultimateweb.plugin;

import org.json.JSONArray;
import org.json.JSONException;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;


public class ImageFilter extends CordovaPlugin {
	
	@Override
	public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
		boolean result = false;
		
		final Filters filters = new Filters();
		
		if(action.equalsIgnoreCase("none")){
			 String fileInfo = filters.none(data);
			 //result = new PluginResult(Status.OK, fileInfo);
			 
			 result = true;
			 callbackContext.success(fileInfo);
		}
		if(action.equalsIgnoreCase("stark")){
			 String fileInfo = filters.stark(data);
			// result = new PluginResult(Status.OK, fileInfo);
			 
			 result = true;
			 callbackContext.success(fileInfo);
		}
		if(action.equalsIgnoreCase("sunnySide")){
			 String fileInfo = filters.sunnyside(data);
			 //result = new PluginResult(Status.OK, fileInfo);
			 
			 result = true;
			 callbackContext.success(fileInfo);
		}
		
		if(action.equalsIgnoreCase("vintage")){
			 String fileInfo = filters.vintage(data);
			 //result = new PluginResult(Status.OK, fileInfo);
			 
			 result = true;
			 callbackContext.success(fileInfo);
		}
		if(action.equalsIgnoreCase("worn")){
			 String fileInfo = filters.worn(data);
			 //result = new PluginResult(Status.OK, fileInfo);
			 
			 result = true;
			 callbackContext.success(fileInfo);
		}

		return result;
	}
	
}