import Foundation

@objc public class Antifurto: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
