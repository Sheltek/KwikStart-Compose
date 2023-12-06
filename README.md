#LaunchPad Quick Start for Kotlin Multiplatform

LaunchPad is an open-source, free-to-use project designed to empower you to bring your Kotlin Multiplatform projects to market faster. It provides a collection of tools and utilities to streamline your development process and eliminate the need for reinventing the wheel.

## LaunchPad Compose
This library offers a comprehensive set of Compose widgets and utility functions to simplify your coding experience. It empowers you to:

-   Create beautiful and functional Compose UIs with ease.
-   Reduce boilerplate code and focus on your core logic.
-   Leverage pre-built components for common UI patterns.

## Contributing
We welcome contributions from all developers! If you're interested in getting involved, please refer to the  [`CONTRIBUTING.md`](./CONTRIBUTING.md) document for details.

## What's in this library
### Convenience Functions
* Theme Extensions: Make your Compose themes more readable and manageable with the convenient functions found in ThemeExtensions.kt. [`ThemeExtensions.kt`](https://github.com/BottleRocketStudios/Android-LaunchPad-Compose/blob/b1e309bc6cfff82c3f985d055567704772683e1e/launchpad-compose/src/main/java/com/bottlerocketstudios/launchpad/compose/ThemeExtensions.kt).

### Compose Widgets
* AnimatedListDetail: This ready-to-use widget creates a seamless ListDetail view for Android applications.

## Usage
To integrate LaunchPad into your project, add the following dependency with the latest version number:
```kotlin
    commonMain.dependencies {
        ...
        implementation("com.github.bottlerocketstudios:kmp-launchpad-compose:<version>")
    }
```