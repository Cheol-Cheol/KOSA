/**
 * 1-1. Rectangle 생성자 함수를 class 기반으로 수정
 * 1-2. 상속을 이용해서 Square 구현해보세요.
 */

// function Rectangle(width, height) {
//   this.width = width;
//   this.height = height;

//   this.getArea = () => {
//     return this.width * this.height;
//   };
// }

class Rectangle {
  #width;
  #height;

  constructor(width, height) {
    this.#width = width;
    this.#height = height;
  }

  getArea = () => {
    return this.#width * this.#height;
  };
}

class Square extends Rectangle {
  constructor(side) {
    super(side, side);
  }
}

const r1 = new Rectangle(3, 4);
console.log(r1.getArea());

const s1 = new Square(4);
console.log(s1.getArea());

iveMembers = ['유진', '가을', '레이', '원영', '리즈', '이서'];
