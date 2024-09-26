void main() {
  var n1 = 1;
  // n1 ="가자"; 이거안됨
  var d1 = 10.1;
  var b1 = true;
  var s1 = "홍길동";
  var t1;
  print("t1의 초기화 전 타입 : ${t1.runtimeType}");
  t1 = 2;
  print("t1의 초기화 후 타입 : ${t1.runtimeType}");
  // print() 함수는 Console에 출력을 해주는 함수입니다.
  // ${} 를 활용하면 문자열에 변수를 바인딩할 수 있습니다.
  print("정수 : ${n1}");
  print("실수 : ${d1}");
  print("부울 : ${b1}");
  print("문자열 : ${s1}");
  print("정수 : ${n1.runtimeType}");
  print("실수 : ${d1.runtimeType}");
  print("부울 : ${b1.runtimeType}");
  print("문자열 : ${s1.runtimeType}");
}
