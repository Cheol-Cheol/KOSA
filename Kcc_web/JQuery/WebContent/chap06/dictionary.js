// step1
$(function() {
	$('#letter-a a').click(function() {
		$('#dictionary').hide().load('a.html', function() {
			$(this).fadeIn();
		});

		return false; // 기본 이벤트 제거
	});
});

// step2_1
$(function() {
	$('#letter-b a').click(
			function() {
				$.ajax({
					url : 'b.json',
					type : 'get',
					dataType : 'json',
					success : function(data) {
						$('#dictionary').empty(); // 자식 요소들 제거하기

						data.sort(function(a, b) {
							if (a.term < b.term) {
								return 1;
							} else if (a.term > b.term) {
								return -1;
							} else {
								return 0;
							}
						});

						$.each(data,
								function(index, item) {
									let html = '<div class="entry">';
									html += '<h3 class="term">' + item.term
											+ '</h3>';
									html += '<div class="part">' + item.part
											+ '</div>';
									html += '<div class="definition">'
											+ item.definition + '</div>';
									html += '</div>';

									$('#dictionary').append(html);
								});
					}
				});
				return false; // 기본 이벤트 제거
			});
});

// step2
// $(function() {
// $('#letter-b a').click(
// function() {
// $.getJSON('b.json', function(data) {
// $('#dictionary').empty(); // 자식 요소들 제거하기
//
// $.each(data, function(index, item) {
// let html = '<div class="entry">';
// html += '<h3 class="term">' + item.term + '</h3>';
// html += '<div class="part">' + item.part + '</div>';
// html += '<div class="definition">' + item.definition
// + '</div>';
// html += '</div>';
//
// $('#dictionary').append(html);
// });
// });
//
// return false; // 기본 이벤트 제거
// });
// });

// step3
$(function() {
	$('#letter-c a').click(function() {
		$.getScript('c.js');

		return false; // 기본 이벤트 제거
	});
});

// step4
$(function() {
	$('#letter-d a').click(
			function() {
				// xml -> HTML 변환

				// xml은 항상 루트 요소로 entries가 있다.
				// data에는 DOM 객체가 들어간다.
				$.get('d.xml', function(data) {
					$('#dictionary').empty(); // 자식 요소들 제거하기

					$(data).find('entry').each(
							function(index) {
								$entry = $(this);
								let html = '<div class="entry">';
								html += '<h3 class="term">'
										+ $entry.attr('term') + '</h3>';
								html += '<div class="part">'
										+ $entry.attr('part') + '</div>';
								html += '<div class="definition">'
										+ $entry.find("definition").text()
										+ '</div>';

								$('#dictionary').append(html);
							});
				});

				return false; // 기본 이벤트 제거
			});
});

// step5
$(function() {
	$('#letter-e a').click(function() {
		$.get('server3.jsp', {
			'term' : $(this).text()
		}, function(data) {
			$('#dictionary').text(data);
		});

		return false; // 기본 이벤트 제거
	});
});

// step6
$(function() {
	$('#letter-f form').submit(function() {
		$.ajax({
			url : 'server3.jsp',
			type : 'post',
			data : $(this).serialize(), // form내 모든 input 데이터를 key:value 형태로 가져옴
			dataType : 'text',
			success : function(data) {
				$('#dictionary').text(data);
			}
		});

		return false; // 기본 이벤트 제거
	});
});
