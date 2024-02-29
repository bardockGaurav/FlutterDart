import 'package:crud_app/Service.dart';
import 'package:flutter/material.dart';
import 'Update.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'User Data save',
      theme: ThemeData(
        primarySwatch: Colors.amber,
      ),
      home: const Save(),
      debugShowCheckedModeBanner: false,
    );
  }
}

class Save extends StatefulWidget {
  const Save({Key? key}) : super(key: key);

  @override
  SaveState createState() => SaveState();
}

class SaveState extends State<Save> {
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
        title: const Text('Save User'),
      ),
      body: Container(
        padding: const EdgeInsets.all(20),
        child: ListView(
          children: [
              TextFormField(
                controller: crudIdController,
                decoration: const InputDecoration(labelText: 'User Id'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter a user Id';
                  }
                  return null;
                },
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
              onPressed: _saveUser,
              child: const Text('Save User'),
            ),
            const SizedBox(height: 10),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const Update()),
                );
              },
              child: const Text(
                'Update',
                style: TextStyle(
                  fontSize: 25,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Future<void> _saveUser() async {
    try {
      if (_validateFields()) {
        showDialog(
          context: context,
          builder: (BuildContext context) {
            return Center(child: CircularProgressIndicator());
          },
        );

        bool success = await service.saveUser(
          int.parse(crudIdController.text),
          userNameController.text,
          int.parse(ageController.text),
          int.parse(phoneNumberController.text),
          addressController.text,
        );

        Navigator.of(context).pop(); // Close loading indicator
        if (success) {
          _showSnackBar('User saved successfully', backgroundColor: Colors.green);
        } else {
          _showSnackBar('Failed to save user', backgroundColor: Colors.red);
        }
      }
    } catch (e) {
      Navigator.of(context).pop(); // Close loading indicator
      _showSnackBar('Failed to save user: $e', backgroundColor: Colors.red);
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