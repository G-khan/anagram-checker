package dev.gokhana.anagramchecker

import dev.gokhana.anagramchecker.service.DefaultAnagramChecker
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AnagramCheckerTest {

    private val anagramChecker = DefaultAnagramChecker()

    @Test
    fun testAreAnagrams() {
        assertTrue(anagramChecker.areAnagrams("listen", "silent"))
        assertTrue(anagramChecker.areAnagrams("123", "321"))
    }

    @Test
    fun testAreNotAnagrams() {
        assertFalse(anagramChecker.areAnagrams("hello", "world"))
        assertFalse(anagramChecker.areAnagrams("listen", "listens"))
    }

    @Test
    fun testCaseInsensitivity() {
        assertTrue(anagramChecker.areAnagrams("LISTEN", "SiLeNt"))
    }

    @Test
    fun testInvalidInputs() {
        assertFalse(anagramChecker.isValidInput(""))
        assertFalse(anagramChecker.isValidInput("243"))
        assertFalse(anagramChecker.isValidInput(""))
    }

    @Test
    fun testMixedAlphanumericInputs() {
        assertTrue(anagramChecker.areAnagrams("Listen123", "silent321"))
        assertTrue(anagramChecker.areAnagrams("L12i3st&^en", "si#L&te^n123"))
    }
}
