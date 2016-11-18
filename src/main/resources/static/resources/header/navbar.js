/**
 * JQuery for navbar
 */

$("#navigationBar > a").click(function() {
	$(".navSelected").removeClass("navSelected");
	$(this).addClass("navSelected");
});