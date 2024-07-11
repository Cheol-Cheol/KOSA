/**
 * 타입변환(형변환)
 * 1) 명시적
 * 2) 암묵적
 */

// 명시적
let age = 20;
let stringAge = age.toString();
console.log(typeof stringAge); // string

// 암묵적
let test = age + '';
console.log(typeof test); // string

console.log('100' + '2'); // 1002

// 문자열 -> 숫자형(number): eval(), Number(), parseInt(), parseFloat()
let num = '100';
// num = eval(num);
// num = Number(num);
num = parseInt(num); // '권장'
let result = num + 100; // 200
console.log(result);

/**
 * 호이스팅(Hoisting)
 * - 모든 변수 선언문이 코드의 최상단으로 이동되는 것처럼 느껴지는 현상
 * - let, const도 호이스팅은 발생하지만, var보다는 제약이 존재한다.
 */

var name;
console.log(name); // undefined
name = '홍길동';
console.log(name); // 홍길동

// var kim; - 호이스팅
console.log(kim); // undefined
var kim = '김씨';
