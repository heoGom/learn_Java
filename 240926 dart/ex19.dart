void main() {
  var chobab = ["새우초밥", "광어초밥", "연어초밥"];

  var changeChobab = chobab.where((e) => e == "새우초밥").toList();
  var removeChobab = chobab.where((e) => e != "새우초밥").toList();

  print(changeChobab);
  print(removeChobab);
}
