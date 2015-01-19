var cordova = require('cordova');

/**
 * Clipboard plugin for Cordova
 * 
 * @constructor
 */
function ImageFilter () {}

/**
 * Sets the clipboard content
 *
 * @param {String}   text      The content to copy to the clipboard
 * @param {Function} onSuccess The function to call in case of success (takes the copied text as argument)
 * @param {Function} onFail    The function to call in case of error
 */
ImageFilter.prototype.copy = function (text, onSuccess, onFail) {
    if (typeof text === "undefined" || text === null) text = "";
	cordova.exec(onSuccess, onFail, "ImageFilter", "vintage", [text]);
};

// Register the plugin
var imagefilter = new ImageFilter();
module.exports = imagefilter;