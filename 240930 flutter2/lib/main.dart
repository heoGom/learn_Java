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

// 하나의 화면
class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        actions: [
          Icon(Icons.search),
          const SizedBox(width: 16),
          Icon(CupertinoIcons.heart, color: Colors.redAccent),
          const SizedBox(width: 16),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16.0),
        child: ListView(
          children: [
            _title(),
            const SizedBox(height: 10),
            _menu(),
            const SizedBox(height: 10),
            RecipeItem("burger.jpeg", "burger"),
            RecipeItem("coffee.jpeg", "coffee"),
            RecipeItem("pizza.jpeg", "pizza"),
          ],
        ),
      ),
    );
  }

  Text _title() {
    return Text(
      "Recipes",
      style: GoogleFonts.patuaOne(
        textStyle: TextStyle(fontSize: 30),
      ),
    );
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
          Icon(
            mIcon,
            color: Colors.redAccent,
            size: 30,
          ),
          SizedBox(height: 5),
          Text(
            "$text",
            style: TextStyle(
              color: Colors.black87,
              fontWeight: FontWeight.bold,
            ),
          ),
        ],
      ),
    );
  }
}

class RecipeItem extends StatelessWidget {
  String imageName;
  String text;

  RecipeItem(this.imageName, this.text);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 20),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          AspectRatio(
            aspectRatio: 3 / 2,
            child: ClipRRect(
              borderRadius: BorderRadius.circular(20),
              child: Image.asset(
                "assets/${imageName}",
                fit: BoxFit.cover,
              ),
            ),
          ),
          SizedBox(height: 10),
          Text(
            "$text",
            style: TextStyle(fontSize: 20),
          ),
          Text(
            "Have you ever made your own $text? Once you've tried a homemade $text, you'll never go back.",
            style: TextStyle(color: Colors.grey, fontSize: 12),
          ),
        ],
      ),
    );
  }
}
