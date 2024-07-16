/**
 * 정규표현식(ReqExp)
 */

// 1. 문자열.match(정규표현식) => 매칭된 결과(문자열) 리턴
let result = 'sports'.match(/sp/);
console.log(result);

// 2. ReqExp.exec('문자열') => 매칭된 결과(문자열) 리턴
let str = 'fdsffs euyireijifsjseiqjidfs jkkjkjkjfs';
let re = /JS/gi;
result = re.exec(str);

while (result) {
  console.log(result);
  result = re.exec(str);
}

// 퀴즈 => July 16 2004
str = 'This is a data: July 16 2004';
const regex = /(\w+)\s(\d+)\s(\d+)/;
const match = str.match(regex);
console.log(match[0]);

// 퀴즈) 문자열.replace() sw => 소프트웨어 변경
str =
  '오늘 우리는 SW 세상에서 살고 있다. sw가 매우 중요한 시기이다. 그래서 SW 열심히 공부하자';
str = str.replaceAll(/SW/gi, '소프트웨어');
console.log(str);

str = 'Java--JavaScript';
re = /(\w+)-*(\w+)/;
result = str.replace(re, '$2-$1');
console.log(result);

// 이메일 체크
const emailRegex = /^[a-zA-Z][\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
const t1 = 'dolsam77@nate.com';
const t2 = '33dolsam77@nate.com';
const t3 = 'dolsam77nate.com';
const t4 = 'dolsam77@nate.comfdfsd';

console.log(emailRegex.test(t1));
console.log(emailRegex.test(t2));
console.log(emailRegex.test(t3));
console.log(emailRegex.test(t4));
