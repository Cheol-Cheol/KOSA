$(function() {
	$('#selected-plays > li').addClass('horizontal');
	$('li:not(.horizontal').addClass('sub-level');
	$('a[href$=pdf]').addClass('pdflink');
	$('a[href^=mailto]').addClass('mailto');
	$('a[href*=henry]').not('a[href^=mailto]').addClass('henrylink');
	// $('tr:odd').addClass('alt');
	// $('tr:nth-child(even)').addClass('alt');
	// $('td:contains(Henry)').nextAll().addClass('highlight');
	// $('td:contains(Henry)').parent().find('td').addClass('highlight');
	$('td:contains(Henry)').parent().find('td:first').addClass('highlight')
			.end().find('td:eq(1)').addClass('highlight');
	
	// each() => 배열을 받아서 각각의 작업을 수행
	$.each([1,2,3], (el) => console.log(el));
})