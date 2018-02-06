# Project Title

Android Coding Exercise for showing the List of News Articles and clicking on the item will take the User to the Detailed News Section.

## Getting Started

This repository contains a detailed sample App which consumes the given API and displays a list of news articles to the user. App implements MVP Architecture using Dagger2, RxJava, Retrofit2, Butter Knife, Stetho, Event Bus, Espresso, Mockito and Material Design

### Prerequisites - Development

Android Studio 3.0, Gradle, Build Tools Version >= 25.0.2

### App Supported Devices

From Android Minimum SDK Version 19 / Android 4.4 (KITKAT)

### Installing

A Dropbox link is provided is below, which can be used to download the APK and installing on the physical device, following instructions ( Additonal step is to "Enable Third Party Apps Installation" on Device )


### Overview 

This repository contains a detailed sample app that implements MVP architecture using Dagger2, GreenDao, RxJava, FastAndroidNetworking, PlaceHolderView and AndroidDebugDatabase
<p align="center">
  
 <img src="https://github.com/anbuuu/fairfaxpictures/blob/master/App%20Landing%20Page.png" width="250">
 <img src="https://github.com/anbuuu/fairfaxpictures/blob/master/App%20Detailed%20-%20Webview.png" width="250">

 
</p>


### Architecture Blue Print

Implemented the project with Clean Architecture ( Bob ). I had chosen this one for the implementation which is Indepdnent of Frameworks, Each component individually testable, Independent of UI and any external agency.  Borrowing from Bob's Clean Architecture Diagram as below : 

<img src="https://github.com/anbuuu/fairfaxpictures/blob/master/Clean%20Architecture%20Bob.png" width="400" height="250"/>

The main dependency rule is that source code dependencies can only point inwards and nothing in an inner circle know anything about something in the outer circle. 

<img src="https://github.com/anbuuu/fairfaxpictures/blob/master/Bobs-Implementation.png" width="300" height="250" />

### Project Structure


```
Give an example
```



## Libraries Used

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds




## Versioning

Demo Versioning v1.0

## Author

* **Anbu Ezhilan** - (https://github.com/anbuuu)

