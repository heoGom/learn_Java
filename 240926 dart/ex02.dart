void main() {
  int n1 = 1;
  double d1 = 10.1;
  bool b1 = true;
  String s1 = "홍길동";
  // print() 함수는 Console에 출력을 해주는 함수입니다.
  // ${} 를 활용하면 문자열에 변수를 바인딩할 수 있습니다.
  print("정수 : ${n1.runtimeType}");
  print("실수 : ${d1.runtimeType}");
  print("부울 : ${b1.runtimeType}");
  print("문자열 : ${s1.runtimeType}");
}
