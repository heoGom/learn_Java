import 'package:blog/core/utils.dart';
import 'package:blog/data/post_repository.dart';
import 'package:dio/dio.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

// 1. 창고 (ViewModel)
class PostDetailVM extends StateNotifier<PostDetailModel?> {
  PostDetailVM(super.state);

  Future<void> notifyInit(int id) async {
    // 1. 통신을 해서 응답 받기

    Map<String, dynamic> one = await PostRepository().findById(id);
    state = PostDetailModel.fromMap(one);

    // 2. 상태 갱신
  }
}

// 2. 창고 창고데이터 (State)
class PostDetailModel {
  int id;
  String title;
  String content;
  String createdAt;
  String updatedAt;

  PostDetailModel.fromMap(map) :
      this.id = map["id"],
      this.title = map["title"],
      this.content = map["content"],
      this.createdAt = formatDate(map["createdAt"]),
      this.updatedAt = map["updatedAt"];

}

// 3. 창고 관리자 (Provider)
final postDetailProvider =
    StateNotifierProvider.autoDispose.family<PostDetailVM, PostDetailModel?, int>((ref, id) {
      
  return PostDetailVM(null)..notifyInit(id);
});
