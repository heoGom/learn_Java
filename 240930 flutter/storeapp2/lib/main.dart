import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      // 디자인
      home: Scaffold(
        body: SafeArea(
          child: Column(
            children: [
              Padding(
                padding: const EdgeInsets.all(16.0),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text("Woman", style: TextStyle(fontSize: 16)),
                    Text("Kids", style: TextStyle(fontSize: 16)),
                    Text("Shoes", style: TextStyle(fontSize: 16)),
                    Text("Bag", style: TextStyle(fontSize: 16)),
                  ],
                ),
              ),
              Expanded(
                  child: Image.asset(
                "assets/bag.jpeg",
                fit: BoxFit.cover,
              )),
              SizedBox(height: 10),
              Expanded(
                  child: Image.asset(
                "assets/cloth.jpeg",
                fit: BoxFit.cover,
              )),
            ],
          ),
        ),
      ), // 뼈대
    );
  }
}
