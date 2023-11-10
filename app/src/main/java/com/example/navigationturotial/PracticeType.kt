package com.example.navigationturotial

enum class PracticeType(val sign: String) {
    ADDITION("+") {
        override fun calculate(value1: Int, value2: Int): Int = value1 + value2
    };
    abstract fun calculate(value1: Int, value2: Int): Int

}