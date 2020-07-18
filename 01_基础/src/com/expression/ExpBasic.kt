package com.expression

/*
 表达式
 lambda表达式可以定义一个函数。
 Lambda表达式的基本用法：
 一，定义一个无参函数
 二，定义一个有参函数
 三，作为其他函数的参数
 
 */

//一、无参的情况
//源代码
//fun printHello() {
//	println("hello")
//}

val printHello = { println("hello") }

//二、有参数的的情况
//源代码
//fun sum(a: Int, b: Int): Int {
//	return a + b
//}
//val sum: (Int, Int) -> Int = { a, b -> a + b }
val sum = { a: Int, b: Int -> a + b }// 参数要省略"()",要不然会报错。。DT


//三、作为其他函数的参数*************************************************************
//源代码
fun multiple(a: Int, b: Int): Int {
	return a * b
}

//两个参数，第二个参数是函数
fun multiple(a: Int, b: (i: Int, j: Int) -> Int): Int {
	return a * (b.invoke(3, 4))
}

//一个参数，参数是函数且函数有参数
fun multiple2(funName: (value: Int) -> Int): Int {
	return funName.invoke(3)
}

//一个参数，参数作为函数且函数无参数
fun multiple3(funName: () -> Int): Int {
	return funName.invoke()
}

//函数作为参数，表达式的参数是String的扩展函数；模仿with()
fun multiple4(str: String, block: String .() -> Int): Int {
	return str.block()
//	return block(str)
//	return 3//bolck表达式将不会被执行
}


fun main(args: Array<String>) {
	println("一，定义无参函数------------------------------------")
	printHello()

	println("二，定义有参函数------------------------------------")
	println("sum(3,5) = ${sum(3, 5)}")

	println("三，表达式作为其他函数的参数------------------------------------")
	println("3.1 两个参数，第二个参数是参数")
	val result = multiple(2, { num1: Int, num2: Int -> num1 * num2 })//这个调用也是够复杂。。。
	//如果函数的最后一个参数是函数，并且传递lambda表达式作为参数时，则可以在圆括号外面传入函数的具体实现
	val result1 = multiple(2) { num1: Int, num2: Int ->
		num1 * num2
	}
	println("result =  ${result}")//2 * 3 *4 = 24
	println("result1 = ${result1}")//2*3*4 = 24

	println("3.2 一个参数，参数是函数且函数有参数-----------------------------")
	val result2 = multiple2({ num: Int -> num * num })
	val result2_2 = multiple2 { it * it }//multiple2只有一个函数作为参数时，可省略"()"直接用"{}"
	println("result2 = ${result2}")
	println("result2_2 = ${result2_2}")

	println("3.3 函数作为参数，且表达式无参------------------------------------")
	val result3 = multiple3({
		8
	})
	println("result3 = ${result3}")//8

	println("3.4 函数作为参数,表达式参数是扩展函数----------------------------------------------")
	val result4 = multiple4("abc") {
		println("this = ${this}")
		this.length
	}
	println("result4 = ${result4}")
}


















	