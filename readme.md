![Banner](https://rzp-mobile.s3.amazonaws.com/images/android-readme.png)

# Razorpay's Sample Android App

This repository demonstrates how to integrate Razorpay's Android SDK.    
The apk built with code from this repository is published on the [Play Store](https://play.google.com/store/apps/details?id=com.razorpay.sampleapp).

## Features

[razorpay.com/mobile](https://razorpay.com/mobile)

## Integration

Latest Version: v0.9.0    
Documentation: [https://docs.razorpay.com/v1/page/android-sdk-v090](https://docs.razorpay.com/v1/page/android-sdk-v090)

### tl;dr

- Include `razorpay-android.jar` ([download](http://downloads.razorpay.com/0.9.0/razorpay-android.jar)) in your `libs` folder.
- To hand over control to Razorpay's SDK for collecting payment, refer to [PaymentActivity.java](https://github.com/razorpay/razorpay-android-sample-app/blob/master/src/main/java/com/razorpay/sampleapp/PaymentActivity.java)
- To get back control from Razorpay once payment has succeeded or failed, refer to [CheckoutFragment.java](https://github.com/razorpay/razorpay-android-sample-app/blob/master/src/main/java/com/razorpay/sampleapp/CheckoutFragment.java)
- For the permissions required, refer [AndroidManifest.xml](https://github.com/razorpay/razorpay-android-sample-app/blob/master/src/main/AndroidManifest.xml)
- For proguard rules when you are releasing the app, refer [proguard-project.txt](https://github.com/razorpay/razorpay-android-sample-app/blob/master/proguard-project.txt)

## Support

Razorpay is a tech company. All our engineers handle support too. So can drop us an email on support@razorpay.com and expect a response from the dev responsible for the android SDK.

## License

MIT Licensed. LICENSE file added to repo.
