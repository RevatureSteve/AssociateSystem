/**
 * JQuery for navbar
 */

$("#navigationBar > a").click(function() {
	$(".navSelected").removeClass("navSelected");
	$(this).addClass("navSelected");
});

$(document).ready(function() {
	// This makes it so "Home" on the navbar has the appearance of being selected the first time the page is loaded,
	// without having it reset on refresh.
	console.log($("#navigationBar > a").hasClass("navSelected"));
	if (!$("#navigationBar > a").hasClass("navSelected")) {
		$("#navHome").addClass("navSelected");
	}
});