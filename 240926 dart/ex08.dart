class Dog {
  String name;
  int age;
  String color;
  int thirsty;

  Dog(String name, int age, String color, int thirsty)
      : this.name = name,
        this.age = age,
        this.color = color,
        this.thirsty = thirsty;
}

class Cat {
  String name;
  int age;
  String color;
  int thirsty;

  Cat(this.name, this.age, this.color, this.thirsty);
}
