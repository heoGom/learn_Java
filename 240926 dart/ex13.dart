mixin Engine {
  int power = 5000;
}

mixin Wheel {
  int count = 4;
}

class Sonata with Engine, Wheel {}

void main() {
  Sonata s = Sonata();
  print(s.power);
  Engine e = Engine();

  print(e.power);
}
