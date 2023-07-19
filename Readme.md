# Anagram Checker

The Anagram Checker is a simple Kotlin application that allows users to check if two input texts are anagrams of each other. Anagrams are words or phrases formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Example

Here is an example of running the application and checking if the words "Listen" and "Silent" are anagrams:

```bash
Anagram Checker example words are Listen and Silent
Enter the first word or numeric input: Listen
Enter the second word or numeric input: Silent
Listen and Silent are anagrams.
```

## How to Run the Application

To run the Anagram Checker application locally on your machine, you can use the following steps:

1. Clone this repository to your local machine.
2. Make sure you have Kotlin installed on your system. If not, you can download and install it from the official Kotlin website: [Kotlin Official Website](https://kotlinlang.org/).
3. Open a terminal or command prompt and navigate to the root directory of the cloned repository.
4. Compile the Kotlin source code using the following command:

```bash
    ./gradlew build 
```
5. Run the application using the following command:

```bash
 java -jar .\build\libs\anagramchecker-1.0-SNAPSHOT.jar
 ```
## Running the Application with Docker

Alternatively, you can run the Anagram Checker application in a Docker container. Docker allows you to package the application and its dependencies into a single container, making it easy to deploy and run in any environment.

To run the application with Docker, follow these steps:

1. Make sure you have Docker installed and running on your system. You can download and install Docker from the official website: [Docker Official Website](https://www.docker.com/get-started).
2. Clone this repository to your local machine (if you haven't already done so).
3. Open a terminal or command prompt and navigate to the root directory of the cloned repository.
4. Build the Docker image using the provided Dockerfile:

```bash
docker build -t anagram-checker .
```
5. Run the Docker container using the following command:

```bash
docker run -it anagram-checker
```

This will start the application inside the Docker container, and you can interact with it as usual.

## How to Use the Application

Upon running the application, you will see the prompt asking you to enter the first word or numeric input. Type the first word you want to check for anagrams and press Enter. Next, you will be prompted to enter the second word or numeric input. Type the second word and press Enter.

The application will then display whether the two input words are anagrams or not. If they are anagrams, it will show the message "Word1 and Word2 are anagrams." If they are not anagrams, it will show the message "Word1 and Word2 are not anagrams."

Note: The application only considers alphanumeric characters when checking for anagrams and ignores spaces and special characters.


## Testing
The Anagram Checker application includes both unit tests and integration tests to ensure the correctness of its functionalities. The tests are written using JUnit 5 and Mockito.

To run the tests, make sure you have JUnit 5 and Mockito installed. Then, navigate to the root directory of the cloned repository and run the following command:

```bash
./gradlew test
```
## License
[MIT](https://choosealicense.com/licenses/mit/)
