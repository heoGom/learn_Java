import 'package:blog/core/utils.dart';
import 'package:blog/data/post_repository.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

// 1. 창고 (ViewModel)
class PostListVM extends StateNotifier<PostListModel?> {

  final mContext = navigatorKey.currentState!.context;

  PostListVM(super.state);

  Future<void> notifyWrite(String title,String content) async {
    Map<String, dynamic> one = await PostRepository().save(title,content);
    _Post newPost = _Post.fromMap(one);

    PostListModel model = state!;
    List<_Post> newPosts = [newPost, ...model.posts];
    //상태는 새로운 객체를 만들어서 줘야한다.
    state = PostListModel(newPosts);
    Navigator.pop(mContext);


  }


  Future<void> notifyInit() async {
    // 1. 통신을 해서 응답 받기
    List<dynamic> list = await PostRepository().findAll();
    List<_Post> posts = list.map((e) => _Post.fromMap(e)).toList();

    // 2. 상태 갱신
    state = PostListModel(posts);
  }
}

// 2. 창고 창고데이터 (State)
class PostListModel {
  List<_Post> posts;

  PostListModel(this.posts);
}

class _Post {
  int id;
  String title;

  _Post.fromMap(map)
      : this.id = map["id"],
        this.title = map["title"];
}

// 3. 창고 관리자 (Provider)

final postListProvider = StateNotifierProvider<PostListVM, PostListModel?>((ref) {
  return PostListVM(null)..notifyInit();
});
