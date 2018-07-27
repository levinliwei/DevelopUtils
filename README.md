# DevelopUtils
Development essay

[![](https://jitpack.io/v/levinlove/DevelopUtils.svg)](https://jitpack.io/#levinlove/DevelopUtils)
#### Step1
 //library中部分类库需要偶从jitpack上拉取 所以这里需要引入
 
  工程的build
 ```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
#### Step2
```
dependencies {
	        implementation 'com.github.levinlove:DevelopUtils:beta0.1'
}
```
