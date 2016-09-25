Android cache library powered by RxJava and FastJson

RxFastCache 是一个结合 RxJava 与 FastJson 的本地缓存库

========
# Add to your project

[![](https://jitpack.io/v/tysheng/RxFastCache.svg)](https://jitpack.io/#tysheng/RxFastCache)

```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
```groovy
dependencies {
    compile 'com.github.tysheng:RxFastCache:1.0.0'
}
```
###Init
```java
 public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RxFastCache.init(this);
    }
}
```
#Usage

###Bean

```java
    RxFastCache.put(TAG, person)
                .subscribeOn(Schedulers.io())
                .subscribe();
```
```java
   RxFastCache.get(TAG, Person.class)
                .subscribeOn(Schedulers.io())
                .subscribe();
```
###List
```java
    RxFastCache.putArray(TAG, person)
                .subscribeOn(Schedulers.io())
                .subscribe();
```

```java
    RxFastCache.getArray(TAG, Person.class)
                .subscribeOn(Schedulers.io())
                .subscribe();
```
###Bitmap
```java
    RxFastCache.getBitmap(TAG, bitmap)
                .subscribeOn(Schedulers.io())
                .subscribe();
```

```java
   RxFastCache.putBitmap(TAG, bitmap)
                .subscribeOn(Schedulers.io())
                .subscribe();
```
