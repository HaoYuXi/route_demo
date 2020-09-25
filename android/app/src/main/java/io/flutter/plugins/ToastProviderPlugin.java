package io.flutter.plugins;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.flutter.route_demo.BaseToast;

import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import static android.content.ContentValues.TAG;

public class ToastProviderPlugin implements MethodChannel.MethodCallHandler
{

    public static void registerWith(BinaryMessenger registrar)
    {
        final MethodChannel channel = new MethodChannel(registrar, "print");
        channel.setMethodCallHandler(new ToastProviderPlugin());
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result)
    {
        if (call.method.equals("printTitle")) {

//            if (call.hasArgument("msg") && !TextUtils.isEmpty(call.argument<Any>("msg").toString())) {
            if (call.hasArgument("msg") && !TextUtils.isEmpty(call.argument("msg").toString())) {

                Log.i(TAG, "onMethodCall: from Flutter " + call.argument("msg"));

            } else {
                Log.i(TAG, "onMethodCall: from Flutter 失败");

            }
        }
        if (call.method.equals("getPrintTitle")) {

            BaseToast baseToast = new BaseToast();

            result.success("Android" + Build.VERSION.RELEASE+"\n result = " +
                    baseToast.printTitle());

        } else {
            result.notImplemented();
        }

    }
}
