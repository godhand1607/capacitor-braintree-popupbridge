import Foundation
import WebKit
import PopupBridge

@objc public class BraintreePopupbridge: NSObject {
    private var popupBridge: POPPopupBridge?
    
    @objc public func enable(webView: WKWebView) {
        self.popupBridge = POPPopupBridge(webView: webView)
    }
    
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
