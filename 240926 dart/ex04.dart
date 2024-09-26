void main() {
  dynamic n1 = 1;
  print("정수 : ${n1.runtimeType}");
  // dynamic 타입은 모든 타입을 받을 수 있고 다른 타입으로 변경도 가능하다.
  n1 = 10.5;
  print("n1 : ${n1.runtimeType}");
}
