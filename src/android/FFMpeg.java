package com.marin.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import com.arthenica.mobileffmpeg.Config;
import com.arthenica.mobileffmpeg.FFmpeg;
import com.arthenica.mobileffmpeg.FFprobe;


public class FFMpeg extends CordovaPlugin
{

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException
    {
        int RETURN_CODE_CANCEL = 255;
        int RETURN_CODE_SUCCESS = 0;
         String message = "";
        if (action.equals("exec")) {
            //TODO: call ffmpeg-mobile and do the processing ...
            //FFmpeg.execute("-i file1.mp4 -c:v mpeg4 file2.mp4");
            //https://github.com/tanersener/mobile-ffmpeg/wiki/Android
            String command_name = data.getString(0);
            String message = "Command... " + command_name;
            int rc = FFmpeg.execute(command_name);  
            if (rc == RETURN_CODE_SUCCESS)
            {
                //    Log.i(Config.TAG, "Command execution completed successfully.");
                message = "Command execution completed successfully. Output: " + Config.getLastCommandOutput();
                callbackContext.success(message);
            }
            else if (rc == RETURN_CODE_CANCEL)
            {
                // Log.i(Config.TAG, "Command execution cancelled by user.");
                message =  "Command execution cancelled by user.";
                callbackContext.error(message);
            }
            else
            {
                // Log.i(Config.TAG, String.format("Command execution failed with rc=%d and the output below.", rc));
                // message =  String.format("Command execution failed with rc=%d and the output below.", rc);
                message = Config.getLastCommandOutput();
                callbackContext.error(message);
            }
            return true;
        }


        if (action.equals("ffprobe")) {
            //TODO: call ffmpeg-mobile and do the processing ...
            //FFmpeg.execute("-i file1.mp4 -c:v mpeg4 file2.mp4");
            //https://github.com/tanersener/mobile-ffmpeg/wiki/Android
            String command_name = data.getString(0);
            String message = "Command... " + command_name;
            int rc = FFprobe.execute(command_name);  
            if (rc == RETURN_CODE_SUCCESS)
            {
                //    Log.i(Config.TAG, "Command execution completed successfully.");
                message = "Command execution completed successfully. Output: " + Config.getLastCommandOutput();
                callbackContext.success(message);
            }
            else if (rc == RETURN_CODE_CANCEL)
            {
                // Log.i(Config.TAG, "Command execution cancelled by user.");
                message =  "Command execution cancelled by user.";
                callbackContext.error(message);
            }
            else
            {
                // Log.i(Config.TAG, String.format("Command execution failed with rc=%d and the output below.", rc));
                // message =  String.format("Command execution failed with rc=%d and the output below.", rc);
                message = Config.getLastCommandOutput();
                callbackContext.error(message);
            }
            return true;
        }
        if (action.equals("getMediaInformation")) {
            //TODO: call ffmpeg-mobile and do the processing ...
            //FFmpeg.execute("-i file1.mp4 -c:v mpeg4 file2.mp4");
            //https://github.com/tanersener/mobile-ffmpeg/wiki/Android
            String filename = data.getString(0);
            String message = "Command... " + filename;
            int rc = FFprobe.getMediaInformation(filename);  
            if (rc == RETURN_CODE_SUCCESS)
            {
                //    Log.i(Config.TAG, "Command execution completed successfully.");
                message = "Command execution completed successfully. Output: " + Config.getLastCommandOutput();
                callbackContext.success(message);
            }
            else if (rc == RETURN_CODE_CANCEL)
            {
                // Log.i(Config.TAG, "Command execution cancelled by user.");
                message =  "Command execution cancelled by user.";
                callbackContext.error(message);
            }
            else
            {
                // Log.i(Config.TAG, String.format("Command execution failed with rc=%d and the output below.", rc));
                // message =  String.format("Command execution failed with rc=%d and the output below.", rc);
                message = Config.getLastCommandOutput();
                callbackContext.error(message);
            }
            return true;
        }

        if (action.equals("cancel")) {

            int rc = FFmpeg.cancel();  
            if (rc == RETURN_CODE_SUCCESS)
            {
                //    Log.i(Config.TAG, "Command execution completed successfully.");
                message = "Canceled. Output: " + Config.getLastCommandOutput();
                callbackContext.success(message);
            }
            else if (rc == RETURN_CODE_CANCEL)
            {
                // Log.i(Config.TAG, "Command execution cancelled by user.");
                message =  "Command execution cancelled by user.";
                callbackContext.error(message);
            }
            else
            {
                // Log.i(Config.TAG, String.format("Command execution failed with rc=%d and the output below.", rc));
                // message =  String.format("Command execution failed with rc=%d and the output below.", rc);
                message = Config.getLastCommandOutput();
                callbackContext.error(message);
            }
            return true;
        }



        if (action.equals("getLastCommandOutput")) {
                callbackContext.success(Config.getLastCommandOutput());
            return true;
        }


        if (action.equals("getLastReturnCode")) {

            int rc = Config.getLastReturnCode();  
            if (rc == RETURN_CODE_SUCCESS)
            {
                //    Log.i(Config.TAG, "Command execution completed successfully.");
                message = "Canceled. Output: " + Config.getLastCommandOutput();
                callbackContext.success(message);
            }
            else if (rc == RETURN_CODE_CANCEL)
            {
                // Log.i(Config.TAG, "Command execution cancelled by user.");
                message =  "Command execution cancelled by user.";
                callbackContext.error(message);
            }
            else
            {
                // Log.i(Config.TAG, String.format("Command execution failed with rc=%d and the output below.", rc));
                // message =  String.format("Command execution failed with rc=%d and the output below.", rc);
                message = Config.getLastCommandOutput();
                callbackContext.error(message);
            }
            return true;
        }


        if (action.equals("getLastReceivedStatistics")) {
                callbackContext.success(Config.getLastReceivedStatistics());
            return true;
        }

        if (action.equals("getSupportedCameraIds")) {
          
             //   callbackContext.success(Config.getSupportedCameraIds());
                callbackContext.success( JSONArray.fromObject(Config.getSupportedCameraIds()) );
            return true;
        }

        if (action.equals("getFFmpegVersion")) {
                callbackContext.success(Config.getFFmpegVersion());
            return true;
        }

        if (action.equals("getVersion")) {
                callbackContext.success(Config.getVersion());
            return true;
        }

//         if (action.equals("getNativeFFmpegVersion")) {
//                 callbackContext.success(Config.getNativeFFmpegVersion());
//             return true;
//         }



        // else
        // {

        //     return false;

        // }
    }
}


