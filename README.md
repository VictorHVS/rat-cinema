# rat-cinema 🐀-📽️
An mobile application that consumes themoviedb api for study purposes.

## TODOS ✅
- [x] buildSrc
- [x] Room Setup
- [x] Hilt Setup
- [x] Retrofit Setup
- [x] Home Screen with Movie List
- [ ] Movie Detail Screen
- [ ] Movie Search Screen
- [ ] Testing
- [ ] Github Actions for CI/CD
- [ ] Theming  
- [ ] Modularization

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s modern toolkit for building native UI.
- [Jetpack Accompanist](https://google.github.io/accompanist/) - Accompanist is a group of libraries that aim to supplement Jetpack Compose with features that are commonly required by developers but not yet available.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
- [Jetpack Compose Navigation](https://developer.android.com/jetpack/compose/navigation) - Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) - The Paging library helps you load and display pages of data from a larger dataset from local storage or over network.

## API 🖥️
Free and robust API: https://developers.themoviedb.org/3

### API Key 🔑
You must provide a developer key to fetch the data from TMDB API.
* Generate a new key (v3 auth) from [here](https://www.themoviedb.org/settings/api).
* Create a new kotlin file `ApiKey.kt` in path `./buildSrc/src/main/java/`.
* Define a constant `TMDB_API_KEY` with the double quotes, it looks like

```kotlin
object ApiKey {
    const val TMDB_API_KEY = "\"5f422***********************8db5\""
}
```

> **NOTE**: If you're missing the double quotes, it will build fail.

## Design 🎨
- Inspiration from: https://www.behance.net/gallery/124917609/NETFLIX-UXUI-Redesign/modules/709576847
- Material Theme Builder: https://material-foundation.github.io/material-theme-builder/#/custom


## License 👮‍♂️
```
Copyright 2022 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
