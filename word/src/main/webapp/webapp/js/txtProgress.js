/**
 * TextProgress
 * Copyright (c) 2015
 * by Jonatan Olsson (https://www.jonatanolsson.se)
 */

jQuery.fn.extend({
	textProgress : function (value) {
		this.find(".tp + .tp, .progress").css("width", value + "%").find(".percent").animate({
			Counter : parseInt(value)
		}, {
			step : function (now) {
				$(this).text(Math.ceil(now))
			}
		});
	}
});