const subwayList = [
  '영등포구청역',
  '당산역',
  '합정역',
  '홍대입구역',
  '신촌역',
  '이대역',
  '아현역',
  '충정로역',
  '시청역',
  '을지로3가역',
  '을지로4가역',
  '동대문역사문화공원역',
  '신당역',
  '상왕십리역',
  '왕십리역',
  '한양대역',
  '뚝섬역',
  '성수역',
  '건대입구역',
  '구의역',
  '강변역',
  '잠실나루역',
  '잠실역',
  '종합운동장역',
  '삼성역',
  '선릉역',
  '역삼역',
  '강남역',
  '서초역',
  '방배역',
  '사당역',
  '낙성대역',
  '서울대입구역',
  '봉천역',
  '신림역',
  '신대방역',
  '구로디지털단지역',
  '대림역',
  '신도림역',
  '문래역',
];

const INTERVAL_DISTANCE = 3170; //역간 거리(고정)

const calculate = () => {
  const startPosition = document.querySelector('#start').value;
  const endPosition = document.querySelector('#end').value;
  const ageTypes = document.querySelectorAll('[type=radio]');

  // 기본 요금
  const defaultFee = getDefaultFee(ageTypes);

  // 총 역수
  const totalSubwayCnt = endPosition - startPosition;

  // 총 거리
  const totalDistance = totalSubwayCnt * INTERVAL_DISTANCE;

  // 총 금액
  let totalPrice = defaultFee;
  if (totalDistance <= 10000) {
    totalPrice = defaultFee;
  } else if (totalDistance > 10000 && totalDistance <= 50000) {
    totalPrice += Math.floor((totalDistance - 10000) / 5000) * 100;
  } else {
    totalPrice += Math.floor((totalDistance - 10000) / 8000) * 100;
  }

  // 결과값
  const template = `<p>출발역은 ${subwayList[startPosition]}, 도착역은 ${subwayList[endPosition]}입니다.</p>
      <p>총 ${totalSubwayCnt}개의 역을 승차했고, 총 거리는 ${totalDistance}m입니다.</p>
      <p>총 요금은 ${totalPrice}원입니다.</p>`;
  document.querySelector('#output').innerHTML = template;
};

const getDefaultFee = (ageTypes) => {
  let defaultFee = 0;

  for (const ageType of ageTypes) {
    if (ageType.checked) {
      switch (ageType.value) {
        case 'ADULT':
          defaultFee = 1250;
          break;
        case 'YOUNG':
          defaultFee = 720;
          break;
        case 'CHILD':
          defaultFee = 450;
          break;
      }
    }
  }

  return defaultFee;
};

function loadSubways() {
  var h = [];
  for (var idx in subwayList) {
    h.push(`<option value="${idx}">${subwayList[idx]}</option>`);
  }

  document.getElementById('start').innerHTML = h.join('');
  document.getElementById('end').innerHTML = h.join('');
}

function initEventListener() {
  document.querySelector('button').addEventListener('click', calculate);
}

window.addEventListener('load', function () {
  loadSubways();
  initEventListener();
});
