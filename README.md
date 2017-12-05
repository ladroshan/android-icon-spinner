# Android Icon Spinner

> An Android Spinner Adapter that supports a Icon with changeable background color, a title and a subtitle.

[![](https://jitpack.io/v/liefery/android-icon-spinner.svg)](https://jitpack.io/#liefery/android-icon-spinner)

![Sample app screenshot](https://liefery.github.io/android-icon-spinner/screenshot.png)

## Installation

### sbt

```scala
resolvers += "jitpack" at "https://jitpack.io"

libraryDependencies += "com.github.liefery" % "android-icon-spinner" % "1.0.1"
```

### Gradle

```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}

dependencies {
    compile 'com.github.liefery:android-icon-spinner:1.0.1'
}
```

## Usage
Simple to integrate with any data model
```java
public class MyModel implements IconSpinnable {
    ...
}
```


```java
Spinner spinner = findViewById( R.id.spinner );
spinner.setAdapter( new IconSpinnerAdapter( this, new MyModel[] { ... } ) );
```

Please have a look at the sample application for more details.