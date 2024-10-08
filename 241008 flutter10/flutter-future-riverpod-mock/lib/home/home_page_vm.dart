import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:homeapp/home_repository.dart';


// 뷰 모델 (창고)
class HomeVM extends StateNotifier<int?> {
  HomeVM(super.state);

  Future<void> notifyInit() async {
    int num = await HomeRepository().fetchNumber(); // 3초
    state = num;
  }
}


// 뷰 모델 관리하는 관리자 (창고 관리자)
// watch하거나, read할때 실행됨 (View에서 실행시킴)
final homeProvider = StateNotifierProvider<HomeVM, int?>((ref) {
  HomeVM vm = HomeVM(null);
  vm.notifyInit();
  return vm;
});
