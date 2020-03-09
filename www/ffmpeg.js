var exec = require('cordova/exec');

exports.exec = function(cmd, success, error) {
    exec(success, error, "FFMpeg", "exec", [cmd]);
};

exports.ffprobe = function(cmd, success, error) {
    exec(success, error, "FFMpeg", "ffprobe", [cmd]);
};

exports.getMediaInformation = function(filename, success, error) {
    exec(success, error, "FFMpeg", "getMediaInformation", [filename]);
};

exports.cancel = function(success, error) {
    exec(success, error, "FFMpeg", "cancel", []);
};

exports.getLastCommandOutput = function(success, error) {
    exec(success, error, "FFMpeg", "getLastCommandOutput", []);
};

exports.getLastReturnCode = function(success, error) {
    exec(success, error, "FFMpeg", "getLastReturnCode", []);
};

// exports.getLastReceivedStatistics = function(success, error) {
//     exec(success, error, "FFMpeg", "getLastReceivedStatistics", []);
// };

exports.getExternalLibraries = function(success, error) {
    exec(success, error, "FFMpeg", "getExternalLibraries", []);
};
// exports.getSupportedCameraIds = function(success, error) {
//     exec(success, error, "FFMpeg", "getSupportedCameraIds", []);
// };

exports.getFFmpegVersion = function(success, error) {
    exec(success, error, "FFMpeg", "getFFmpegVersion", []);
};

exports.getVersion = function(success, error) {
    exec(success, error, "FFMpeg", "getVersion", []);
};

// exports.getNativeFFmpegVersion = function(success, error) {
//     exec(success, error, "FFMpeg", "getNativeFFmpegVersion", []);
// };

// /*global cordova, module*/

// module.exports = {
//     exec: function (cmd, successCallback, errorCallback) {
//         cordova.exec(successCallback, errorCallback, "FFMpeg", "exec", [cmd]);
//     }
// };
