// 함수의 실행 컨텍스트
// Lexical Scope : '선언'된 위치가 상위 스코프를 결정한다. => JavaScript
// Dynamic Scope : '실행'한 위치가 상위 스코프를 결정한다.

let var1 = 10;

function func() {
  let var2 = 20;
  console.log(var1);
}
// func();

// let value = 'value1';

// function printFunction() {
//   let value = 'value2';

//   function printValue() {
//     return value;
//   }

//   console.log(printValue());
// }
// printFunction();

let value = 'value1';

function printValue() {
  return value;
}

function printFunction(func) {
  let value = 'value2';

  console.log(func());
}

printFunction(printValue);

console.log('========================================');

// functionTwo 함수 선언문 기준, 상위 스코프는 여기!
var numberThree = 3;

function functionOne() {
  var numberThree = 100;
  functionTwo();
}

function functionTwo() {
  console.log(numberThree); // numberThree의 선언된 위치는 어디?
}

functionOne();

console.log('========================================');

var i = 999;

// var는 함수를 제외하고는 렉시컬 스코프가 적용되지 않아, i=999가 반복분 선언에서 재할당되었다(0)
for (var i = 0; i < 10; i++) {
  console.log(i);
}
console.log(i);

console.log('========================================');

let i = 999;

// i의 선언 위치 = 상위 스코프
for (let i = 0; i < 10; i++) {
  console.log(i);
}
console.log(i);

console.log('========================================');

var var3 = 100;

function func3() {
  // 예외적인 상황) '함수' 내에서 선언된 var는 함수 내부에서만 사용한다.
  // '함수' 이외에는 var는 렉시컬 스코프에 적용되지 않는다. (var를 지양하자.)
  var var3 = 200;
  console.log(var3);
}
func3();
console.log(var3);

/**
 * 1. var 키워드는 함수 레벨 스코프만 만든다.
 * 2. let, const 키워드는 함수 레벨 스코프와 블록 레벨 스코프를 만든다.
 */
