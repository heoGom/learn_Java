import 'package:flutter/material.dart';
import 'package:homeapp/home_repository.dart';

class FPage extends StatelessWidget {
  const FPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("FPage")),
      body: Column(
        children: [
          Container(
            color: Colors.yellow,
            height: 300,
          ),
          FutureBuilder(
            future: HomeRepository().fetchNumber(),
            builder: (context, snapshot) {
              if (snapshot.hasData) {
                return Center(
                  child: Text(
                    "${snapshot.data}",
                    style: TextStyle(fontSize: 30),
                  ),
                );
              } else {
                return CircularProgressIndicator();
              }
            },
          ),
        ],
      ),
    );
  }
}