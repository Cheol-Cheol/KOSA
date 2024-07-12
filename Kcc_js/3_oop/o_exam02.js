/**
 * 생성자 함수를 이용한 객체 생성 -> 다수의 객체를 생성하기 위해서
 */

function Student(name, kor, eng, mat) {
  this.name = name;
  this.kor = kor;
  this.eng = eng;
  this.mat = mat;

  this.getSum = () => {
    return this.kor + this.eng + this.mat;
  };

  this.getAverage = () => {
    return Math.round(this.getSum() / 3).toFixed(1);
  };

  this.toString = () => {
    return this.name + '\t\t' + this.getSum() + '\t\t' + this.getAverage();
  };
}

let students = [];
students.push(new Student('홍길동', 80, 70, 90));
students.push(new Student('박길동', 30, 40, 60));

students.forEach((el) => console.log(el.toString()));

// 퀴즈> Rectangle 생성자 함수를 만들고 사각형 넓이를 구하여 보자.
function Rectangle(width, height) {
  this.width = width;
  this.height = height;

  this.getArea = () => {
    return this.width * this.height;
  };
}

const rec1 = new Rectangle(10, 10);
console.log(rec1.getArea());
