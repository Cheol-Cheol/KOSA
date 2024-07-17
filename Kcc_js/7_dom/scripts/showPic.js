function showPic(e) {
  e.preventDefault(); // 기본 이벤트 취소

  const obj = e.target;

  const source = obj.getAttribute('href');
  const placeholder = document.getElementById('placeholder');
  placeholder.setAttribute('src', source);

  const text = obj.getAttribute('title');
  const description = document.getElementById('description');
  if (description.firstChild.nodeType === 3) {
    description.firstChild.nodeValue = text;
  }

  description.innerText = text;
}

function prepareGallery() {
  const imagegalley = document.getElementById('imagegallery');
  const links = imagegalley.getElementsByTagName('a');

  for (let i = 0; i < links.length; i++) {
    links[i].addEventListener(
      'click',
      function (e) {
        e.preventDefault();
        showPic(this);
      },
      false
    );
  }
}

window.onload = prepareGallery;
