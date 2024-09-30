import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

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

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        actions: [
          Icon(Icons.search),
          SizedBox(width: 16),
          Icon(CupertinoIcons.heart, color: Colors.redAccent),
          SizedBox(width: 16),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16.0),
        child: ListView(
          children: [
            _title(),
            SizedBox(height: 10),
            _menu(),
            SizedBox(height: 10),
            Container(
              height: 300,
              color: Colors.red,
            ),
            Placeholder(),
            Container(
              height: 300,
              color: Colors.red,
            ),
          ],
        ),
      ),
    );
  }

  Text _title() {
    return Text("Recipes",
        style: GoogleFonts.patuaOne(
          textStyle: TextStyle(fontSize: 30),
        ));
  }

  Row _menu() {
    return Row(
      children: [
        _mIcon(Icons.food_bank, "ALL"),
        SizedBox(width: 25),
        _mIcon(Icons.emoji_food_beverage, "Coffee"),
        SizedBox(width: 25),
        _mIcon(Icons.fastfood, "Burger"),
        SizedBox(width: 25),
        _mIcon(Icons.local_pizza, "Pizza"),
      ],
    );
  }

  Container _mIcon(IconData mIcon, String text) {
    return Container(
      width: 60,
      height: 80,
      decoration: BoxDecoration(
          border: Border.all(color: Colors.black12),
          borderRadius: BorderRadius.circular(30)),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(mIcon, color: Colors.redAccent, size: 30),
          SizedBox(height: 5),
          Text("$text",
              style: TextStyle(
                  color: Colors.black87, fontWeight: FontWeight.bold)),
        ],
      ),
    );
  }
}
