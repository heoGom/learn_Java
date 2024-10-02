import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(useMaterial3: true),
      home: const ProfilePage(),
    );
  }
}

class ProfilePage extends StatelessWidget {
  const ProfilePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      endDrawer: _menu(),
      appBar: _appbar(),
      body: ListView(
        children: [
          _header(),
          _middle(),
          SizedBox(child: _bottom(), height: 3050),
        ],
      ),
    );
  }

  Row _middle() {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceAround,
      children: [
        Column(
          children: [
            Text("50"),
            Text("10"),
          ],
        ),
        Container(
          width: 1,
          height: 100,
          color: Colors.black,
        ),
        Column(
          children: [
            Text("50"),
            Text("10"),
          ],
        ),
        Container(
          width: 1,
          height: 100,
          color: Colors.black,
        ),
        Column(
          children: [
            Text("50"),
            Text("10"),
          ],
        ),
      ],
    );
  }

  Container _menu() {
    return Container(
      width: 200,
      color: Colors.blue,
    );
  }

  AppBar _appbar() {
    return AppBar(
      iconTheme: IconThemeData(color: Colors.blue),
      title: Text("Profile"),
      centerTitle: true,
      leading: Icon(Icons.arrow_back_ios),
    );
  }

  Widget _header() {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 20),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          SizedBox(
            width: 80,
            height: 80,
            child: CircleAvatar(
              backgroundImage: NetworkImage(
                "https://cdn.imweb.me/thumbnail/20240220/105cc1508cf03.png",
              ),
            ),
          ),
          SizedBox(width: 50),
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text("A"),
              Text("B"),
              Text("C"),
            ],
          )
        ],
      ),
    );
  }
}

class _bottom extends StatelessWidget {
  const _bottom({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 2,
      child: Column(
        children: [
          TabBar(
            tabs: [
              Tab(icon: Icon(Icons.accessibility_new_outlined)),
              Tab(icon: Icon(Icons.account_circle_sharp)),
            ],
          ),
          Expanded(
            child: TabBarView(
              children: [
                GridView.builder(
                  gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                    crossAxisCount: 3,
                    crossAxisSpacing: 5,
                    mainAxisSpacing: 5,
                  ),
                  itemBuilder: (context, index) => Image.network(
                    "https://picsum.photos/id/${200 + index}/200/300",
                    fit: BoxFit.cover,
                  ),
                  itemCount: 30,
                ),
                Container(color: Colors.red),
              ],
            ),
          ),
        ],
      ),
    );
  }
}