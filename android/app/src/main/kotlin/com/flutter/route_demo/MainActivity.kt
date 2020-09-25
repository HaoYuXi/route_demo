package com.flutter.route_demo

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import io.flutter.plugins.ToastProviderPlugin


class MainActivity: FlutterActivity() {
    private val CHANNEL = "print"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ToastProviderPlugin.registerWith(this@MainActivity.flutterEngine!!.dartExecutor.binaryMessenger);

//        MethodChannel(flutterEngine!!.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call: MethodCall, result: MethodChannel.Result? ->
////            println(call.method)
//            if (call.method == "printTitle") {
//                if (call.hasArgument("msg") && !TextUtils.isEmpty(call.argument<Any>("msg").toString())) {
//                    Toast.makeText(this@MainActivity, call.argument<Any>("msg").toString(), Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this@MainActivity, "toast text must not null", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        GeneratedPluginRegistrant.registerWith(flutterEngine);
    }

}
