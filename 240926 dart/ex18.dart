void main() {
  var chobab = ["새우초밥", "광어초밥", "연어초밥"];

  // chobab[0] = chobab[0]+"_간장";
  // chobab[1] = chobab[1]+"_간장";
  // chobab[2] = chobab[2]+"_간장";

  // for (var i = 0; i < chobab.length; i++) {
  //   chobab[i] = chobab[i] + "_간장";
  // }

  var changeChobab = chobab.map((e) => e + "_간장").toList();

  print(chobab);
  print(changeChobab);
}
