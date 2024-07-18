// step1
//$(function(){
//	$('#switcher-large').on('click', function(){
//		$('body').addClass('large');
//	})
//});

// step2 
//$(function() {
//	let classState = "";
//
//	$('#switcher-default').on('click', function() {
//		if (classState !== "") {
//			$('body').removeClass(classState);
//		}
//	});
//	
//	$('#switcher-large').on('click', function() {
//		if (classState !== "") {
//			$('body').removeClass(classState);
//		}
//		
//		
//		classState = "large";
//		$('body').addClass('large');
//	});
//	
//	$('#switcher-narrow').on('click', function() {
//		if (classState !== "") {
//			$('body').removeClass(classState);
//		}
//		
//		classState = "narrow";
//		$('body').addClass('narrow');
//	});
//});

// step3
//$(function() {
//	let classState = "";
//
//	$('#switcher-default').on('click', function() {
//		if (classState !== "") {
//			$('body').removeClass(classState);
//		}
//
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//	});
//
//	$('#switcher-large').on('click', function() {
//		if (classState !== "") {
//			$('body').removeClass(classState);
//		}
//
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//		
//		classState = "large";
//		$('body').addClass('large');
//	});
//
//	$('#switcher-narrow').on('click', function() {
//		if (classState !== "") {
//			$('body').removeClass(classState);
//		}
//
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//
//		classState = "narrow";
//		$('body').addClass('narrow');
//	});
//});

// step4
//$(function() {
//	let classState = "";
//
//	$('#switcher-default').on('click', function() {
//		if (classState !== "") {
//			$('body').removeClass(classState);
//		}
//	});
//
//	$('#switcher-large').on('click', function() {
//		if (classState !== "") {
//			$('body').removeClass(classState);
//		}
//		
//		classState = "large";
//		$('body').addClass('large');
//	});
//
//	$('#switcher-narrow').on('click', function() {
//		if (classState !== "") {
//			$('body').removeClass(classState);
//		}
//
//		classState = "narrow";
//		$('body').addClass('narrow');
//	});
//	
//	// 이벤트를 활용한 재사용 함수
//	$('#switcher .button').on('click', () => {
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//	});
//	
//});

// step5
//$(function() {
//	let classState = "";
//	
//	$('#switcher .button').on('click', () => {
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//		
//		if (classState !== "") {
//			$('body').removeClass(classState);
//		}
//		
//		if(this.id === 'switcher-large') {
//			classState = "large";
//			$('body').addClass('large');
//		} else if(this.id === 'switcher-narrow') {
//			classState = "narrow";
//			$('body').addClass('narrow');
//		} 
//		
//	});
//	
//});

// step55
//$(function() {
//
//	var classMap = {
//		'switcher-large' : 'large',
//		'switcher-narrow' : 'narrow',
//		'switcher-default' : ''
//	};
//
//	// 모든 switcher 버튼에 대한 이벤트 핸들러 설정
//	$('.button').on('click', function() {
//		// 현재 클릭된 버튼의 ID를 기반으로 적용할 클래스 결정
//		var newClass = classMap[this.id];
//
//		// body에서 모든 관련 클래스 제거 후 새 클래스 추가 (있을 경우)
//		$('body').removeClass('large narrow').addClass(newClass);
//
//		// 모든 버튼에서 'selected' 클래스 제거 후 현재 버튼에만 추가
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//	});
//});

// step6
// $(function() {
// let classState = "";
//	
// $('#switcher .button').click(() => {
// $('.button').removeClass('selected');
// $(this).addClass('selected');
// $('body').removeClass();
//		
// if (classState !== "") {
// $('body').removeClass(classState);
// }
//		
// if(this.id === 'switcher-large') {
// classState = "large";
// $('body').addClass('large');
// } else if(this.id === 'switcher-narrow') {
// classState = "narrow";
// $('body').addClass('narrow');
// }
//		
// });
//	
// });

// step7
$(function() {
	$('#switcher .button').hover(function() {
		$(this).addClass('hover');
	}, function() {
		$(this).removeClass('hover');
	});
});

// step8
// $(function() {
// let classState = "";
//
// $('#switcher .button').click(function() {
// $('.button').removeClass('selected');
// $(this).addClass('selected');
// $('body').removeClass();
//
// if (classState !== "") {
// $('body').removeClass(classState);
// }
//
// if (this.id === 'switcher-large') {
// classState = "large";
// $('body').addClass('large');
// } else if (this.id === 'switcher-narrow') {
// classState = "narrow";
// $('body').addClass('narrow');
// }
// });
//
// $('#switcher > h3').click(function() {
// $(this).nextAll().toggleClass('hidden');
// });
//
// });

// step9
// $(function() {
// let classState = "";
//
// $('#switcher .button').click(function(e) {
// e.stopPropagation();
//
// $('.button').removeClass('selected');
// $(this).addClass('selected');
// $('body').removeClass();
//
// if (classState !== "") {
// $('body').removeClass(classState);
// }
//
// if (this.id === 'switcher-large') {
// classState = "large";
// $('body').addClass('large');
// } else if (this.id === 'switcher-narrow') {
// classState = "narrow";
// $('body').addClass('narrow');
// }
// });
//
// $('#switcher').click(function() {
// $('#switcher .button').toggleClass('hidden');
// });
//
// });

// step10
$(function() {
	let classState = "";

	$('#switcher .button').on('click', function(e) {
		e.stopPropagation();

		$('.button').removeClass('selected');
		$(this).addClass('selected');
		$('body').removeClass();

		if (classState !== "") {
			$('body').removeClass(classState);
		}

		if (this.id === 'switcher-large') {
			classState = "large";
			$('body').addClass('large');
		} else if (this.id === 'switcher-narrow') {
			classState = "narrow";
			$('body').addClass('narrow');
		} else {
			$('#switcher').on('click.kcc', function() {
				$('#switcher .button').toggleClass('hidden');
			});
		}

	});

	$('#switcher').on('click.kcc', function() {
		$('#switcher .button').toggleClass('hidden');
	});

	// $('#switcher').on('click.kosa', function() {
	// alert('다른 이벤트 발생');
	// });

	$('#switcher-large, #switcher-narrow').click(function() {
		$('#switcher').off('click.kcc');
	});

	$('#switcher').trigger('click.kcc');
});