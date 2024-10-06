import 'package:flutter/material.dart';
import 'package:mycarrot/screens/main_screens.dart';
import 'package:mycarrot/theme.dart';
void main() {
  // ❶
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // ❷
    return MaterialApp(
      title: 'carrot_market_ui',
      debugShowCheckedModeBanner: false,
      // ❸
      home: MainScreens(),
      // ❹
      theme: theme(),
    );
  }
}