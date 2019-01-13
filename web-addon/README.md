# TestProject Tutorial: Writing Web Addons With TestProject

This example demonstrate how we can write custom TestProject addons that help us
to write tests for web applications.

Before we can package our tests, we have to download the required _manifest.json_ 
file from the [app.testproject.io](https://app.testproject.io) website and put this 
file to the _src/main/resources_ directory.

After we have downloaded the _manifest.json_ file, we can package our addons by 
using the command: 

    gradle clean build