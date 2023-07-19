
package dev.gokhana.anagramchecker.service

import java.util.*


class DefaultAnagramChecker : AnagramChecker {

    private val VALIDATION_REGEX = "^[a-zA-Z]+\$"

    private fun sanitizeText(text: String): String {
        return text.lowercase(Locale.getDefault()).filter { it.isLetterOrDigit() }.toList().sorted().joinToString("")
    }

    override fun isValidInput(input: String): Boolean {
        return input.isNotBlank() && input.matches(Regex(VALIDATION_REGEX))
    }

    override fun areAnagrams(firstText: String, secondText: String): Boolean {
        val sanitizedFirstText = sanitizeText(firstText)
        val sanitizedSecondText = sanitizeText(secondText)
        return sanitizedFirstText == sanitizedSecondText
    }


}

