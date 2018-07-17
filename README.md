# Minibar
Show right message at the right place.

# Demo! Hell yeah!
<p>
  <image width="50%" height="50%" style="margin:40px;" src="https://github.com/mayuroks/minibar/blob/master/images/minibar_demo.gif"></image>
</p>

# Requirements
Currently, this library is compatible with API 21(Lollipop) and above devices. I am working on figuring out ways to make it work on devices below that.

# Installation
Coming soon via JitPack

# Usage

**Step 1** 
Add MinibarView to your layout
```xml
<com.mayurrokade.minibar.MinibarView
    android:id="@+id/minibarView"
    style="@style/MinibarViewCustom"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

**Step 2**
Create a UserMessage and show it in MinibarView
```java
final MinibarView minibarView = findViewById(R.id.minibarView);

// Build the user message
UserMessage userMessage = new UserMessage.Builder()
                        .with(getApplicationContext())
                        .setMessage("You have 128 unread messages.")
                        .setDuration(1000)
                        .build();

// Show the user message
minibarView.show(userMessage);
```

**Step 3**
Nothing! That's right! Minibar is quick and easy to use.

# Background and Text color
You can set the background and textcolor of the user message with `setBackgroundColor()` and `setTextColor()` as follows:
```java
UserMessage userMessage = new UserMessage.Builder()
                        .with(getApplicationContext())
                        .setBackgroundColor(R.color.colorSuccess)
                        .setTextColor(android.R.color.white)
                        .setMessage("You have 128 unread messages.")
                        .setDuration(1000)
                        .build();
```

# Animations
Minibar currently supports show and dismiss animation via Interpolators. You can use `setShowInterpolator()` and `setDismissInterpolator()` to animate the show and dismiss respectively.
```java
UserMessage userMessage = new UserMessage.Builder()
                        .with(getApplicationContext())
                        .setBackgroundColor(R.color.colorSuccess)
                        .setTextColor(android.R.color.white)
                        .setMessage("You have 128 unread messages.")
                        .setDuration(1000)
                        .setShowInterpolator(new BounceInterpolator())
                        .setDismissInterpolator(new AccelerateInterpolator())
                        .build();
```

# Styling
Styling minibar is quite easy.

In your styles.xml, you can create
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

# TODO
 - Unit Tests
 - Java docs
 - Improve README
