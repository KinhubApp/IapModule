# IAP Module for Android

The IAP module provides a ready-made UI allowing your users to purchase Kin within your app. The module basically routes your users to an activity in the Kin Hub app, in a way that seems completely native. 

## Installation

To include the library in your project, do the following:

1.  Add jitpack to your build.gradle_  project file:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

2. Add the latest IapModule version to your build.gradle file:

```
implementation 'com.github.KinhubApp:IapModule:<latest release>’
```

For the latest IapModule release, go to [https://github.com/KinhubApp/IapModule/releases](https://github.com/KinhubApp/IapModule/releases).

## Initializing *IapManager*

IapManager is the base object that opens the UI and allows your users to purchase Kin.

To create the object, use the following contructor:

```
public IapManager(@NonNull String publicAddress);
```

Example:

You should pass the user's public address.

```
IapManager iapManager = new IapManager(*publicAddress*);
```

### Starting the Module Flow

To start the module flow, the developer needs to call method start of the IapManager object:

```
public void start(Context context) throws IapInitException
```

This method throws IapInitException if IapManager was initialised with an invalid public address.

Example:
```
private void startIapService(){
	try {
		iapManager.start(this);
	} catch (IapInitException e){
		Log.d(TAG, e.getMessage());
	}
}
```
You can use any clickable object of your own for starting the module flow.

## User does not have Kin Hub installed

Upon starting the module flow, if the user does not have the [Kin Hub] app installed, they will be prompted with the following popup:

![PreScreenshot](/app/src/main/res/drawable/Pre_Screenshot.png?raw=true)

The user is not required to do anything but have the app installed on their phone. This is necessary, so developers don't have to be responsible for kyc, compliance, and/or any additional legal requirements.

## User has Kin Hub installed

If the user has the Kin Hub app installed, they will be prompted with the following screen:

![Post Screenshot](/app/src/main/res/drawable/Post_Screenshot.png?raw=true)

Upon successful purchase, Kin will be deposited to the public address which the IapManager was initialized with.

## Sample Code

You can see sample app for the module usage here:

* [app](/app)

## License

This project is licensed under the GNU GPLv3 - see the [LICENSE.md](/LICENSE.md) file for details.
