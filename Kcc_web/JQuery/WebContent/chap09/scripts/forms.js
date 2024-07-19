$(function() {
	$('.quantity input').change(
			function() {

				let totalCost = 0;
				let totalQuantity = 0;

				$('table tbody tr').each(
						function(index) {
							let price = parseFloat($(this).find('.price')
									.text().replace(/^[^\d.]/, ''));
							price = isNaN(price) ? 0 : price;

							let quantity = parseInt($(this).find(
									".quantity input").val());
							quantity = isNaN(quantity) ? 0 : quantity;

							const cost = price * quantity;
							$(this).find('.cost').text('$' + cost.toFixed(2));

							totalCost += cost;
							totalQuantity += quantity;

						});

				$('.subtotal .cost').text('$' + totalCost.toFixed(2));
				$('.shipping .quantity').text(totalQuantity);

				// 세금
				const totalTax = parseInt($('.tax .price').text().replace('%',
						''))
						* 0.01 * totalCost;
				$('.tax .cost').text('$' + totalTax);

				// 배송비
				const totalShipping = parseInt($('.shipping .price').text()
						.match(/\d+/)[0])
						* totalQuantity;
				$('.shipping .cost').text('$' + totalShipping);

				totalCost = totalCost + totalTax + totalShipping;
				$('.total .cost').text('$' + totalCost.toFixed(2));

			});
});