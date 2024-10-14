import 'package:blog/core/utils.dart';

class PostRepository {
  PostRepository();

  Future<List<dynamic>> findAll() async {
    // 1. 통신 -> respons [header, body]
    var response = await dio.get("/api/post");

    // 2. body 부분
    // body 부분이 json array(List) 면 List<dynamic> 으로 받기
    // body 부분이 json(object) 면 Map<String, dynamic> 으로 받기
    List<dynamic> body = response.data["body"];

    return body;
  }

  Future<Map<String, dynamic>> findById(int id) async {
    // 1. 통신 -> response [header, body]
    var response = await dio.get("/api/post/$id");

    // 2. body 부분
    // body 부분이 json array(List) 면 List<dynamic> 으로 받기
    // body 부분이 json(object) 면 Map<String, dynamic> 으로 받기
    Map<String, dynamic> body = response.data["body"];

    return body;
  }

  Future<Map<String, dynamic>> save(String title, String content) async {
    // 1. 통신 -> response [header, body]
    var response =
        await dio.post("/api/post", data: {"title": title, "content": content});

    // 2. body 부분
    // body 부분이 json array(List) 면 List<dynamic> 으로 받기
    // body 부분이 json(object) 면 Map<String, dynamic> 으로 받기
    Map<String, dynamic> body = response.data["body"];

    return body;
  }
}
