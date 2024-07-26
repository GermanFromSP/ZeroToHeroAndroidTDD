package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String): UiState

    data class Base(val step: Int, val max: Int) : Count {

        init {
            when {
                max <=0 -> throw IllegalStateException("max should be positive, but was $max")
                step <= 0 -> throw IllegalStateException("step should be positive, but was $step")
                step > max -> throw IllegalStateException("max should be more than step")
            }
        }

        override fun increment(number: String): UiState {
            val sum = number.toInt() + step

            return if (sum > (max / 2)) {
                UiState.Max(text = sum.toString())
            } else {
                UiState.Base(text = sum.toString())
            }
        }
    }
}