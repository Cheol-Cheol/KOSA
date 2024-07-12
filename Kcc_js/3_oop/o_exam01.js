/**
 * 자바스크립트 객체
 * 1) 사용자 정의 객체
 *    1. Object 2. 객체 리터럴 3. 생성자 함수(프로토타입)
 * 2) 내장 객체(빌트인 객체)
 *    1. 코어객체(String, Number, Math, Array...)
 *    2. 브라우저 객체(window, document, history, navigator...)
 *    3. DOM 객체: 문서 내 모든 요소: div, form, p
 */

// 1) 사용자 정의 객체
// 1. Object 객체 이용
// - 자바스크립트 객체는 동적으로 프로퍼티를 추가/삭제할 수 있다.

let obj = new Object();
console.log(obj);

obj.name = 'cheolwon';
obj.age = 20;

console.log(obj); // { name : 'cheolwon', age : 20 }

// 함수는 1급 객체이다.
function add(a, b) {
  let sum = a + b;
  return sum;
}

console.log(typeof add); // function
console.log(add instanceof Object); // true

add.result = add(10, 20);
console.log(`결과: ${add.result}`);

// 리터럴 형식으로 객체 사용 => 1개의 객체를 생성해서 사용하는 경우
let obj2 = {
  name: '김길동',
  age: 30,
  display: function () {
    console.log(this.name);
  },
};
console.log(`이름: ${obj2.name}`);
console.log(`나이: ${obj2['age']}`);

// 퀴즈> 리터럴 형식으로 빈 객체를 생성 후 동적 프로퍼티와 함수를 추가 후 호출하는 예제를 구현하시오.
const obj = {};
obj.name = '황철원';
obj.display = () => console.log(`출력: ${obj.name}`);
obj.display();

// 객체 디스트럭처링: 객체의 프로퍼티를 풀어서 별개의 변수에 저장하는 방식
const person = {
  first: '홍',
  last: '길동',
};

let { first, last } = person;
console.log(first, last);

// const 객체생성
// 1) const로 선언할 경우 객체 자체를 변경할 수는 없다.
// 2) 객체 안의 프로퍼티나 메서드는 변경이 가능하다.
const objByConst = { name: 'cheolcheol', age: 28 };
objByConst.name = 'cheol';
objByConst.height = '173';
console.table(objByConst);
