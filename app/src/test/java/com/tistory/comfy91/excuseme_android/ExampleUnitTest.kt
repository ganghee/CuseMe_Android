package com.tistory.comfy91.excuseme_android

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    data class Person(
        val age: Int,
        val name: String,
        val isMale: Boolean
    )




    @Test
    fun addition_isCorrect() {
        val list = listOf(
            Person(25, "신승민", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(14, "신승민2", false),
            Person(23, "신승민3", true)
        )

        println(list
            .filter { person -> person.age >= 20 }
            .filter { person -> !person.isMale }
            .sortedBy { person -> person.age }
            .map { person -> "멋진 ${person.name} 낄" }
        )

        println(
            list.take(4)
        )



    }
}




