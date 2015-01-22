package co.uk.ultimateweb.imagefilter;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;

import co.uk.ultimateweb.imagefilter.*;

public class ImageFilter extends CordovaPlugin {
	@Override
	public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
		boolean result = false;

		final Filters filters = new Filters();
		Context context = this.cordova.getActivity().getApplicationContext();

		if(action.equalsIgnoreCase("none")){
			String fileInfo = filters.none(context, data);
			//result = new PluginResult(Status.OK, fileInfo);

			result = true;
			callbackContext.success(fileInfo);
		}
		if(action.equalsIgnoreCase("stark")){
			String fileInfo = filters.stark(context, data);
			// result = new PluginResult(Status.OK, fileInfo);

			result = true;
			callbackContext.success(fileInfo);
		}
		if(action.equalsIgnoreCase("sunnyside")){
			String fileInfo = filters.sunnyside(context, data);
			//result = new PluginResult(Status.OK, fileInfo);

			result = true;
			callbackContext.success(fileInfo);
		}

		if(action.equalsIgnoreCase("vintage")){
			String fileInfo = filters.vintage(context, data);
			//result = new PluginResult(Status.OK, fileInfo);

			result = true;
			callbackContext.success(fileInfo);
		}
		if(action.equalsIgnoreCase("worn")){
			String fileInfo = filters.worn(context, data);
			//result = new PluginResult(Status.OK, fileInfo);

			result = true;
			callbackContext.success(fileInfo);
		}

		return result;
	}
}