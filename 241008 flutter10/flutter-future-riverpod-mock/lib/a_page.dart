import 'package:flutter/material.dart';
import 'package:homeapp/home_repository.dart';

class APage extends StatelessWidget {
  const APage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(body: Text("넘버 : ${HomeRepository().fetchNumber()}"));
  }
}
