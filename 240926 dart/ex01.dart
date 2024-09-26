// static > heap > stack
class Animal {
  int id = 1;
  static String name = "동물";
  void speak() {
    int nnn = 10;
    //메서드
  }
}

String name = "Hello World";

void hello() {
  // 메서드가 아닌 함수다. (기능을 가지는 친구)
  int num = 10;
}

void main() {
  print(name);
  print(Animal.name);
  Animal a = Animal();
  print(a.id);
}
