/**
 * 함수 클로저
 * => 함수 호출 이후에도 함수의 실행 컨텍스트 영역을 유지
 */

function outerFunc() {
  let x = 10;
  var innerFunc = function () {
    console.log(x);
  };

  return innerFunc; // 함수 반환
}

let inner = outerFunc();
inner();

// 데이터 캐싱
function cashFunction(newNumb) {
  // 아주 오래 소요하는 작업
  var number = 10 * 10; // 호출할 때 마다 반복 수행

  return number * newNumb;
}

console.log(cashFunction(10));
console.log(cashFunction(20));

console.log('=================');

// 데이터 캐싱(클로저 방식)
function cashFunction2() {
  // 아주 오래 소요하는 작업
  var number = 10 * 10; // 생명주기가 계속 살아있어, 최초 1번 연산 이후 호출할 때마다 연산을 수행하지 않아도 된다.

  function innerCashFunction(newNumb) {
    return number * newNumb; // number값은 캐싱
  }

  return innerCashFunction; // 반환 함수를 사용 시, ()를 붙여주지 않는다. 만약에 붙이면 즉시 실행 함수로 되어 바로 실행이 된다.
}

const runner = cashFunction2(); // innerCashFunction 리턴됨
console.log(runner(30));
console.log(runner(40));

// 누적합
function outer(arg1, arg2) {
  let sum = arg1 + arg2;

  function inner(newNum) {
    sum += newNum;
    return sum;
  }

  return inner;
}

// const runner2 = outer(16, 14);
// console.log(runner2(30));
// console.log(runner2(60));
console.log(outer(16, 14)(10));
