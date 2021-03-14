# Sharing Code With Multiple TestProject OpenSDK Tests

This is the example application of a blog post which describes how you can share code with
multiple tests which use TestProject OpenSDK by leveraging page objects.

This example assumes that:

* [You are familiar with TestProject OpenSDK](https://www.petrikainulainen.net/programming/testing/introduction-to-testproject-opensdk/)
* [You can create a new TestProject OpenSDK project](https://www.petrikainulainen.net/programming/testing/creating-a-new-testproject-opensdk-project/)
* [You are familiar with JUnit 5](https://www.petrikainulainen.net/junit-5-tutorial/)
* [You can integrate TestProject OpenSDK with JUnit 5](https://www.petrikainulainen.net/programming/testing/configuring-the-testproject-opensdk/)
* [You can write tests for web applications with TestProject OpenSDK and JUnit 5](https://www.petrikainulainen.net/programming/testing/writing-tests-for-web-applications-with-testproject-opensdk-and-junit-5/)
 
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