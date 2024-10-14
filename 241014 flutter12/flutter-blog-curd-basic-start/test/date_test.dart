import 'package:intl/intl.dart';

void main() {
  String createdAt = "2024-10-11 09:17:31";
  DateTime dateTime = DateTime.parse(createdAt.replaceFirst(' ', 'T'));
  DateTime newDateTime = DateTime(
    dateTime.year,
    dateTime.month + 1,
    dateTime.day,
    dateTime.hour,
    dateTime.minute,
    dateTime.second,
  );
  print(newDateTime);
  String formattedDate = DateFormat('yyyy-MM-dd HH:mm:ss').format(newDateTime);
  print(formattedDate);
}
