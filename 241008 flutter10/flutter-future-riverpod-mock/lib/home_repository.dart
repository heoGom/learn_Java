// 통신 담당
class HomeRepository {
  Future<int> fetchNumber() {
    return Future.delayed(Duration(seconds: 3), () => 3);
  }

  int fetchNumberV2() {
    return 5;
  }
}
