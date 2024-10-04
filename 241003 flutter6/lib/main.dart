import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: HomePage(),
    );
  }
}

// 1. Father 클래스 생성 -sf
// 2. Father 클래스가
class HomePage extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    print("HomePage그려짐");
    return Container(
      color: Colors.yellow,
      child: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          children: [
            Header(),
            Expanded(child: Father()),
          ],
        ),
      ),
    );
  }
}

class Father extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _FatherState();
}

class _FatherState extends State<Father> {
  int num = 1;

  void add() {
    num++;
    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Expanded(
          child: Top(num: num),
        ),
        Expanded(
          child: Bottom(add: add),
        ),
      ],
    );
  }
}

class Header extends StatelessWidget {
  Header();

  @override
  Widget build(BuildContext context) {
    print("Header그려짐");
    return Container(
      color: Colors.green,
      height: 200,
    );
  }
}

class Bottom extends StatelessWidget {
  final add;

  Bottom({required this.add});

  @override
  Widget build(BuildContext context) {
    print("Bottom그려짐");
    return Container(
      color: Colors.blue,
      child: Align(
        child: ElevatedButton(
          style: ElevatedButton.styleFrom(backgroundColor: Colors.red),
          onPressed: () {
            add();
          },
          child: Text(
            "증가",
            style: TextStyle(
              color: Colors.white,
              fontWeight: FontWeight.bold,
              fontSize: 100,
            ),
          ),
        ),
      ),
    );
  }
}

class Top extends StatelessWidget {
  Top({
    required this.num,
  });

  final int num;

  @override
  Widget build(BuildContext context) {
    print("Top그려짐");
    return Container(
      color: Colors.red,
      child: Align(
        child: Text(
          "${num}",
          style: TextStyle(
              color: Colors.white,
              fontWeight: FontWeight.bold,
              fontSize: 100,
              decoration: TextDecoration.none),
        ),
      ),
    );
  }
}
