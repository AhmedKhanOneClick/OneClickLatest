package com.gama.databinding_validation

import org.junit.Assert.assertFalse
import org.junit.Test

class CommonPattensTest {

    @Test
    fun `EMAIL with correct email then return true`() {
        //arrange
        val input = "test@gmail.com"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.EMAIL)

        //assert
        assert(isValid)
    }

    @Test
    fun `EMAIL with incorrect email then return false`() {
        //arrange
        val input = "test@gmail."

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.EMAIL)

        //assert
        assertFalse(isValid)
    }

    @Test
    fun `NO_SPECIAL_CHARS with input does't contains special chars then return true`() {
        //arrange
        val input = "abcd1234"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.NO_SPECIAL_CHARS)

        //assert
        assert(isValid)
    }

    @Test
    fun `NO_SPECIAL_CHARS with input that contains special chars then return false`() {
        //arrange
        val input = "abcd1234&"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.NO_SPECIAL_CHARS)

        //assert
        assertFalse(isValid)
    }

    @Test
    fun `ONLY_CHARS_WITH_SPACE with input contains only chars and space then return true`() {
        //arrange
        val input = "abcd efg"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.ONLY_CHARS_WITH_SPACE)

        //assert
        assert(isValid)
    }

    @Test
    fun `ONLY_CHARS_WITH_SPACE with input contains chars, space and numbers then return false`() {
        //arrange
        val input = "abcd 123"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.ONLY_CHARS_WITH_SPACE)

        //assert
        assertFalse(isValid)
    }


    @Test
    fun `ONLY_CHARS_WITH_SPACE with input contains contains chars, space and special chars then return false`() {
        //arrange
        val input = "abcd #"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.ONLY_CHARS_WITH_SPACE)

        //assert
        assertFalse(isValid)
    }


    @Test
    fun `COMPLEX_PASSWORD with correct complex password then return true`() {
        //arrange
        val input = "P@ssw0rd"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.COMPLEX_PASSWORD)

        //assert
        assert(isValid)
    }

    @Test
    fun `COMPLEX_PASSWORD with password without special chars then return false`() {
        //arrange
        val input = "Passw0rd"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.COMPLEX_PASSWORD)

        //assert
        assertFalse(isValid)
    }

    @Test
    fun `COMPLEX_PASSWORD with password without number then return false`() {
        //arrange
        val input = "P@ssword"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.COMPLEX_PASSWORD)

        //assert
        assertFalse(isValid)
    }

    @Test
    fun `COMPLEX_PASSWORD with password without capital litter then return false`() {
        //arrange
        val input = "p@ssw0rd"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.COMPLEX_PASSWORD)

        //assert
        assertFalse(isValid)
    }

    @Test
    fun `COMPLEX_PASSWORD with password without small litter then return false`() {
        //arrange
        val input = "P@SSW0RD"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.COMPLEX_PASSWORD)

        //assert
        assertFalse(isValid)
    }

    @Test
    fun `COMPLEX_PASSWORD with password length more than 16 char then return false`() {
        //arrange
        val input = "P@ssw0rd111111111111"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.COMPLEX_PASSWORD)

        //assert
        assertFalse(isValid)
    }

    @Test
    fun `COMPLEX_PASSWORD with password length less than 8 char then return false`() {
        //arrange
        val input = "P@s0"

        //act
        val isValid = isInputTxtMatch(input, CommonPatterns.COMPLEX_PASSWORD)

        //assert
        assertFalse(isValid)
    }
}