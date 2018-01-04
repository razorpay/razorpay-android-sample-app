![Banner](https://rzp-mobile.s3.amazonaws.com/images/android-readme.png)

# Razorpay's Sample Android App

This repository demonstrates how to integrate Razorpay's Android SDK.    
The apk built with code from this repository is published on the [Play Store](https://play.google.com/store/apps/details?id=com.razorpay.sampleapp).

## Features

[razorpay.com/mobile](https://razorpay.com/mobile)

## Releases | Integration
Releases are available at [https://github.com/razorpay/razorpay-android-sample-app/releases](https://github.com/razorpay/razorpay-android-sample-app/releases).

### tl;dr

- Add this line to your app's `build.gradle` inside the `dependencies` section:

  ```
  compile('com.razorpay:checkout:1.4.5')
  ```
- To hand over control to Razorpay's SDK for collecting payment, refer to [PaymentActivity.java](https://github.com/razorpay/razorpay-android-sample-app/blob/master/app/src/main/java/com/razorpay/sampleapp/PaymentActivity.java)
- For the permissions required, refer [AndroidManifest.xml](https://github.com/razorpay/razorpay-android-sample-app/blob/master/app/src/main/AndroidManifest.xml)
- For proguard rules when you are releasing the app, refer [proguard-project.txt](https://github.com/razorpay/razorpay-android-sample-app/blob/master/proguard-project.txt)

## Support

Razorpay is a tech company. All our engineers handle support too. You can drop us an email on support@razorpay.com and expect a response from the devs responsible for the Android SDK.

## License

MIT Licensed. LICENSE file added to repo.
