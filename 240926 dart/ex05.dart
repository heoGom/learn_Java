String? username = null; // 전역 정적 메모리 (static)

void main() {
  //username이 null이면 "임시아이디" 로 값이 바뀐다.
  username ??= "임시아이디";
  print(username);
}
