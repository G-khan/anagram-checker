package dev.gokhana.anagramchecker

import dev.gokhana.anagramchecker.service.AnagramChecker
import dev.gokhana.anagramchecker.service.DefaultAnagramChecker as AnagramCheckerImpl


fun main() {

    val firstText = "Listen"
    val secondText = "Silent"
    println("Anagram Checker example words are $firstText and $secondText\n " +
            "Note: if the words are not valid you can write again!")
    val anagramChecker: AnagramChecker = AnagramCheckerImpl()

    compareAndPrintAnagrams(anagramChecker, firstText,secondText)
    var firstInput: String
    var secondInput: String

    do {
        firstInput = getUserInput("Enter the first word  input: ")
        secondInput = getUserInput("Enter the second word input: ")
    } while (!anagramChecker.isValidInput(firstInput) || !anagramChecker.isValidInput(secondInput))

    compareAndPrintAnagrams(anagramChecker, firstInput,secondInput)
}

fun getUserInput(prompt: String): String {
    print(prompt)
    return readlnOrNull() ?: ""
}

fun compareAndPrintAnagrams(anagramChecker: AnagramChecker, firstInput: String, secondInput: String) {
    if (anagramChecker.isValidInput(firstInput) && anagramChecker.isValidInput(secondInput)) {
        val areAnagrams = anagramChecker.areAnagrams(firstInput, secondInput)

        if (areAnagrams) {
            println("$firstInput and $secondInput are anagrams.")
        } else {
            println("$firstInput and $secondInput are not anagrams.")
        }
    } else {
        println("Both words must not be blank and should only contain alphanumeric characters.")
    }
}


