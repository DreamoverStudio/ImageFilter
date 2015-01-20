package co.uk.ultimateweb.imagefilter;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import co.uk.ultimateweb.imagefilter.*;

public class ImageFilter extends CordovaPlugin {
	@Override
	public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
		
		callbackContext.success("test - " + data.getString(0) " - " + data.optJSONObject(0).optString("image"));
		return true;
		
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
		if(action.equalsIgnoreCase("sunnyside")){
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