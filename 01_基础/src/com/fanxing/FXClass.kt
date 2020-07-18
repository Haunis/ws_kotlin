package com.fanxing

/**
泛型类
 */
class Box<T>(t: T) {
	var value = t;
}

fun main(args: Array<String>) {
	val intBox: Box<Int> = Box<Int>(0)
	val intBox1 = Box(1)//类型自动推断

	val stringBox = Box("box string")

	println("intBox : ${intBox.value}")
	println("intBox1 : ${intBox1.value}")
	println("stringBox : ${stringBox.value}")
}