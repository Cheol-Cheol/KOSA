/**
 * class 기반의 객체지향 프로그래밍
 */

class IdolModel {
  name;
  year;

  constructor(name, year) {
    this.name = name;
    this.year = year;
  }
}

console.log(new IdolModel('안유진', 2003));

class IdolModel2 {
  #name;
  #year;

  constructor(name, year) {
    this.#name = name;
    this.#year = year;
  }

  get name() {
    return this.#name;
  }

  get year() {
    return this.#year;
  }

  set name(name) {
    this.#name = name;
  }

  set year(year) {
    this.#year = year;
  }

  static returnGroupName() {
    return '아이브';
  }
}

let yuJin = new IdolModel2('안유진', 2003);
console.log(yuJin.name);
console.log(IdolModel2.returnGroupName());

/**
 * factory constructor(정적 팩토리)
 */

class IdolModel3 {
  name;
  year;

  constructor(name, year) {
    this.name = name;
    this.year = year;
  }

  static fromObject({ name, year }) {
    return new IdolModel3(name, year);
  }

  static fromList(list) {
    return new IdolModel3(...list);
  }
}

const yuJin2 = IdolModel3.fromObject({
  name: '안유진',
  year: 2003,
});

console.log(yuJin2);

const wonYoung = IdolModel3.fromList(['장원영', 2003]);
console.log(wonYoung);
