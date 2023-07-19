package dev.gokhana.anagramchecker

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class AnagramIntegrationTest {

    private val originalIn = System.`in`
    private val originalOut = System.out
    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setIn(originalIn)
        System.setOut(originalOut)
        outputStream.reset()
    }

    @Test
    fun `testMain with Full Flow - Anagrams`() {
        // Arrange
        val input = "Listen\nSilent\n"
        val expectedOutput = "Listen and Silent are anagrams."

        // Redirect input stream
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // Act
        main()

        // Assert
        assertTrue(outputStream.toString().trim().contains(expectedOutput))

    }

    @Test
    fun `testMain with Full Flow - Not Anagrams`() {
        // Arrange
        val input = "Hello\nWorld\n"
        val expectedOutput = "Hello and World are not anagrams."

        // Redirect input stream
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // Act
        main()

        // Assert
        assertTrue(outputStream.toString().trim().contains(expectedOutput))
    }
}
