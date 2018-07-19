<p align="center">
  <image width="50%" height="50%";" src="https://github.com/mayuroks/minibar/blob/master/images/Minibar%20Banner_padding.png"></image>
</p>

## Background  🤔 ![Release](https://jitpack.io/v/mayuroks/minibar.svg) 🤔
Minibar is "minimal bar" android library that is built to quickly show in-app user messages. These messages could be alert, notification or just plain info. By default, Android offers Notifications which can be used for the same purpose. But notifications don't give the "in-app" user experience. Minibar messages are shown and dismissed within the app's layout.

I strongly feel that, the best way to display a message to user, is to display it at the top of the screen. Android doesn't provide anything that can achieve this. Android provides Snackbar, which by default, shows messages at the bottom. I have found that, messages shown at bottom are hard to read, distracting and annoying 😤.

This was the main motivation, to make a library that can show easy-to-read in-app messages to user. Needless to say that, if you come across bugs, have feature requests or suggestions, feel free to create an issue or send a pull request.

## Contents 

 - [Minibar in Action](#minibar-in-action)
 - [API Requirements](#api-requirements)
 - [Installation](#installation)
 - [Usage](#usage)
    - [Basic example](#basic-example)
    - [Background and Text Color](#background-and-text-color)
    - [Animations](#animations)
    - [Styling](#styling)
 - [What's next](#whats-next)
 - [About the Author](#about-the-author)
 - [LICENSE](#license)
 

## Minibar in Action
The top bar, that appears, shows the message and disappears is the minibar 🚀 🚀.

<p>
  <image width="30%" height="30%" style="margin:40px;" src="https://github.com/mayuroks/minibar/blob/master/images/demo_dark.gif"></image>
</p>

###

<p>
  <image width="30%" height="30%" style="margin:40px;" src="https://github.com/mayuroks/minibar/blob/master/images/demo_light.gif"></image>
</p>


## API Requirements
Currently, this library is compatible with API 21(Lollipop) and above android versions. I am working on figuring out ways to make it work on android versions below Lollipop(21).

## Installation
To install Minibar, add JitPack to your `project/build.gradle` file
```gradle
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://jitpack.io" } // Add this line
    }
}
```

Add Minibar as a dependency `app/build.gradle` file,
```gradle
dependencies {
    ...
    implementation 'com.github.mayuroks:minibar:0.2.0'
}
```

## Usage

The best way to utilize Minibar, is to put it at the top in your layout file. Because if a user message is shown at the top, it becomes easy to read.

### Basic example
**STEP 1:** Add `MinibarView` to your activity or fragment's layout
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <com.mayurrokade.minibar.MinibarView
        android:id="@+id/minibarView"
        style="@style/MinibarViewCustom"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <!-- Rest of the layout -->

</android.support.constraint.ConstraintLayout>
```

**STEP 2:** Create a `UserMessage` object and show it using `MinibarView`,
```java
final MinibarView minibarView = findViewById(R.id.minibarView);

// Build the user message
UserMessage userMessage = new UserMessage.Builder()
                        .with(mContext)
                        .setMessage("You have 128 unread messages.")
                        .setDuration(3000)
                        .build();

// Show the user message
minibarView.show(userMessage);
```

**STEP 3:** Sit back! Relax! And let Minibar do the rest.

### Background and Text color
BackgroundColor and textColor are the two key parameters that can be tweaked to create effective user messages. You can set the background and textcolor of the user message with `setBackgroundColor()` and `setTextColor()` as follows:
```java
UserMessage userMessage = new UserMessage.Builder()
                        .with(mContext)
                        .setBackgroundColor(R.color.colorSuccess)
                        .setTextColor(android.R.color.white)
                        .setMessage("You have 128 unread messages.")
                        .setDuration(1000)
                        .build();
```

### Animations
Minibar currently supports show and dismiss animation via `Interpolator`s. You can use `setShowInterpolator()` and `setDismissInterpolator()` to animate the show and dismiss respectively.
```java
UserMessage userMessage = new UserMessage.Builder()
                        .with(mContext)
                        .setBackgroundColor(R.color.colorSuccess)
                        .setTextColor(android.R.color.white)
                        .setMessage("You have 128 unread messages.")
                        .setDuration(1000)
                        .setShowInterpolator(new BounceInterpolator())
                        .setDismissInterpolator(new AccelerateInterpolator())
                        .build();
```

### Styling
Styling minibar is as easy as styling any other Android element. In your `styles.xml`, you can create
```xml
<style name="MinibarViewCustom" parent="MinibarView">
    <item name="android:paddingTop">4dp</item>
    <item name="android:paddingBottom">4dp</item>
    <item name="android:textAlignment">center</item>
    <item name="android:textSize">16sp</item>
</style>
```

And in the activity or fragment layout,
```xml
<com.mayurrokade.minibar.MinibarView
    android:id="@+id/minibarView"
    style="@style/MinibarViewCustom"    <=== Set your style here
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

## What's next
 - Add Unit Tests 
 
## About the Author
I’m an UX-first Android Developer, passionate about building great apps. If you like this library, show some ❤️ on:

- [Medium](https://medium.com/@mayuroks)
- [Github](https://github.com/mayuroks)
- [Twitter](https://twitter.com/mayuroks)
- [LinkedIn](https://linkedin.com/in/mayurrokade/)


## LICENSE
 ```text
 MIT License

Copyright (c) 2018 Mayur Rokade

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 ```
