// console.log(add(10, 20));
// console.log(add2(100, 200));

// 선언적 함수
function add(a, b) {
  let sum = a + b;
  return sum;
}

// 익명 함수
let add2 = function (a, b) {
  let sum = a - b;
  return sum;
};

console.log(add(10, 20));
console.log(add2(100, 200));

// add2 vs add2()
let plus = add2; // 함수: 주소값 할당 -> plus도 함수
let plus2 = add2(); // 함수를 호출 -> 리턴값을 전달

console.log(plus(50, 100));

// 함수의 파라미터에 함수를 전달할 수 있다. (콜백함수)
let foo = function (func) {
  if (typeof func === 'function') {
    func();
  }
};

foo(function () {
  console.log('파라미터에 함수를 전달하는 예제');
});

// 함수가 함수를 리턴할 수 있다.
// 함수를 리턴하는 예제와 함께 리턴된 함수를 호출해보자
function foo2() {
  return function () {
    console.log('함수를 리턴하는 예제');
  };
}

let box = foo2();
box();

// 함수의 파라미터에(plus or minus)
function plus() {
  console.log('plus() 호출!');
}

function minus() {
  console.log('minus() 호출!');
}

function abc(cmd) {
  if (cmd === 'plus') {
    return plus();
  } else {
    return minus();
  }
}

let re = abc('plus');

console.log('=============================');

function abc2(cmd) {
  this.cmd = cmd;
  this.print = function () {
    console.log(`${cmd}() 호출!`);
  };
}

ist = new abc2('plus');
ist.print();

console.log('=============================');

function call(mode) {
  let obj = {
    plus: function (left, right) {
      return left + right;
    },
    minus: function (left, right) {
      return left - right;
    },
  };

  return obj[mode];
}

console.log(call('plus')(1, 2));

console.log('=============================');

// 콜백함수(함수의 파라미터에 전달되는 함수)
function sortDescending(a, b) {
  return b - a;
  // if (a > b) {
  //   return -1;
  // } else if (a < b) {
  //   return 1;
  // } else {
  //   return 0;
  // }
}

let arr = [94, 2, 45, 231, 33];
console.log(arr.sort(sortDescending));

// 즉시실행함수: 함수정의와 동시에 호출
(function (a, b) {
  console.log(a + b);
})(1, 2);
