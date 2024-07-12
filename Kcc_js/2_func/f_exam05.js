let replyService = (function () {
  function create() {
    console.log('create');
  }

  function update() {
    console.log('update');
  }

  function getList(param, callback) {
    let data = '결과값: ' + param;
    callback(data);
  }

  // 객체를 반환
  return {
    create,
    update,
    getList,
  };
})();

function show() {
  // replyService.create();
  replyService.getList('kosa', (re) =>
    console.log('내가 원하는 형태의 출력: ' + re)
  );
}
show();

console.log('============================');

function orderService(item, price, quantity, callback) {
  console.log('커피 주문');
  // 주문 관리 서비스 구현

  const result = `$품명: ${item} \t\t $가격: ${price} \t\t $수량: ${quantity} \t\t $총계: ${
    price * quantity
  }`;
  callback(result);
}

function order() {
  orderService('아메리카노', 3200, 1, (re) => console.log(re));
}

order();
