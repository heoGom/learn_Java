import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:riverapp/num_notify_provider.dart';
import 'package:riverapp/num_provider.dart';

void main() {
  runApp(ProviderScope(child: MyApp()));
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
      body: Column(
        children: [
          Expanded(child: Top()),
          Expanded(child: Bottom()),
        ],
      ),
    );
  }
}

class Bottom extends ConsumerWidget {

  @override
  Widget build(context, ref) {
    print("바텀");
    // NumStore store = ref.read(numProvider);
    BunStore store = ref.read(BunProvider.notifier);
    return Center(
      child: Container(
        child: InkWell(
            onTap: () {
              print("증가 클릭됨");
              store.increase();
            },
            child: Text("증가", style: TextStyle(fontSize: 100))),
      ),
    );
  }
}

class Top extends ConsumerWidget {

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    print("탑");
    // var store = ref.read(numProvider); //프로바이더의 익명함수가 실행됨
    BunModel model = ref.watch(BunProvider);
    return Center(
        child: Container(child: Text("${model.bun}", style: TextStyle(fontSize: 100))));
  }
}
