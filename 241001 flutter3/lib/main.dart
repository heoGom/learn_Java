import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          leading: Icon(
            Icons.arrow_back_ios,
            color: Colors.blue,
          ),
          title: Text("Profile"),
          centerTitle: true,
        ),
        endDrawer: Container(
          width: 200,
          color: Colors.blue,
        ),
        body: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 16),
          child: Column(
            children: [
              Row(
                children: [
                  CircleAvatar(
                    radius: 50,
                    backgroundColor: Colors.white,
                    backgroundImage: AssetImage("assets/avatar.png"),
                  ),
                  const SizedBox(width: 20),
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text("GetInThere"),
                      Text("프로그래머/작가/강사"),
                      Text("데어 프로그래밍"),
                    ],
                  ),
                ],
              ),
              const SizedBox(height: 20),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  _numtext("50", "Post"),
                  _line(),
                  _numtext("10", "Likes"),
                  _line(),
                  _numtext("3", "Share"),
                ],
              ),
              const SizedBox(height: 20),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  _button("Follow", Colors.blue),
                  _button("Message", Colors.grey),
                ],
              ),
              Expanded(
                child: DefaultTabController(
                  length: 2,
                  child: Column(
                    children: [
                      TabBar(
                        tabs: [
                          Tab(icon: Icon(Icons.directions_car)),
                          Tab(icon: Icon(Icons.directions_transit)),
                        ],
                      ),
                      Expanded(
                        child: TabBarView(
                          children: [
                            Center(child: Text("Screen 1")),
                            Center(child: Text("Screen 2")),
                          ],
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  InkWell _button(String text, Color mColor) {
    return InkWell(
      onTap: () {
        print("$text 버튼 클릭됨");
      },
      child: Container(
        alignment: Alignment.center,
        width: 150,
        height: 45,
        child: Text("$text"),
        decoration: BoxDecoration(
          color: mColor,
          borderRadius: BorderRadius.circular(10),
        ),
      ),
    );
  }

  Container _line() {
    return Container(
      height: 60,
      decoration: BoxDecoration(
        border: Border.all(
          color: Colors.blue,
        ),
      ),
    );
  }

  Column _numtext(String num, String text) {
    return Column(
      children: [
        Text("$num"),
        Text("$text"),
      ],
    );
  }
}
