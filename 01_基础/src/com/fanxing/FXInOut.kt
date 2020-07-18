package com.fanxing

/*
 参考：
 kotlin: https://blog.csdn.net/jjwwmlp456/article/details/74853080
 java: http://www.importnew.com/24029.html
 
 kotlin泛型型变：
 协变：out,只能作为输出。   相当于java里的只能get, <? extendx T>
 逆变：in,只能作为输入。	  相当于java里的只能set,<? super T>
 */
class Boxx<in T, E> {
	fun copy(from: Array<out E>, to: Array<in E>) {
		for (index in from.indices) {
			to[index] = from[index]
//			from[index] = to[index] //编译错误，out不可以做输入，in不可以做输出
		}
	}
}

fun main(args: Array<String>) {
	val box = Boxx<String, String>()
//	val from = listOf("aaa","bbb","ccc")
	val from = arrayOf("aaa", "bbb", "ccc")
	val to: Array<String> = arrayOf("0", "1", "2");

	box.copy(from, to)

	for ((index, value) in to.withIndex()) {
		println("to: ${value}")
	}
}
