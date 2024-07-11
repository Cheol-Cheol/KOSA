// 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요.
function solution1(num) {
  return num
    .toString()
    .split('')
    .reduce((acc, cur) => acc + parseInt(cur), 0);
}
console.log(solution1(1234));

// 문자열 my_string이 매개변수로 주어질 때, my_string안에 있는 숫자만 골라 오름차순
// 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.
function solution2(str) {
  return str
    .split('')
    .filter((el) => !isNaN(el))
    .map((n) => n)
    .sort();
}
console.log(solution2('p2o4i8gj2'));

// 년도인자만 받을 경우 -> "1234년"과 같은 문자열을 리턴
// 년도, 월, 인자를 받을 경우 -> "1234년 5월"과 같은 문자열 리턴
// 년도, 월, 일, 인자를 전부 받을 경우 -> "1234/5/6"과 같은 형식의 문자열을 리턴해주세요.
function solution3(...args) {
  const dateFormatArr = ['년', '월', '일'];
  let result = '';

  for (let index = 0; index < args.length; index++) {
    result += args[index] + dateFormatArr[index] + ' ';
  }

  return result;
}
console.log(solution3(2024, 7, 5));
