// 예외처리
// try ~ catch
// throw: 인위적으로 예외 발생
// finally: 예외발생과 상관없이 실행

function runner() {
  try {
    console.log('hello');
    throw new Error('문제 발생');
  } catch (e) {
    console.log('error catch');
  } finally {
    console.log('Done');
  }
}

runner();
