package com.example.scalacoremodule

import com.example.core.Foo
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun scala_core_isUsable() {
        assertEquals(42, Foo.bar())
    }

    @Test
    fun scala_either() {
        assertEquals(42, Foo.either().toOption().get())
    }
}