package com.getcapacitor.plugin.braintree.popupbridge;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "BraintreePopupbridge")
public class BraintreePopupbridgePlugin extends Plugin {

    private BraintreePopupbridge implementation = new BraintreePopupbridge();

    public void load() {
        this.implementation.enable(
            this.getActivity(),
            this.bridge.getWebView(),
            getContext().getPackageName()
        );
    }

    @Override
    protected void handleOnResume() {
        this.implementation.handleOnResume(this.getActivity());
    }

    @Override
    protected void handleOnNewIntent(Intent intent) {
        this.implementation.handleOnNewIntent(this.getActivity(), intent);
    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }
}
