# TetxViewStyle
Hi guys , this libray for changing style of text in android Developement .
# Example 

<img alt="Card sample" width="360" height="600" src="http://mrdeveloper.online/github/text_style.png" />

# Example Usage

```groovy
<com.example.textstylelibrary.TextViewStyle
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:text="Hello Developer"
            app:textColor="@android:color/holo_green_dark"
            app:textSize="80"
            app:textStyle="3" />
```
# Add Library 

```groovy
dependencies {
	        implementation 'com.github.tahaprogrammer:TextViewStyleByTaHa:1.0.1'
	}
```

```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
