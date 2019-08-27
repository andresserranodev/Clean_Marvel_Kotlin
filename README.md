
[![Build Status](https://travis-ci.org/adsf117/Clean_Marvel_Kotlin.svg?branch=master)](https://travis-ci.org/adsf117/Clean_Marvel_Kotlin)
[![codecov.io](https://codecov.io/gh/adsf117/Clean_Marvel_Kotlin/branch/master/graph/badge.svg)](https://codecov.io/gh/adsf117/Clean_Marvel_Kotlin/)
[![CodeFactor](https://www.codefactor.io/repository/github/adsf117/clean_marvel_kotlin/badge)](https://www.codefactor.io/repository/github/adsf117/clean_marvel_kotlin)

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

[Dagger 2](https://dagger.dev/)


##  What can i do?

main objective with this repository  is give the ability to change the details easily for example
1. use Room instead Realm
2. use Fast-Android-Networking  instead Retrofit
3. use MVVM or MVI instead MVP

"All software systems can be decomposed into two major elements: policy and details.
 The policy element embodies all the business rules and procedures.
 The policy is where the true value of the system lives.
 The details are those things that are necessary to enable humans, other systems, and programmers to communicate with the policy,
 but that do not impact the behavior of the policy at all.
 They include IO devices, databases, web systems, servers, frameworks, communication protocols, and so forth."

Martin, Robert C.. Clean Architecture: A Craftsman's Guide to Software Structure and Design (Robert C. Martin Series) (p. 140). Pearson Education. Kindle Edition.


## How it looks
![alt text](https://github.com/adsf117/Clean_Marvel_Kotlin/blob/master/how_it_looks.gif)


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

# Enhancements:

1. migrate to kotlin DSL


## Sources

[Course Kotlin for android developers by  Antonio Leiva](https://academy.antonioleiva.com/courses/)

[Keddit — Part 6: API — Retrofit & Kotlin](https://android.jlelse.eu/keddit-part-6-api-retrofit-kotlin-d309074af0)

[Karumi/KataScreenshotKotlin](https://github.com/Karumi/KataScreenshotKotlin)

[Android Clean Architecture ](https://caster.io/courses/android-clean-architecture)

[Clean Architecture: A Craftsman's Guide to Software Structure and Design (Robert C. Martin Series) 1st Edition](https://www.amazon.com/Clean-Architecture-Craftsmans-Software-Structure/dp/0134494164)


