$(function() {
	$("div.label").click(function() {
		const pWidth = $('div.speech p').outerWidth();
		const divWidth = $('#switcher').outerWidth();

		// console.log(pWidth + " : " + divWidth);
		const num = parseInt(pWidth) - parseInt(divWidth);

		$('#switcher').fadeTo('fast', 0.5).animate({
			marginLeft : num
		}, 'slow').fadeTo('fast', 1.0).slideUp('slow', function() {
			$(this).css('background', 'red');
		}).slideDown('slow');
	});

});

// 2번째 p태그를 화면에서 숨김 : hide()
// <a>read more => 클릭: 사라진 p태그 화면에 보이게 하기
// slideUp() + slideDown() => slideToggle()
// read more => 클릭 => read less
// read less => 클릭 => read more
// text(값): 텍스트 값을 변경, text(): 텍스트 값 추출
$(function() {

	$('.speech p:nth-child(2)').hide();

	$('.more').on('click', function() {
		$('.speech p').eq(1).slideToggle('slow');

		$(this).text(function(i, text) {
			return text === 'read more' ? "read less" : "read more";
		});
	});

});

// large => 기존 폰트 크기 1.2배 커지도록
// samll => 기존 폰트 크기 1.2배 작아지도록
// defulat => 처음 글자 크기
// css('fontSize')
$(function() {

	const originFontSize = parseInt($('div.speech').css('fontSize'));

	$('#switcher button').on('click', function() {

		let num = parseInt($('div.speech').css('fontSize'));

		if (this.id === 'switcher-large') {
			num *= 1.2;
		} else if (this.id === 'switcher-small') {
			num /= 1.2;
		} else {
			num = originFontSize;
		}

		$('div.speech').animate({
			fontSize : num + 'px'
		}, 'slow');
	});

});
