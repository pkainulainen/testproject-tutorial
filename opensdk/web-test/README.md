# Writing Tests for a Web Application With TestProject OpenSDK And JUnit 5

This is the example application of a blog post which describes how you can write tests 
for a web application with TestProject OpenSDK when you run your tests with JUnit 5.

This example assumes that:

* [You are familiar with TestProject OpenSDK](https://www.petrikainulainen.net/programming/testing/introduction-to-testproject-opensdk/)
* [You can create a new TestProject OpenSDK project](https://www.petrikainulainen.net/programming/testing/creating-a-new-testproject-opensdk-project/)
* [You are familiar with JUnit 5](https://www.petrikainulainen.net/junit-5-tutorial/)
* [You can integrate TestProject OpenSDK with JUnit 5](https://www.petrikainulainen.net/programming/testing/configuring-the-testproject-opensdk/)
 
## Running the Tests

You can run the tests by following these steps:

1. Download and register the TestProject agent.
2. Get the developer key from TestProject'
s website and set it as the value of the `TP_DEV_TOKEN` environment variable.
3. Start the TestProject agent.
4. Run the tests by using Maven or Gradle.

If you want to use Maven, you can run the tests by using the command:

    mvn clean test

If you want to use Gradle, you can run the tests by using the command:

    gradle clean test