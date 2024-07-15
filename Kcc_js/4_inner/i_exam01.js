/**
 * Array(배열)
 */

let kccMembers = ['진아', '수호', '한희', '채원', '주언', '연호'];

console.log(kccMembers);

// push()
console.log(kccMembers.push('승언'));
console.log(kccMembers);

console.log('---------------------------');

// pop()
console.log(kccMembers.pop());
console.log(kccMembers);

console.log('---------------------------');

// unshift()
console.log(kccMembers.unshift('현민'));
console.log(kccMembers);

// shift()
console.log(kccMembers.shift());
console.log(kccMembers);

console.log('---------------------------');

// splice()
console.log(kccMembers.splice(0, 3));
console.log(kccMembers);

console.log('---------------------------');

// 불변성 함수
kccMembers = ['진아', '수호', '한희', '채원', '주언', '연호'];
console.log(kccMembers);
console.log('---------------------------');

console.log(kccMembers.concat('승우'));
console.log(kccMembers); // 불변

console.log('---------------------------');

// slice()
console.log(kccMembers.slice(0, 4));
console.log(kccMembers); // 불변

console.log('---------------------------');

// spread operator
let kccMembers2 = [...kccMembers];
console.log(kccMembers);

let kccMembers3 = kccMembers;
console.log(kccMembers3);

console.log('---------------------------');
console.log(kccMembers === kccMembers3);
console.log(kccMembers === kccMembers2);

let kccMembers4 = ['홍길동', '박길동', ...kccMembers, '조길동', '한길동'];
console.log(kccMembers4);

let arr1 = [100, 200, 300];

function sum(a, b, c) {
  return a + b + c;
}

console.log(sum(...arr1));

console.log('---------------------------');

// join()
console.log(kccMembers.join()); // 배열 -> 문자열

console.log('---------------------------');

// sort()
console.log(kccMembers.sort());
console.log(kccMembers.reverse());

let numbers = [1, 0, 3, 2, 6];
numbers.sort((a, b) => a - b);
console.log(numbers);
numbers.sort((a, b) => b - a);
console.log(numbers);

console.log('---------------------------');

const books = [
  { name: '이것이 자바다', price: 30000, publisher: '한빛미디어' },
  { name: '스프링 정석', price: 35000, publisher: '길벗' },
  { name: '도커의 완성', price: 20000, publisher: '이지스퍼블릭' },
];

// 1) 이름을 기준으로 오름차순하고 전체 출력하세요(for~in, for~of)
books.sort((a, b) => a.name.localeCompare(b.name));
console.table(books);

// filter
numbers = [1, 8, 7, 4, 9];
console.log(numbers.filter((x) => x % 2 === 0));

// find
console.log(numbers.find((x) => x % 2 === 0));

// reduce()
console.log(
  numbers.reduce((acc, curr) => acc + curr),
  0
);

// 퀴즈) iveMembers 변수에 있는 모든 스트링 값들을 더해 보자
const iveMembers = [
  {
    name: '안유진',
    year: 2003,
  },
  {
    name: '가을',
    year: 2002,
  },
  {
    name: '레이',
    year: 2004,
  },
  {
    name: '장원영',
    year: 2004,
  },
  {
    name: '리즈',
    year: 2004,
  },
  {
    name: '이서',
    year: 2007,
  },
];

console.log(iveMembers.reduce((acc, prev) => acc + prev.name.length, 0));
