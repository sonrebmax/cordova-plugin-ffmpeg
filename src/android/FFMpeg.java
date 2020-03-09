package com.marin.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.arthenica.mobileffmpeg.Config;
import com.arthenica.mobileffmpeg.FFmpeg;
import com.arthenica.mobileffmpeg.FFprobe;
import com.arthenica.mobileffmpeg.MediaInformation;
import com.arthenica.mobileffmpeg.StreamInformation;

public class FFMpeg extends CordovaPlugin {
    private JSONArray jsonMediaInfo = new JSONArray();

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        int RETURN_CODE_CANCEL = 255;
        int RETURN_CODE_SUCCESS = 0;
        String message = "";
        String command_name = "";
        if (action.equals("exec"))
        {
            //TODO: call ffmpeg-mobile and do the processing ...
            //FFmpeg.execute("-i file1.mp4 -c:v mpeg4 file2.mp4");
            //https://github.com/tanersener/mobile-ffmpeg/wiki/Android
            command_name = data.getString(0);
            message = "Command... " + command_name;
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


        if (action.equals("ffprobe"))
        {
            //TODO: call ffmpeg-mobile and do the processing ...
            //FFmpeg.execute("-i file1.mp4 -c:v mpeg4 file2.mp4");
            //https://github.com/tanersener/mobile-ffmpeg/wiki/Android
            command_name = data.getString(0);
            message = "Command... " + command_name;
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


        if (action.equals("getMediaInformation"))
        {
            //TODO: call ffmpeg-mobile and do the processing ...
            //FFmpeg.execute("-i file1.mp4 -c:v mpeg4 file2.mp4");
            //https://github.com/tanersener/mobile-ffmpeg/wiki/Android
            String filename = data.getString(0);
            message = "Command... " + filename;

            clearLog();




            MediaInformation information = FFprobe.getMediaInformation(filename);
            if (information == null)
            {
                appendLog("Get media information failed\n");
                return false;
            }
            else
            {
                appendLog("Media information for " + information.getPath() + "\n");

                if (information.getFormat() != null)
                {
                    appendLog("Format: " + information.getFormat() + "\n");
                }
                if (information.getBitrate() != null)
                {
                    appendLog("Bitrate: " + information.getBitrate() + "\n");
                }
                if (information.getDuration() != null)
                {
                    appendLog("Duration: " + information.getDuration() + "\n");
                }
                if (information.getStartTime() != null)
                {
                    appendLog("Start time: " + information.getStartTime() + "\n");
                }
                if (information.getMetadataEntries() != null)
                {
                    Set<Map.Entry<String, String>> entries = information.getMetadataEntries();
                    for (Map.Entry<String, String> entry : entries)
                    {
                        appendLog("Metadata: " + entry.getKey() + ":" + entry.getValue() + "\n");
                    }
                }
                if (information.getStreams() != null)
                {
                    for (StreamInformation stream : information.getStreams())
                    {
                        if (stream.getIndex() != null)
                        {
                            appendLog("Stream index: " + stream.getIndex() + "\n");
                        }
                        if (stream.getType() != null)
                        {
                            appendLog("Stream type: " + stream.getType() + "\n");
                        }
                        if (stream.getCodec() != null)
                        {
                            appendLog("Stream codec: " + stream.getCodec() + "\n");
                        }
                        if (stream.getFullCodec() != null)
                        {
                            appendLog("Stream full codec: " + stream.getFullCodec() + "\n");
                        }
                        if (stream.getFormat() != null)
                        {
                            appendLog("Stream format: " + stream.getFormat() + "\n");
                        }
                        if (stream.getFullFormat() != null)
                        {
                            appendLog("Stream full format: " + stream.getFullFormat() + "\n");
                        }

                        if (stream.getWidth() != null)
                        {
                            appendLog("Stream width: " + stream.getWidth() + "\n");
                        }
                        if (stream.getHeight() != null)
                        {
                            appendLog("Stream height: " + stream.getHeight() + "\n");
                        }

                        if (stream.getBitrate() != null)
                        {
                            appendLog("Stream bitrate: " + stream.getBitrate() + "\n");
                        }
                        if (stream.getSampleRate() != null)
                        {
                            appendLog("Stream sample rate: " + stream.getSampleRate() + "\n");
                        }
                        if (stream.getSampleFormat() != null)
                        {
                            appendLog("Stream sample format: " + stream.getSampleFormat() + "\n");
                        }
                        if (stream.getChannelLayout() != null)
                        {
                            appendLog("Stream channel layout: " + stream.getChannelLayout() + "\n");
                        }

                        if (stream.getSampleAspectRatio() != null)
                        {
                            appendLog("Stream sample aspect ratio: " + stream.getSampleAspectRatio() + "\n");
                        }
                        if (stream.getDisplayAspectRatio() != null)
                        {
                            appendLog("Stream display ascpect ratio: " + stream.getDisplayAspectRatio() + "\n");
                            ;
                        }
                        if (stream.getAverageFrameRate() != null)
                        {
                            appendLog("Stream average frame rate: " + stream.getAverageFrameRate() + "\n");
                        }
                        if (stream.getRealFrameRate() != null)
                        {
                            appendLog("Stream real frame rate: " + stream.getRealFrameRate() + "\n");
                        }
                        if (stream.getTimeBase() != null)
                        {
                            appendLog("Stream time base: " + stream.getTimeBase() + "\n");
                        }
                        if (stream.getCodecTimeBase() != null)
                        {
                            appendLog("Stream codec time base: " + stream.getCodecTimeBase() + "\n");
                        }

                        if (stream.getMetadataEntries() != null)
                        {
                            Set<Map.Entry<String, String>> entries = stream.getMetadataEntries();
                            for (Map.Entry<String, String> entry : entries)
                            {
                                appendLog("Stream metadata: " + entry.getKey() + ":" + entry.getValue() + "\n");
                            }
                        }
                    }
                }
            } 
            callbackContext.success( jsonMediaInfo );
            return true;
        }

        if (action.equals("cancel"))
        {
            FFmpeg.cancel();
            return true;
        }



        if (action.equals("getLastCommandOutput"))
        {
            callbackContext.success(Config.getLastCommandOutput());
            return true;
        }


        if (action.equals("getLastReturnCode"))
        {

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


        // if (action.equals("getLastReceivedStatistics"))
        // {
        //     callbackContext.success(Config.getLastReceivedStatistics());
        //     return true;
        // }

        // if (action.equals("getSupportedCameraIds"))
        // {
        //     JSONArray jsonSupportedCameraIds = new JSONArray();
        //     List<String> listSupportedCameraIds = Config.getSupportedCameraIds(this);
        //     if (listSupportedCameraIds != null)
        //     {
        //         for (int i = 0; i < listSupportedCameraIds.size(); i++)
        //         {
        //             jsonSupportedCameraIds.put(new String(listSupportedCameraIds.get(i)));
        //         }
        //     }
        //     //   callbackContext.success(Config.getSupportedCameraIds());
        //     callbackContext.success( jsonSupportedCameraIds );
        //     return true;
        // }
        if (action.equals("getExternalLibraries"))
        {
            JSONArray jsonExternalLibraries = new JSONArray();
            List<String> listExternalLibraries = Config.getExternalLibraries();
            if (listExternalLibraries != null)
            {
                for (int i = 0; i < listExternalLibraries.size(); i++)
                {
                    jsonExternalLibraries.put(new String(listExternalLibraries.get(i)));
                }
            }
            //   callbackContext.success(Config.getExternalLibraries());
            callbackContext.success( jsonExternalLibraries );
            return true;
        }

        if (action.equals("getFFmpegVersion"))
        {
            callbackContext.success(Config.getFFmpegVersion());
            return true;
        }

        if (action.equals("getVersion"))
        {
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
        // 
        

        
    }

    public void appendLog(final String logMessage)
    {
        // outputText.append(logMessage);
        jsonMediaInfo.put(new String( logMessage ));
    }

    public void clearLog()
    {
        //jsonMediaInfo.setText("");
        jsonMediaInfo = new JSONArray();
    }



}


