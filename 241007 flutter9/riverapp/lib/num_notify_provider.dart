import 'package:flutter_riverpod/flutter_riverpod.dart';

//창고데이터(데이터)
class BunModel {
  int bun;
  BunModel(this.bun);
}

//창고(비지니스 로직관리)
class BunStore extends StateNotifier<BunModel> {
  BunStore(super.state);

  void increase(){
    BunModel model = super.state;
    super.state = BunModel(model.bun+1);

  }
  void decrease(){
    BunModel model = super.state;
    super.state = BunModel(model.bun-1);
  }
}

//창고관리자(창고 관리)
final BunProvider = StateNotifierProvider<BunStore, BunModel>((ref) {
  BunModel model = BunModel(1);
  return BunStore(model);
});
