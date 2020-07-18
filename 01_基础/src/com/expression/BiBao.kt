package com.expression

/*
 闭包：函数中包含函数
 */
fun main(args: Array<String>) {
	val t = test(0)
	println(t.invoke())//1
	println(t.invoke())//2
	println(t())//3

	val t2 = test2(3)
	println("t2.invoke(4)=${t2.invoke(4)}")

	println("test3()----------------------------------------")
	test3()
}

//返回一个函数，并且携带状态值
fun test(a: Int): () -> Int {
	var b = 0;
	return fun(): Int {
		b++
		return a + b
	}
}

fun test2(a: Int): (Int) -> Int {
	val t = fun(b: Int): Int {

		return a + b
	}
	return t
}

//对数组进行过滤，并把过滤的结果进行求和
fun test3() {
	var sum: Int = 0
	var sum2: Int = 0
	val array = arrayOf(1, 2, 3, 4, 5)
	array.filter { value -> value > 3 }.forEach { value -> sum += value }
	array.filter { it > 3 }.forEach { sum2 += it }
	println("sum = ${sum}")
	println("sum2 = ${sum2}")
}










