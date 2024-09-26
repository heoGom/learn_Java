class Dog {
  int age;
  String name;
// {}를 쓰면 선택해서 쓸수 있다. 선택적 매개변수
// required를 쓰면 반드시 받아야한다.
// cascade ..
  Dog({required this.age, required this.name});
}

class Cat {
  int? age;
  String? name;

  Cat({this.age, this.name = "토토"});

  void cry() {
    print("야옹");
  }
}

void main() {
  Dog d = Dog(name: "토토", age: 10);
  Cat c = Cat(age: 15)..cry();
  print("개는 : ${d}");
  print("고양이는 : ${c}");
}
