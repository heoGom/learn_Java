// null 처리 방법

int? findById(int id) {
  return id == 1 ? 1 : null;
}

void main() {
  // 무조건 있어!! 제일 위험한 처리
  int r1 = findById(1)!;
  print(r1);

  int r2 = findById(5) ?? 0;
  print(r2);

  // double r3 = findById(5)!.toDouble();
  // null이 아니면 실행하고 null이면 실행하지마!
  double r3 = findById(5)?.toDouble() ?? 0;
  print(r3);
}
