package dev.gokhana.anagramchecker

import dev.gokhana.anagramchecker.service.AnagramChecker
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class AnagramMainTest {


    @Test
    fun `test CompareAndPrintAnagrams - When Anagrams`() {
        // Arrange
        val anagramChecker = mock(AnagramChecker::class.java)
        `when`(anagramChecker.isValidInput("listen")).thenReturn(true)
        `when`(anagramChecker.isValidInput("silent")).thenReturn(true)
        `when`(anagramChecker.areAnagrams("listen", "silent")).thenReturn(true)

        // Act
        val output = captureSystemOutput {
            compareAndPrintAnagrams(anagramChecker, "listen", "silent")
        }

        // Assert
        assertEquals("listen and silent are anagrams.", output.trim())
    }

    @Test
    fun `test CompareAndPrintAnagrams - When Not Anagrams`() {
        // Arrange
        val anagramChecker = mock(AnagramChecker::class.java)
        `when`(anagramChecker.isValidInput("hello")).thenReturn(true)
        `when`(anagramChecker.isValidInput("world")).thenReturn(true)
        `when`(anagramChecker.areAnagrams("hello", "world")).thenReturn(false)

        // Act
        val output = captureSystemOutput {
            compareAndPrintAnagrams(anagramChecker, "hello", "world")
        }

        // Assert
        assertEquals("hello and world are not anagrams.", output.trim())
    }

    @Test
    fun `test CompareAndPrintAnagrams - When Invalid Input`() {
        // Arrange
        val anagramChecker = mock(AnagramChecker::class.java)
        `when`(anagramChecker.isValidInput("")).thenReturn(false)

        // Act
        val output = captureSystemOutput {
            compareAndPrintAnagrams(anagramChecker, "", "world")
        }

        // Assert
        assertEquals("Both words must not be blank and should only contain alphanumeric characters.", output.trim())
    }

    // Helper function to capture system output
    private fun captureSystemOutput(block: () -> Unit): String {
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)
        val originalOut = System.out
        System.setOut(printStream)

        block()

        System.setOut(originalOut)
        return outputStream.toString().trim()
    }
}
