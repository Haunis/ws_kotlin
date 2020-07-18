package com.expression.high

fun main() {
	val str = "abc"
	val result1 = str.sumBy({ value: Char -> value.toInt() })
	val result2 = str.sumBy({ it.toInt() })
	val result3 = str.sumBy { it.toInt() }//只有一个参数时，可以直接写成这样

	println("result1 = ${result1}")
	println("result2 = ${result2}")
	println("result3 = ${result3}")
}






