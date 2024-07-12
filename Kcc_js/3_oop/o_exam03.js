/**
 * Prototype
 */

// __proto__ : 모든 객체에 존재하는 프로퍼티
const testObj = {};
console.log(testObj.__proto__);

console.log('==========================');

function IdolModel(name, year) {
  this.name = name;
  this.year = year;
}

// console.log(IdolModel.prototype);
// console.dir(IdolModel.prototype, {
//   showHidden: true,
// });

console.log(IdolModel.prototype);
console.log(IdolModel.prototype.constructor === IdolModel);
console.log(IdolModel.prototype.constructor.prototype === IdolModel.prototype);

const yuJin = new IdolModel('안유진', 2003);
console.log(yuJin.__proto__);
console.log(yuJin.__proto__ === IdolModel.prototype); // __proto__: 인스턴스가 가지고 있음, prototype: 클래스가 가지고 있음
// __proto__가 prototype를 참조하고 있다.

console.log(testObj.__proto__ === Object.prototype); // true

console.log(yuJin.toString());
console.log(Object.prototype.toString());

console.log(IdolModel.__proto__ === Function.prototype);
console.log(Function.prototype.__proto__ === Object.prototype);
console.log(IdolModel.prototype.__proto__ === Object.prototype);
// __proto__는 부모의 prototype를 가리키는 포인터

function IdolModel2(name, year) {
  this.name = name;
  this.year = year;

  this.sayHello = () => {
    return `${this.name}이 인사를 합니다.`;
  };
}

const yuJin2 = new IdolModel2('안유진', 2003);
const wonYoung2 = new IdolModel2('장원영', 2002);

console.log(yuJin2.sayHello());
console.log(wonYoung2.sayHello());
console.log(yuJin2.sayHello === wonYoung2.sayHello); // false, 함수의 메모리가 독립적으로 존재(비효율...)
console.log(yuJin2.hasOwnProperty('sayHello'));

// 프로토타입으로 메모리 효율 증가
function IdolModel3(name, year) {
  this.name = name;
  this.year = year;
}

IdolModel3.prototype.sayHello = function () {
  return `${this.name}이 인사를 합니다.`;
};

const yuJin3 = new IdolModel3('안유진', 2003);
const wonYoung3 = new IdolModel3('장원영', 2002);

console.log(yuJin3.sayHello());
console.log(wonYoung3.sayHello());

console.log(yuJin3.sayHello === wonYoung3.sayHello); // true
console.log(yuJin3.hasOwnProperty('sayHello')); // false

console.log('=================================');

function Student(name, kor, eng, mat) {
  this.name = name;
  this.kor = kor;
  this.eng = eng;
  this.mat = mat;
}

Student.prototype = {
  getSum: function () {
    return this.kor + this.eng + this.mat;
  },
  getAverage: function () {
    return Math.round(this.getSum() / 3).toFixed(1);
  },
  toString: function () {
    return this.name + '\t\t' + this.getSum() + '\t\t' + this.getAverage();
  },
};

const st1 = new Student('황철원', 50, 50, 50);
const st2 = new Student('박철원', 100, 50, 50);

console.log(st1.toString());
