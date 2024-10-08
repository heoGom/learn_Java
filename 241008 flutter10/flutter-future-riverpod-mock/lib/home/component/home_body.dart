import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:homeapp/home/home_page_vm.dart';

class HomeBody extends ConsumerWidget {

  @override
  Widget build(BuildContext context, ref) {
    int? num = ref.watch(homeProvider);

    if(num == null){
      return Center(child: CircularProgressIndicator());
    }else{
      return Center(
        child: Text("숫자 : $num"),
      );
    }


  }
}
