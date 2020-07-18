package com.expression

/*
 filter, _ ,it 的使用
 */
fun main(args: Array<String>) {
	println("filter-----------------------------------")
	testFilter()
	
	println("it-----------------------------------")
	var result = testIt(10, { num: Int -> num > 5 });
	println("result = ${result}")
	result = testIt(10, { it > 5 })//只有一个参数时，参数可用it代替
	println("it result = ${result}")

	println("test_-----------------------------------")
	test_()
}

fun testFilter() {
	val array = arrayOf(3, 4, 5, 7, 9)
	val filterArray = array.filter { it < 5 }//保留小于5的元素
	val first = filterArray.component1()//取第一个元素
	println("filterArray = ${filterArray} ,first = ${first}")
}

//fun testIt(num: Int, b: (value: Int) -> Boolean): Int {//可以省略参数名value
fun testIt(num: Int, b: (Int) -> Boolean): Int {

	return if (b(num)) {//如果匿名函数b执行结果为true则返回num,否则返回0
		num
	} else 0
}

fun test_() {
	var map = mapOf("0" to "zhang0", "1" to "zhang1 ", "2" to "zhang2")
	//lambda表达式可以省略小括号
	map.forEach { (key, value) ->
		println("value =${value}")
	}
	//参数不使用时，可以使用"_"代替
	map.forEach { (_, value) ->
		println("value = ${value}")
	}
}


