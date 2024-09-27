class User {
  int id;
  String username;
  String password;

  User(this.id, this.username, this.password);

  User.hello(
      {required this.id, required this.username, required this.password});

  User.fromJson(Map<String, dynamic> json)
      : this.id = json["id"],
        this.username = json["username"],
        this.password = json["password"];
}

void main() {
  User u1 = User(1, "ssar", "1234");
  User u2 = User.hello(id: 1, username: "ssar", password: "1234");
  User u3 = User.fromJson({"id": 1, "username": "ssar", "password": "1234"});

  print(u1.username);
  print(u2.username);
  print(u3.username);
}
