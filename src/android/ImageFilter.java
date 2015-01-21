package co.uk.ultimateweb.imagefilter;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import android.net.Uri;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.*;
import android.os.*;
import android.content.Context;

import co.uk.ultimateweb.imagefilter.*;

public class ImageFilter extends CordovaPlugin {
	@Override
	public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
		boolean ignore = false;
		String filePath = "";
		Context context = this.cordova.getActivity().getApplicationContext();
		File path = new File(context.getFilesDir()+"/user/");
       	File NBBfile = new File(path, "tmp.jpg");
        
        // CREATE FOLDERS IF NEEDED
        try{
        	boolean success = false;
        	
        	if(!path.exists()){
	            success = path.mkdir();
	        }
        }
        catch (Exception e){
			ignore = true;
        	callbackContext.success("error 1 - " + e.toString());
        }
		
		if(!ignore) {
			final JSONObject options = data.optJSONObject(0);
			String imageURL = options.optString("image");
        	// GET URL TO IMAGE
			try{
				// create image bitmap
				Bitmap bmp = BitmapFactory.decodeFile(imageURL);
				if(bmp.getHeight() >= 655 || bmp.getWidth()>=655){
					bmp = Bitmap.createBitmap(bmp,0,0,655,655);
				}
				else {
					bmp = Bitmap.createBitmap(bmp);
				}
				
				try{
					// create image canvas
					Bitmap none = Bitmap.createBitmap(bmp);
					
					Canvas canvas = new Canvas(none);
					canvas.drawBitmap(none,0,0,null);
					
					Paint paint = new Paint();
					ColorMatrix cm = new ColorMatrix();
				
					cm.set(new float[] { 
							1, 0, 0, 0, -60, 
							0, 1, 0, 0, -60, 
							0, 0, 1, 0, -60, 
							0, 0, 0, 1, 0 });
					paint.setColorFilter(new ColorMatrixColorFilter(cm));
					Matrix matrix = new Matrix();
					canvas.drawBitmap(none, matrix, paint);
					
					try {
					
						// OUTPUT STREAM
						FileOutputStream out = new FileOutputStream(NBBfile);
						none.compress(Bitmap.CompressFormat.JPEG, 100, out);
						
						// GET FILE PATH
						Uri uri = Uri.fromFile(NBBfile);
						filePath = uri.toString();
						
						// RETURN FILE PATH
						callbackContext.success("success = " + filePath);
						
						
					} catch (Exception e) {
						ignore = true;
						callbackContext.success("error 4 - " + e.toString() + " - " + getStackTrace(e));
					}
				}
				catch (Exception e){
					ignore = true;
					callbackContext.success("error 3 - " + e.toString() + " - " + getStackTrace(e));
				}
			}
			catch (Exception e){
				ignore = true;
				callbackContext.success("error 2 - " + e.toString() + " - " + getStackTrace(e));
			}
		}
		
		return true;
		
		/*boolean result = false;

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

		return result;*/
	}
	
	public static String getStackTrace(final Throwable throwable) {
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw, true);
		throwable.printStackTrace(pw);
		return sw.getBuffer().toString();
	}
}