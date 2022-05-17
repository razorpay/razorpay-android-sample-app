![Banner](https://rzp-mobile.s3.amazonaws.com/images/android-readme.png)

# Razorpay's Sample Android App

This repository demonstrates how to integrate Razorpay's Android SDK.    
The apk built with code from this repository is published [here](https://rzp-mobile.s3.amazonaws.com/checkout-sample/app-release-with-1.6.7.apk)

The documentation to our Android SDK is available [here](https://razorpay.com/docs/payment-gateway/android-integration/standard/)

## Features

[razorpay.com/mobile](https://razorpay.com/mobile)

## Releases | Integration
Releases are available at [https://mvnrepository.com/artifact/com.razorpay/checkout](https://mvnrepository.com/artifact/com.razorpay/checkout).

### tl;dr

- Add this line to your app's `build.gradle` inside the `dependencies` section:

  ```
  implementation('com.razorpay:checkout:1.6.20')
  ```
- To hand over control to Razorpay's SDK for collecting payment, refer to [PaymentActivity.java](https://github.com/razorpay/razorpay-android-sample-app/blob/master/app/src/main/java/com/razorpay/sampleapp/PaymentActivity.java)
- For the permissions required, refer [AndroidManifest.xml](https://github.com/razorpay/razorpay-android-sample-app/blob/master/app/src/main/AndroidManifest.xml)
- For proguard rules when you are releasing the app, refer [proguard-project.txt](https://github.com/razorpay/razorpay-android-sample-app/blob/master/proguard-project.txt)

## Kotlin Support
Razorpay's SDKs are now compatible with Kotlin support as well. 
Find the code for this at [https://github.com/razorpay/razorpay-android-sample-app/app/src/main/java/kotlin/PaymentActivity.kt](https://github.com/razorpay/razorpay-android-sample-app/app/src/main/java/kotlin/PaymentActivity.kt)

## Support

Razorpay is a tech company. All our engineers handle support too. You can write to us at razorpay.com/support and expect a response from the devs responsible for the Android SDK.

## License

MIT Licensed. LICENSE file added to repo.
