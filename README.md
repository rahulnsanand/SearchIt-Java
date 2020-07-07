# SearchIt

![version](https://img.shields.io/badge/version-1.0.1-green.svg)


SearchIt is a Java based project that works with a custom-made Trie data structure that I have termed, FlopTrie, to parse through all the json documents with restaurant id of all the restaurants available in India on Zomato, the food delivery/rating app.

The basic outline of what the app does is as follows:

  - Parses through all the .json files using the JacsonXML Parser
  - Updates the FlopTrie with all the restaurant names and id to ensure unique values
  - Searches through the FlopTrie for the given restaurant names and makes an API call on selection to Zomato API
  - Upon the GET method of the Zomato API, Another API call is made to google maps static API for location snapshot.
  - Restaurant details are shown including the location snapshot as a result page.

#### New Features!

  - You can now select a Dark Theme!
  - Downloading the API detail as a .json file is yet to come.
  - Check Internet Connectivity at launch and during search, handled.


#### Dependencies Used

SearchIt uses these open source projects to work properly:

* [FasterXML-Jackson](https://github.com/FasterXML) - Faster Json reading and parsing capabilities!
* [JSoup](https://github.com/jhy/jsoup) - Best website accessing method to retrieve restaurant id of thousands of restaurants by the tedious process of webscraping.
* [Google Static Maps API](https://developers.google.com/maps/documentation/maps-static) - Pretty straight forward? To get a snapshot of the restaurants location based on longitude and latitude.
* [Zomato API](https://developers.zomato.com/documentation#/) - To get all the details pertaining to a restaurant.
* [Univocity Parser](https://www.univocity.com/pages/univocity_parsers_tutorial) - To read CSV files in the fastest manner, incase our dataset is bunch of .csv files rather than .json
* [IntelliJ - Java](https://www.jetbrains.com/idea/) - duh!

And of course SearchIt itself is open source with a [public repository](https://github.com/theflopguy/SearchIt-Java) on GitHub.

### Installation

SearchIt requires [IntelliJ with Java](https://www.jetbrains.com/idea/) to run.

Just clone the repository onto a folder of your choice by following these steps.
(Hope you have [GIT](https://git-scm.com/downloads) installed)

```sh
[My-Folder]$ git clone https://github.com/theflopguy/SearchIt-Java.git
```

Next, open IntelliJ and open the project.

#### Build Configuration
![Build Configuration](https://github.com/theflopguy/SearchIt-Java/blob/master/gitHubImages/BuildImage.png)

#### Welcome Screen
![ReadMe](https://github.com/theflopguy/SearchIt-Java/blob/master/gitHubImages/ReadMeWelcome.png)

#### Run Main Method
![Run Main](https://github.com/theflopguy/SearchIt-Java/blob/master/gitHubImages/RunMainImage.png)

#### Loading The FlopTrie and instances required.
![LoadingPage](https://github.com/theflopguy/SearchIt-Java/blob/master/gitHubImages/LoadingPageImage.png)

#### DarkMode UI
![SearchPage Dark](https://github.com/theflopguy/SearchIt-Java/blob/master/gitHubImages/SearchPageDarkImage.png)

#### LightMode UI
![SearchPage Light](https://github.com/theflopguy/SearchIt-Java/blob/master/gitHubImages/SearchPageLightImage.png)

#### Searching Procedure, Type a restaurant name and hit enter. (Click is not supported, yet)
![SearchProcess](https://github.com/theflopguy/SearchIt-Java/blob/master/gitHubImages/SearchProcessImage.png)

#### Search Result
![SearchResult](https://github.com/theflopguy/SearchIt-Java/blob/master/gitHubImages/Search%20Result.png)

Once the dependencies are automatically installed through Maven repo, Hope you have [Internet](), you can run the app by just simply clicking on "Run Main" option.


### Development

Want to contribute? Great!

Just improvise your code the way you see fit, describe it in a, well, descriptive manner. And create a pull request.


**Java is awesome!**
