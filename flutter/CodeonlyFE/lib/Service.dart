import 'dart:convert';
import 'package:http/http.dart' as http;

class Service {
  final String baseUrl = "http://192.168.1.41:8060/api/v1/crud";

  Future<bool> saveUser(int crudId, String userName, int phoneNumber, int age, String address) async {
    try {
      var url = Uri.parse("$baseUrl/saveUpdate");
      var headers = {"Content-Type": "application/json"};
      var data = {
        'crudId': crudId,
        'userName': userName,
        'age': age,
        'phoneNumber': phoneNumber,
        'address': address,
      };
      var body = json.encode(data);

      var response = await http.put(url, headers: headers, body: body);

      if (response.statusCode == 200) {
        return true;
      } else {
        return false;
      }
    } catch (e) {
      return false;
    }
  }

  Future<bool> update(int crudId, String userName, int phoneNumber, int age, String address) async {
    try {
      var url = Uri.parse("$baseUrl/saveUpdate?crudId=$crudId");
      var headers = {"Content-Type": "application/json"};
      var data = {
        'crudId': crudId,
        'userName': userName,
        'age': age,
        'phoneNumber': phoneNumber,
        'address': address,
      };
      var body = json.encode(data);

      var response = await http.put(url, headers: headers, body: body);

      if (response.statusCode == 200) {
        return true;
      } else {
        return false;
      }
    } catch (e) {
      return false;
    }
  }

  Future<Map<String, dynamic>> fetchUserById(int crudId) async {
    try {
      var url = Uri.parse("$baseUrl/fetch?crudId=$crudId");
      var response = await http.get(url);

      if (response.statusCode == 200) {
        var userData = json.decode(response.body);
        return userData;
      } else {
        throw Exception('Failed to fetch user data');
      }
    } catch (e) {
      throw Exception('Failed to fetch user data');
    }
  }

  Future<void> delete(int crudId) async {
    try {
      var url = Uri.parse("$baseUrl/delete?crudId=$crudId");
      var response = await http.delete(url);

      if (response.statusCode == 200) {
        return;
      } else {
        throw Exception('Failed to delete user: ${response.statusCode}');
      }
    } catch (e) {
      throw Exception('Failed to delete user data: $e');
    }
  }
}
