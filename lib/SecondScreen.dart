import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class SecondScreen extends StatelessWidget {
  static const platform = const MethodChannel("print");

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('Second Screen'),
      ),
      body: new Center(
        child: new RaisedButton(
          child: new Text('Go back!'),
          onPressed: () {
            // Navigator.pop(context);
            // _printTitle();
            // _printTitle();
            _printToast(context);
          },
        ),
      ),
    );
  }

  void _printTitle() async {
    try {
      await platform.invokeMethod("printTitle", {"msg": "123123123"});
    } on PlatformException catch (e) {
      print(e.toString() + "------------");
    }
  }

  void _printToast(BuildContext context) async {
    try {
      var title = await platform.invokeMethod("getPrintTitle");
      // Scaffold.of(context).showSnackBar(new SnackBar(content: Text(title!=null?title:"获取失败")));
      print(title!=null?title:"获取失败");
    } on PlatformException catch (e) {
      print(e.toString() + "------------");
    }
  }
}
