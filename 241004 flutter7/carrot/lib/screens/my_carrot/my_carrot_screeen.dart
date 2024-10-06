import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class MyCarrotScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Column(
        children: [
          mAppBar(),
          const Divider(color: Colors.grey),
          mCategoryBar(),
          const Divider(color: Colors.black12, height: 40, thickness: 16),
          mIconButtons(),
          Expanded(
            child: mRecommandStores(),
          ),
          SizedBox(
            height: 8,
          ),
        ],
      ),
    );
  }
}

class mRecommandStores extends StatelessWidget {
  const mRecommandStores({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.symmetric(horizontal: 16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            "이웃들의 추천 가게",
            style: TextStyle(
                color: Colors.black,
                fontSize: 16,
                fontWeight: FontWeight.bold),
          ),
          SizedBox(height: 15),
          Expanded(
            child: ListView(
              scrollDirection: Axis.horizontal,
              children: [
                mRecommandStore(),
                SizedBox(width: 15),
                mRecommandStore(),
                SizedBox(width: 15),
                mRecommandStore(),
                SizedBox(width: 15),
              ],
            ),
          ),
        ],
      ),
    );
  }
}

class mRecommandStore extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(20),
        border: Border.all(color: Colors.black12),
      ),
      width: 300,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          mImagesRow(),
          SizedBox(height: 15),
          mInfoStore(),
          SizedBox(height: 8),
          Padding(
            padding: EdgeInsets.symmetric(horizontal: 8),
            child: Column(
              children: [
                Divider(
                  color: Colors.black12,
                  thickness: 1,
                ),
                Container(
                  height: 60,
                  width: double.infinity,
                  decoration: BoxDecoration(
                    color: Colors.black12,
                    borderRadius: BorderRadius.circular(15),
                  ),
                  child: Padding(
                    padding: EdgeInsets.symmetric(horizontal: 10),
                    child: Center(
                        child: Text(
                      "이엘리아님, 너무편하게 시술해주셔서 잠들었었네요 직무에 짧은 눈썹이라 펌이",
                      style: TextStyle(color: Colors.black),
                    )),
                  ),
                ),
              ],
            ),
          ),
          SizedBox(height: 10),
        ],
      ),
    );
  }
}

class mInfoStore extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding:  EdgeInsets.symmetric(horizontal: 10),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            crossAxisAlignment: CrossAxisAlignment.end,
            children: [
              Text(
                "네일가게",
                style: TextStyle(color: Colors.black, fontSize: 20),
              ),
              SizedBox(width: 5),
              Text("좌동")
            ],
          ),
          SizedBox(height: 10),
          Text("꼼꼼한 시술로 유지력 높은 네일샵입니다."),
          SizedBox(height: 10),
          Row(
            children: [
              Text(
                "후기 1",
                style: TextStyle(color: Colors.blue),
              ),
              Text(" • "),
              Text(
                "관심 8",
                style: TextStyle(color: Colors.black),
              ),
            ],
          ),
        ],
      ),
    );
  }
}

class mImagesRow extends StatelessWidget {
  const mImagesRow({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Expanded(
          child: AspectRatio(
              aspectRatio: 3 / 2,
              child: ClipRRect(
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(20),
                ),
                child: Image.network("https://picsum.photos/id/100/200/200",
                    fit: BoxFit.cover),
              )),
        ),
        SizedBox(width: 3),
        Expanded(
          child: AspectRatio(
              aspectRatio: 3 / 2,
              child: ClipRRect(
                borderRadius: BorderRadius.only(
                  topRight: Radius.circular(20),
                ),
                child: Image.network("https://picsum.photos/id/100/200/200",
                    fit: BoxFit.cover),
              )),
        ),
      ],
    );
  }
}

class mIconButtons extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 230,
      child: GridView.count(
        crossAxisSpacing: 1,
        mainAxisSpacing: 1,
        crossAxisCount: 4,
        children: [
          mIconButton(Icons.person_outline, "구인구직"),
          mIconButton(CupertinoIcons.text_insert, "과외/클래스"),
          mIconButton(Icons.apple, "농수산물"),
          mIconButton(Icons.real_estate_agent_outlined, "부동산"),
          mIconButton(CupertinoIcons.car_detailed, "중고차"),
          mIconButton(Icons.festival, "전시/행사"),
        ],
      ),
    );
  }
}

class mIconButton extends StatelessWidget {
  IconData iconData;
  String name;

  mIconButton(this.iconData, this.name);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        children: [
          Icon(
            iconData,
            size: 40,
          ),
          SizedBox(height: 2),
          Text("$name"),
        ],
      ),
    );
  }
}

class mCategoryBar extends StatelessWidget {
  const mCategoryBar({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 16),
      child: Column(
        children: [
          Search(),
          SizedBox(height: 16),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              CategoryButton(categoryName: "인테리어"),
              CategoryButton(categoryName: "학원"),
              CategoryButton(categoryName: "이사"),
              CategoryButton(categoryName: "카페"),
              CategoryButton(categoryName: "용달"),
            ],
          ),
        ],
      ),
    );
  }
}

class mAppBar extends StatelessWidget {
  const mAppBar({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 16),
      child: Column(
        children: [
          AppBar(
            title: Text("내 근처", style: TextStyle(fontSize: 20)),
            actions: [
              Icon(CupertinoIcons.pen, size: 30),
              SizedBox(width: 16),
              Icon(CupertinoIcons.bell, size: 30)
            ],
          ),
        ],
      ),
    );
  }
}

class CategoryButton extends StatelessWidget {
  String categoryName;

  CategoryButton({required this.categoryName});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        border: Border.all(color: Colors.black26),
        borderRadius: BorderRadius.circular(17),
      ),
      height: 34,
      child: Container(
        child: Row(children: [
          SizedBox(width: 16),
          Text(
            "$categoryName",
            style: TextStyle(fontSize: 14, fontWeight: FontWeight.bold),
          ),
          SizedBox(width: 16),
        ]),
      ),
    );
  }
}

class Search extends StatelessWidget {
  const Search({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(10), color: Colors.black12),
      child: TextField(
        style: TextStyle(fontSize: 16),
        textAlignVertical: TextAlignVertical.center,
        decoration: InputDecoration(
          hintText: "좌동 주변 가게를 찾아보세요.",
          hintStyle: TextStyle(
            color: Colors.black26,
          ),
          border: InputBorder.none,
          prefixIcon: Icon(
            Icons.search,
            color: Colors.black26,
            size: 30,
          ),
        ),
      ),
    );
  }
}
