import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:homeapp/home/home_page_vm.dart';

import 'component/home_body.dart';


class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: HomeBody(),
    );
  }
}

// class HomeBody extends ConsumerWidget {
//   @override
//   Widget build(BuildContext context, WidgetRef ref) {
//     int? num = ref.watch(homeProvider);
//     if (num == null) {
//       return Center(
//         child: CircularProgressIndicator(),
//       );
//     } else {
//       return Center(
//         child: Text("숫자 : $num"),
//       );
//     }
//   }
// }
