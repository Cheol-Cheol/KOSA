$(function() {
	// 1. <ol id="note"></ol> =>
	const ol = '<ol id="note"></ol>';
	$('#footer').before(ol);

	// 2. <span class="footnote">앞에 <a id ="">[1]</a>
	// 3. <ol> 태그 자식으로 <span> 이동
	$('.footnote').each(
			// span 여러개
			function(index, item) {
				// a 태그 만듦
				const $a = '<a id ="context-' + (index + 1) + '">['
						+ (index + 1) + ']</a>';

				$(item).before($a).appendTo('#note').append(
						'&nbsp; <a href="#context-' + (index + 1)
								+ '">context-' + (index + 1) + '</a>').wrap(
						'<li></li>');
			});
});
