import 'package:flutter/material.dart';
import 'package:route_demo/SecondScreen.dart';

class FirstScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('First Screen'),
      ),
      body: new Center(
        child: new RaisedButton(
          child: new Text('Launch second screen'),
          onPressed: () {
            Navigator.push(
              context,
              new MaterialPageRoute(builder: (context) => new SecondScreen()),
            );
            // Navigator.push(context, new MaterialPageRoute(builder: (context) => new SecondScreen()),);
          },
        ),
      ),
    );
  }
}
