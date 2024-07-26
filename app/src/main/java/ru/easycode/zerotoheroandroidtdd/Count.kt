package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String): String

    data class Base(val step: Int) : Count {

        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
        }

        override fun increment(number: String): String {
            return "${number.toInt() + step}"
        }
    }
}