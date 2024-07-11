// 주석
/**
 * 여러줄 주석
 *
 */

// 변수 선언, 사용
var num = 100;
num = '안녕';
console.log(num);

// 컴파일 언어: 데이터형, 문법 => 엄격히 요구
// 인터프리터 언어: 문법적으로 느슨한 것 요구

// var: 여러 큰 스코프에서 공유하기 위한 최상위 변수 사용
// let: 작은 스코프에서 로컬변수 사용
// const: 상수값으로 사용

let a = 10;
a = '안녕';
console.log(a);

// 데이터 타입(자료형)
let intNum = 10;
let floatNum = 3.14;

console.log(typeof intNum); // number
console.log(typeof floatNum); // number

// 문자형(string)
let sinS = 'single';
let doubleS = 'double';

console.log(typeof sinS); // string
console.log(typeof doubleS); // string

/**
 * Template literal
 * 1. newline -> \n
 * 2. tab -> \t
 * 3. 백슬러시 문자열 안에 표현 -> \\
 */

const kcc1 = '김진아\n이수호';
console.log(kcc1);

const kcc2 = '김진아\t이수호';
console.log(kcc2);

const groupName = 'kcc';
console.log(`${groupName} 이한희`);

// 논리형(boolean)
/**
 * false
 * -> String 빈 문자열
 * -> 값이 없는 경우
 * -> 0
 */
let boolVar = true;
console.log(typeof boolVar);
// !! -> 논리 연산자로 변경
console.log(!!false); // false
console.log(!!''); // false
console.log(!!0); // false
console.log(!!undefined); // false
console.log(!!null); // false
console.log(!!'0'); // true
console.log(!!{}); // true
console.log(!![]); // true

// undefined
let emptyVar;
console.log(typeof emptyVar); // undefined

// null
let nullVar = null;
console.log(typeof nullVar); // object

// 함수(function)
let fun = function () {};
console.log(typeof fun); // function

// 객체(object)
let person = {
  name: '홍길동',
  age: 20,
};

console.log(typeof person); // object
console.log(person.name); // 홍길동
console.log(person['age']); // 20

// 배열(Array)
const kccMember = ['김현민', '윤채원', '김연호', '원승언'];

console.log(typeof kccMember); // object
console.table(kccMember);

/**
 * Symbol 타입
 * - 유일무이한 값을 생성할 때 사용
 */

const test1 = '1';
const test2 = '2';

console.log(test1 === test2);

const symbol1 = Symbol('1');
const symbol2 = Symbol('1');

console.log(symbol1 === symbol2);

console.log('=======================================');
