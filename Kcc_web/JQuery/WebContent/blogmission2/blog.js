const getList = function() {
	$.ajax({
		url : 'server.jsp',
		type : 'get',
		dataType : 'json',
		success : function(data) {
			$.each(data,  function() {
				let html = `<div id="list-item">
			<h3>${this.title}</h3>
			<div>
				<span class="writer">작성자:</span> <span>${this.writer}</span>
			</div>
			<div>
				<p>${this.contents}</p>
			</div>
			<span class="delete-btn">삭제</span>
		</div>`;
				
				$('#list').append(html);
			})
		},
		error : function(request, status, error) {
			console.log('request: ' + request + 'status: ' + status
					+ 'error: ' + error);
		}
	});
}


$(function() {
	$(window).on('load', function(){
		$('#list').on('click' ,'.delete-btn', function() {
		// if(e.target.classList.contains('delete-btn')){
		// event.target.closest('#list-item').remove();
		// }
			$(this).closest('#list-item').remove();
		});
		getList();
	});
});

$(function() {
	$('form').submit(
			function() {

				$.ajax({
					url : 'server.jsp',
					type : 'post',
					data : $(this).serialize(),
					dataType : 'json',
					success : function() {
						console.log('insert data success!');
						getList();
					},
					error : function(request, status, error) {
						console.log('request: ' + request + 'status: ' + status
								+ 'error: ' + error);
					}
				});

				return false;
			});

});