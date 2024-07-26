package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String): UiState
    fun decrement(number: String): UiState
    fun initial(number: String): UiState

    data class Base(val step: Int, val max: Int, val min: Int) : Count {

        init {
            when {
                max <= 0 -> throw IllegalStateException("max should be positive, but was $max")
                step <= 0 -> throw IllegalStateException("step should be positive, but was $step")
                step > max -> throw IllegalStateException("max should be more than step")
            }
        }

        override fun increment(number: String): UiState {
            val sum = number.toInt() + step

            return getState(sum, sum.toString())
        }

        override fun decrement(number: String): UiState {
            val diff = number.toInt() - step
            return getState(diff, diff.toString())
        }

        override fun initial(number: String): UiState {
            val initValue = number.toInt()
            return getState(initValue, initValue.toString())
        }

        private fun getState(value: Int, number: String): UiState {
            val middleValue = max / 2
            return when (value) {
                min -> UiState.Min(number)
                in (min + 1)..middleValue -> UiState.Base(number)
                else -> UiState.Max(number)
            }
        }
    }
}