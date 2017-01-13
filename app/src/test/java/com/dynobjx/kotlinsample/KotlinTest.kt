package com.dynobjx.kotlinsample

import com.dynobjx.kotlinsample.models.Post
import com.dynobjx.kotlinsample.models.User
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by root on 1/13/17.
 */
class KotlinTest {

    @Test
    fun ronald() {
        val x: IntArray = intArrayOf(1, 2, 3)
        for(y in x)  {
            println(y)
        }
    }

    @Test
    fun galang() {
        // equivalent of 1 <= i && i <= 4
        for (i in 1..4) print(i) // prints "1234"

        for (i in 4 downTo 1) print(i) // prints nothing
    }

    @Test
    fun ron() {
        for (i in 1 until 7) { // i in [1, 10), 10 is excluded
            println(i)
        }
    }

    @Test
    fun classes() {
        val user: User = User("13")
        //user.password = "rygalang13"
        println(user.password ?: "empty or null")
        assertNotNull(user.password ?: "empty or null", user.password)
    }

    @Test
    fun arrayOfClass() {

    }

}