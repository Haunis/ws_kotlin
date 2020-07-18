package com.fanxing

/*
 泛型方法
 kotlin泛型方法的语法和java类似：java将<T>放在方法返回值前面，kotlin放在方法名前面
 */

fun <T> getBox(value: T) = Box(value)
fun <T> doPrintln(value: T) {
	when (value) {
		is Int -> println("value is Int : ${value}")
		is String -> println("value is String : ${value.toUpperCase()}")
		is Boolean -> println("value is Boolean : ${value}")
	}
}

fun main(args: Array<String>) {
	val intBox = getBox(3)
	println("intBox : ${intBox.value}");

	val age: Int = 24
	val name: String = "zhang san"
	val isMale: Boolean = false
	doPrintln(age)
	doPrintln(name)
	doPrintln(isMale)
}
