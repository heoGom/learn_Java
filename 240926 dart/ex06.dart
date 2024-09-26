//오버로딩을 지원하지 않는다.
// void add(int n1, int n2) {
//   print(n1 + n2);
// }
// void add(int n1, int n2, int n3) {
//   print(n1 + n2 + n3);
// }

//타입을 생략할수 있다.
//var 타입으로
//하지만 타입추론이 되지않아 나중에 까먹는다.
void add(n1, n2) {
  print(n1 + n2);
}

// var을 리턴할 수 없다.
// dynamic은 가능하다.
int minus(n1, n2) {
  return n1 - n2;
}

//익명 함수
Function f = (n1, n2) {
  return n1 * n2;
};
//람다 표현식
Function f2 = (n1, n2) => n1 * n2;

void main() {
  var result = minus(1, 2);
  print(result);
  print(f(1, 2));
  print(f2(2, 2));
}
