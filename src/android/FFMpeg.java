package com.marin.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import com.arthenica.mobileffmpeg.Config;
import com.arthenica.mobileffmpeg.FFmpeg;


public class FFMpeg extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        int RETURN_CODE_CANCEL = 255;
        int RETURN_CODE_SUCCESS = 0;
        if (action.equals("exec")) {
            
            //TODO: call ffmpeg-mobile and do the processing ...
            //FFmpeg.execute("-i file1.mp4 -c:v mpeg4 file2.mp4"); 
            //https://github.com/tanersener/mobile-ffmpeg/wiki/Android
            String command_name = data.getString(0);
            String message = "Command... " + command_name;


int rc = FFmpeg.execute(command_name); // "-i file1.mp4 -c:v mpeg4 file2.mp4");

if (rc == RETURN_CODE_SUCCESS) {
//    Log.i(Config.TAG, "Command execution completed successfully.");
    message = "Command execution completed successfully.";
} else if (rc == RETURN_CODE_CANCEL) {
   // Log.i(Config.TAG, "Command execution cancelled by user.");
     message =  "Command execution cancelled by user.";
} else {
   // Log.i(Config.TAG, String.format("Command execution failed with rc=%d and the output below.", rc));
    // message =  String.format("Command execution failed with rc=%d and the output below.", rc);
        message =   "Command execution failed" + Log.INFO;
  //  Config.printLastCommandOutput(Log.INFO);
}


            callbackContext.success(message);

            return true;

        } else {
            
            return false;

        }
    }
}

 
