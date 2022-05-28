# OpenWeatherApp
OpenWeatherApp is an android app that lets you check the current weather for selected cities around the world using [Open Weather Map API](http://openweathermap.org/api).

## Architecture
The app uses `MVVM(Model View View Model)`+ clean architecture design pattern. 
This provides better separation of concern, easier testing, lifecycle awareness, etc.

## Functionality
The app's functionality includes:
1. Home Screen: 
   Shows a list of locations that the user has bookmarked previously.
   Shows a way to add location to the list of locations
   Shows a way to remove location from the lists of locations
2. Detail Screen
   Displays bookmarked city weather information which includes temprature, humidity, visibility, high and low temprature, real feel temprature, wind, pressure and sunrise and sunset time

## Technologies Used
1.  [Android appcompat](https://developer.android.com/jetpack/androidx/releases/appcompat), [KTX](https://developer.android.com/kotlin/ktx), [Constraint layout](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout), [Material Support](https://material.io/develop/android/docs/getting-started).
2.  [Android View Binding](https://developer.android.com/topic/libraries/view-binding)
3. [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection.
4. [Retrofit](https://square.github.io/retrofit/) for REST API communication
5. [Coroutine](https://developer.android.com/kotlin/coroutines) for Network call
6. [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle), [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
7. [Room](https://developer.android.com/jetpack/androidx/releases/room) for local database.
8. [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started) for supporting navigation through the app.
9. [Glide](https://github.com/bumptech/glide) for image loading.
