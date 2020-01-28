# Serenity Appium Screenplay Example Project


This is a sample project to demonstrate how Serenity-BDD and Screenplay Pattern can integrate with Appium

The App under test consists of 3 different Apps which share the same shell-base code, but include different data

Following the serenity's Actor-Centric approach we have:

**Berner**, the actor who uses the App in Berlin, therefore installs the **berlin-offline-city-map.apk**

**Lodovico**, the actor who uses the App in London, therefore installs the **london-offline-city-map.apk**

**Lisbet**, the actor who uses the App in Lisbon, therefore installs the **lisbon-offline-city-map.apk**

**The starting point of the tests, is the .feature files, located on src/test/resources/features**


## Pre-Requisites


#### Browserstack account with <browserstack_username> and <browserstack_apikey> for App Automate

# Set environment variables in your system:

    BROWSERSTACK_USERNAME = <browserstack_username>
    BROWSERSTACK_ACCESS_KEY = <browserstack_apikey>

(alternatively you can also directly hard code them into serenity.properties file, assigning to the variables browserstack.user and browserstack.key respectively)

## Get the code

Git:

    git clone https://github.com/gizdolok/serenity-appium-screenplay-example.git
    cd serenity-appium-screenplay-example


# Upload 3 Apps to your Browserstack account:

## Berlin Offline City Map:

    curl -u "<browserstack_username>:<browserstack_apikey>" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@/<path_for_your_project>/serenity-appium-screenplay-example/src/test/resources/app/berlin-offline-city-map.apk" -F "data={\"custom_id\":\"berlin-offline-city-map\"}"

    Get the value of the shareable_id that results from this request and assign it to the browserstack.appBerlin variable on the serenity.properties file

## London Offline City Map:

    curl -u "<browserstack_username>:<browserstack_apikey>" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@/<path_for_your_project>/serenity-appium-screenplay-example/src/test/resources/app/london-offline-city-map.apk" -F "data={\"custom_id\":\"london-offline-city-map\"}"

    Get the value of the shareable_id that results from this request and assign it to the browserstack.appLondon variable on the serenity.properties file

## Lisbon Offline City Map:

    curl -u "<browserstack_username>:<browserstack_apikey>" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@/<path_for_your_project>/serenity-appium-screenplay-example/src/test/resources/app/lisbon-offline-city-map.apk" -F "data={\"custom_id\":\"lisbon-offline-city-map\"}"

    Get the value of the shareable_id that results from this request and assign it to the browserstack.appLisbon variable on the serenity.properties file


## Use Maven ro Execute test


To verify project's integrity:

    mvn clean verify

To execute specific profiles:

    mvn clean verify -P <profile_name>


## Execution Profiles
