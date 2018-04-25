
[![Build Status](https://travis-ci.org/adsf117/Clean_Marvel_Kotlin.svg?branch=master)](https://travis-ci.org/adsf117/Clean_Marvel_Kotlin)

# Clean Marvel Kotlin
Kata Kotlin 
Follow :

[Clean Arquitecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html/)

[MVP](https://antonioleiva.com/mvp-android/) 

[Continuous Integration](https://www.martinfowler.com/articles/continuousIntegration.html) [Using Tavis](https://travis-ci.org/)

# Pending
[Continuous Delivery](https://martinfowler.com/bliki/ContinuousDelivery.html)


## Using :

[Retrofit](http://square.github.io/retrofit/)

[Gson converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson)

[RxJava](https://github.com/ReactiveX/RxJava)

[RxAndroid](https://github.com/ReactiveX/rxandroid)

[Picasso](https://github.com/square/picasso)

[Realm](https://realm.io/docs/java/latest)


## How it looks
![alt text](https://github.com/adsf117/MVP_MARVEL_RX/blob/master/demo_small.gif)


## How to use this project

You can use Android Studio or Intellij to work with this repository.

First thing you will need to compile this project is to get an [API Key and hash from Marvel](https://marvel.com/signin?referer=https%3A%2F%2Fdeveloper.marvel.com%2Faccount)

```Clean_Marvel_Kotlin/app/build.gradle
  buildConfigField "String", "PRIVATE_API_KEY_VALUE", '"your-private-apikey"'
  buildConfigField "String", "PUBLIC_API_KEY_VALUE", '"your-public-apikey"'
```

The `Kotlin` plugin for Android Studio is also required.

# TODO:
1. add detail screen
2. add commics taps 
3. add pager scroll

# Code Enhancements:

1. Add Dagger2


## Sources

[Course Kotlin for android developers by  Antonio Leiva](https://academy.antonioleiva.com/courses/)

[Keddit — Part 6: API — Retrofit & Kotlin](https://android.jlelse.eu/keddit-part-6-api-retrofit-kotlin-d309074af0)

[Karumi/KataScreenshotKotlin](https://github.com/Karumi/KataScreenshotKotlin)

