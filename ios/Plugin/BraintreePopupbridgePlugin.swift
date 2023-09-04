import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(BraintreePopupbridgePlugin)
public class BraintreePopupbridgePlugin: CAPPlugin {
    private let implementation = BraintreePopupbridge()
    
    override public func load() {
        self.implementation.enable(webView: self.webView!)
    }
    
    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }
}
