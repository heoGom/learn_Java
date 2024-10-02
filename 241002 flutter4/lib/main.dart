import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: "/login",
      routes: {
        "/login": (context) => LoginPage(),
        "/home": (context) => HomePage()
      },
    );
  }
}

class LoginPage extends StatelessWidget {
  final username = TextEditingController();
  final password = TextEditingController();
  final ScrollController _scrollController = ScrollController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // resizeToAvoidBottomInset: true,
      body: ListView(
        controller: _scrollController,
        children: [
          InkWell(
            onTap: () => {FocusScope.of(context).unfocus()},
            child: Container(
              height: 500,
              color: Colors.yellow,
            ),
          ),
          TextFormField(
            onTap: () {
              _delayScrollDown();
            },
            controller: username,
            decoration: InputDecoration(
              hintText: "Username",
              prefixIcon: Icon(Icons.person),
            ),
          ),
          TextFormField(
            onTap: () {
              _delayScrollDown();
            },
            controller: password,
            obscureText: true,
            decoration: InputDecoration(
              hintText: "Password",
              prefixIcon: Icon(Icons.password),
            ),
          ),
          ElevatedButton(
            onPressed: () {
              // 1. 값 가져오기
              String un = username.text;
              String pw = password.text;
              print(un);
              print(pw);
              // 2. 통신하기

              // 3. 화면 이동 (A->B)
              // [A,B] pushName
              // [B] pushReplaceName
              // [B] pushNamedAndRemoveUntil
              Navigator.pushNamed(context, "/home");
            },
            child: Text("로그인"),
          ),
          // SizedBox(height: 300),
        ],
      ),
    );
  }

  Future? _delayScrollDown() {
    return Future.delayed(Duration(milliseconds: 500), () {
      _scrollController.animateTo(
        _scrollController.position.maxScrollExtent,
        duration: Duration(milliseconds: 1000),
        curve: Curves.bounceIn,
      );
    });
  }
}

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            //Navigator.pushNamed(context, "/login"); // [A, B, A]
            //Navigator.pushReplacementNamed(context, "/login");  // [A,A]
            //Navigator.pushNamedAndRemoveUntil(context, "/login", (route) => true); // [A]
            Navigator.pop(context); // [A]
          },
          child: Text("뒤로가기"),
        ),
      ),
    );
  }
}
