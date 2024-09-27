Map<String, dynamic> session = {"id": 1, "username": "ssar"};

void main() {
  session["model"] = "username";

  print(session["id"]);
  print(session["username"]);
  print(session["model"]);
  session.remove("id");
  print(session["id"]);
}
