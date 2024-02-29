import 'package:flutter/material.dart';
import 'Service.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Update User Data',
      theme: ThemeData(
        primarySwatch: Colors.amber,
      ),
      home: const Update(),
      debugShowCheckedModeBanner: false,
    );
  }
}

class Update extends StatefulWidget {
  const Update({Key? key}) : super(key: key);

  @override
  UpdateState createState() => UpdateState();
}

class UpdateState extends State<Update> {
  final TextEditingController crudIdController = TextEditingController();
  final TextEditingController userNameController = TextEditingController();
  final TextEditingController ageController = TextEditingController();
  final TextEditingController addressController = TextEditingController();
  final TextEditingController phoneNumberController = TextEditingController();

  final Service service = Service();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Update User Data'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              TextFormField(
                controller: crudIdController,
                decoration: const InputDecoration(labelText: 'UserId'),
              ),
              const SizedBox(height: 5),
              ElevatedButton(
                onPressed: () async {
                  try {
                    var userData = await service.fetchUserById(
                      int.parse(crudIdController.text),
                    );

                    userNameController.text = userData['userName'].toString();
                    ageController.text = userData['age'].toString();
                    phoneNumberController.text = userData['phoneNumber'].toString();
                    addressController.text = userData['address'].toString();
                  } catch (e) {
                    _showSnackBar("Error: $e", backgroundColor: Colors.red);
                  }
                },
                child: const Text('Search User'),
              ),

              TextFormField(
                controller: userNameController,
                decoration: const InputDecoration(labelText: 'User Name'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter a user name';
                  }
                  return null;
                },
              ),
              TextFormField(
                controller: ageController,
                decoration: const InputDecoration(labelText: 'Age'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter an age';
                  }
                  return null;
                },
              ),
              TextFormField(
                controller: phoneNumberController,
                decoration: const InputDecoration(labelText: 'Phone Number'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter a phone number';
                  }
                  return null;
                },
              ),
              TextFormField(
                controller: addressController,
                decoration: const InputDecoration(labelText: 'Address'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter an address';
                  }
                  return null;
                },
              ),
              const SizedBox(height: 10),
              ElevatedButton(
                onPressed: _updateUser,
                child: const Text('Update User'),
              ),
              ElevatedButton(
                onPressed: _deleteUser,
                child: const Text('Delete User'),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Future<void> _updateUser() async {
    try {
      if (_validateFields()) {
        showDialog(
          context: context,
          builder: (BuildContext context) {
            return Center(child: CircularProgressIndicator());
          },
        );

        bool success = await service.update(
          int.parse(crudIdController.text),
          userNameController.text,
          int.parse(ageController.text),
          int.parse(phoneNumberController.text),
          addressController.text,
        );

        Navigator.of(context).pop(); // Close loading indicator
        if (success) {
          _showSnackBar('User data updated successfully', backgroundColor: Colors.green);
        } else {
          _showSnackBar('Failed to update user data', backgroundColor: Colors.red);
        }
      }
    } catch (e) {
      Navigator.of(context).pop(); // Close loading indicator
      _showSnackBar('Failed to update user data: $e', backgroundColor: Colors.red);
    }
  }

  Future<void> _deleteUser() async {
    try {
      if (crudIdController.text.isEmpty) {
        _showSnackBar('Please enter a User ID', backgroundColor: Colors.red);
        return;
      }
      showDialog(
        context: context,
        builder: (BuildContext context) {
          return Center(child: CircularProgressIndicator());
        },
      );
      await service.delete(int.parse(crudIdController.text));
      Navigator.of(context).pop(); // Close loading indicator
      _showSnackBar('User deleted successfully', backgroundColor: Colors.green);
    } catch (e) {
      Navigator.of(context).pop(); // Close loading indicator
      _showSnackBar('Error deleting user: $e', backgroundColor: Colors.red);
    }
  }

  bool _validateFields() {
    if (crudIdController.text.isEmpty ||
        userNameController.text.isEmpty ||
        ageController.text.isEmpty ||
        phoneNumberController.text.isEmpty ||
        addressController.text.isEmpty) {
      _showSnackBar('Please fill in all fields', backgroundColor: Colors.red);
      return false;
    }
    return true;
  }

  void _showSnackBar(String message, {Color backgroundColor = Colors.red}) {
    final snackBar = SnackBar(content: Text(message), backgroundColor: backgroundColor);
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }
}