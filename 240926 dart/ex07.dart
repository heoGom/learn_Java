void whenComeMother(Function beh) {
  beh();
}
// void off(){
//   print("컴퓨터 끄기");
// }

// void main(){
//   whenComeMother(off());
// }

void main() {
  whenComeMother(() {
    print("컴퓨터 끄기");
  });
}
