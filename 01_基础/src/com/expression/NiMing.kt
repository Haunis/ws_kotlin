package com.expression

/*
 匿名函数
 参考：https://www.cnblogs.com/Jetictors/p/8647888.html
 
 匿名函数和正常函数的区别：正常函数有函数名，匿名函数没有
 
 匿名函数和Lambda表达式区别：匿名函数要用fun关键字修饰
 */
fun main(args: Array<String>) {
	val test = fun(x: Int, y: Int): Int {
		return x + y
	}
	val test2 = fun(x: Int, y: Int): Int = x + y
	val test3 = fun(x: Int, y: Int) = x + y

	val a = test(3, 4)
	val b = test2(3, 4)
	val c = test3(3, 4)

	println("a = ${a}")
	println("b = ${b}")
	println("c = ${c}")
}
