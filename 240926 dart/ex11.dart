class Burger {
  Burger() {
    print("버거 생성됨");
  }
}

class CheeseBurger extends Burger {
  String name;
  CheeseBurger(String name) : this.name = name {
    print("치즈버거 생성됨");
  }
}

void main() {
  Burger b1 = CheeseBurger("치즈버거");
}
