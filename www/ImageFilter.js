/*
Copyright (c) 2012 Drew Dahlman MIT LICENSE
*/

var ImageFilter = function () {};

ImageFilter.prototype.clean = function (done, error, options) {
	var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
	
    return cordova.exec(done, error, "ImageFilter", "clean", [defaults]);
};

ImageFilter.prototype.none = function (done, error, options) {
    //console.log(options+" "+done);
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }

    return cordova.exec(done,error,"ImageFilter","none",[defaults]);
};

ImageFilter.prototype.sunnySide = function (done, error, options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done, error, "ImageFilter","sunnySide",[defaults]);
};

ImageFilter.prototype.worn = function (done, error ,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
   	return cordova.exec(done,error,"ImageFilter","worn",[defaults]);
};

ImageFilter.prototype.vintage = function (done,error,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done,error,"ImageFilter","vintage",[defaults]);
};

ImageFilter.prototype.stark = function (done,error,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done,error,"ImageFilter","stark",[defaults]);
};

ImageFilter.prototype.blackAndWhite = function (done,error,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done,error,"ImageFilter","blackAndWhite",[defaults]);
};

ImageFilter.prototype.blueMood = function (done,error,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done,error,"ImageFilter","blueMood",[defaults]);
};

ImageFilter.prototype.sunkissed = function (done,error,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done,error,"ImageFilter","sunkissed",[defaults]);
};

ImageFilter.prototype.magichour = function (done,error,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done,error,"ImageFilter","magichour",[defaults]);
};

ImageFilter.prototype.toycamera = function (done,error,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done,error,"ImageFilter","toycamera",[defaults]);
};

ImageFilter.prototype.crossProcess = function (done,error,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done,error,"ImageFilter","crossProcess",[defaults]);
};

ImageFilter.prototype.sharpify = function (done,error,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done,error,"ImageFilter","sharpify",[defaults]);
};

ImageFilter.prototype.vibrant = function (done,error,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done,error,"ImageFilter","vibrant",[defaults]);
};

ImageFilter.prototype.colorize = function (done,error,options) {
    var defaults = {
        image: '',
        save: false,
    };
    for(var key in defaults) {
        if(typeof options[key] !== "undefined") defaults[key] = options[key];
    }
    return cordova.exec(done,error,"ImageFilter","colorize",[defaults]);
};

ImageFilter.install = function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.ImageFilter = new ImageFilter();
  return window.plugins.ImageFilter;
};

cordova.addConstructor(ImageFilter.install);