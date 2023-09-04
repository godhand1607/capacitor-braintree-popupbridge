package com.getcapacitor.plugin.braintree.popupbridge;

import android.content.Intent;
import android.util.Log;
import android.webkit.WebView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import com.braintreepayments.api.PopupBridgeClient;

public class BraintreePopupbridge {
    private PopupBridgeClient popupBridgeClient;

    public void enable(FragmentActivity activity, WebView webView, String packageName) {

        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.P) {
            String returnUrlScheme = packageName + ".popupbridge";

            this.popupBridgeClient = new PopupBridgeClient(activity, webView, returnUrlScheme);

            // register error listener
            this.popupBridgeClient.setErrorListener(error -> showDialog(activity, error.getMessage()));
        }
    }

    public void handleOnResume(FragmentActivity activity) {
        if (this.popupBridgeClient != null) {
            this.popupBridgeClient.deliverPopupBridgeResult(activity);
        }
    }

    public void handleOnNewIntent(FragmentActivity activity, Intent intent) {
        activity.setIntent(intent);
    }

    public void showDialog(FragmentActivity activity, String message) {
        new AlertDialog.Builder(activity)
            .setMessage(message)
            .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.dismiss())
            .show();
    }

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
