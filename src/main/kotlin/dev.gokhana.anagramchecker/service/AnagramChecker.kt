package dev.gokhana.anagramchecker.service

interface AnagramChecker {
    fun areAnagrams(firstText: String, secondText: String): Boolean
    fun isValidInput(input: String): Boolean
}