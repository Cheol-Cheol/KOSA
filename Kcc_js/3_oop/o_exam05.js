/**
 * 상속
 */

class IdolModel {
  name;
  year;

  constructor(name, year) {
    this.name = name;
    this.year = year;
  }

  sayHello() {
    return `안녕하세요 ${this.name} 입니다.`;
  }
}

class FemaleIdolModel extends IdolModel {
  part;

  constructor(name, year, part) {
    super(name, year);
    this.part = part;
  }

  dance() {
    return '여자 아이돌이 춤을 춥니다.';
  }

  sayHello() {
    return `안녕하세요 ${this.name} 입니다. 아이브의 ${this.part}파트를 담당하고 있습니다.`;
  }
}

const yuJin = new FemaleIdolModel('안유진', 2003, '보컬');
console.log(yuJin);
console.log(yuJin.dance());

console.log(yuJin instanceof FemaleIdolModel);
console.log(yuJin instanceof IdolModel);

console.log(yuJin.sayHello());
