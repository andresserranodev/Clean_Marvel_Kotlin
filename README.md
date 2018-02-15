# Clean Marvel Kotlin
Kata Kotlin 
Follow [Clean Arquitecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html/) and  MVP bases 

## Using :

[Retrofit](http://square.github.io/retrofit/)

[Gson converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson)

[RxJava](https://github.com/ReactiveX/RxJava)

[RxAndroid](https://github.com/ReactiveX/rxandroid)

[Picasso](https://github.com/square/picasso)

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
1. Add the GET /v1/public/characters/{characterId} and the functionality of getting a click on an card image. When the click does occur you should present a Fragment Dialog with a full screen image and all the information related to that image.
2. Improve the app adding a FloatingActionButton in order to refresh. This FloatingActionButton should call the service and store the data on a database using realm.
3. Add a Loader and a content provider in order to load the list from the database while the data is being persisted.
3. Add all the UNIT test for each presenter. Using mockito and robolectric


# Code Enhancements:

1. Add Dagger2
2. create a module for layer data and domain



## Sources

[Course Kotlin for android developers by  Antonio Leiva](https://academy.antonioleiva.com/courses/)

[Keddit — Part 6: API — Retrofit & Kotlin](https://android.jlelse.eu/keddit-part-6-api-retrofit-kotlin-d309074af0)

[Karumi/KataScreenshotKotlin](https://github.com/Karumi/KataScreenshotKotlin)

