package com.let_it_run

/*
 一，it
 只有一个参数时，形参可用it代替并简化;使用it时，类不可有有参方法
 
 二，let
 将复杂的对象赋给it

 三，apply
 可以操作一个对象的任意函数，再结合let返回该对象. Eclipse无法运行，AndroidStudio 可以正常编译运行
 
 四，run
 apply操作一个对象，run是操作一个代码块。
 apply返回操作的对象，run的返回则是最后一行代码的对象
 
 五，with
 操作一个对象，只不过把对象作为参数传入
 返回最后一行代码的对象
 
 */
class Person(name: String) {
	var name = name
	//	lateinit var age: Int//基本类型不可以使用lateinit--因为Kotlin会使用null来对每一个用lateinit修饰的属性做初始化。
	//而基础类型是没有null类型，所以无法使用lateinit。
	var age = 0
	var weight = 0

	constructor (name: String, age: Int) : this(name) {
		this.name = name
		this.age = age
	}

	fun eat() {
		println("person eat meat")
	}

//	fun setWeight( weight: Int ) {
//		this.weight = weight
//	}
}

@Suppress("MISSING_DEPENDENCY_CLASS")
fun main(args: Array<String>) {
	println("1.it------------------------------------------------------")
	val array = arrayOf(1, 2, 3)
	printArray(array)

	val list = array.map { value -> value * 2 }
	printList(list)
	val list2 = array.map { it * 2 }//只有一个参数时，形参可用it代替并简化
	printList(list2)

	println("2.let------------------------------------------------------")
	val person = Person("zhang", 13)
	val person22 = person.let {
		it.name = "Leeeeeeeeeee"//将Person赋给it
		it.eat()
		println("it = ${it} ,it.name = ${it.name}, it.age =${it.age}")
	}
	println("person22 = ${person22}")//为空类型


	println("3.apply------------------------------------------------------")
	//Eclipse无法兼容运行ArrayList，在AndroidStudio则可以正常编译运行
//		val arrayList = arrayListOf(1, 2, 3)
	val applyArray = arrayOf(1, 2, 3)
	var applyResult = applyArray.apply {
		set(0, 777)
	}.let { /*it.size*/it }
	println("applyResult =  ${applyResult}")
	printArray(applyResult)

	println("4.run------------------------------------------------------")
	val runArray: Array<Int> = arrayOf(1, 2, 3)
	val result = runArray.run() {
		set(0, 4)
		var person = Person("wang", 22)
		person
	}.let { /*it*/it.name }
	println("result = ${result}")//"wang"
	printArray(runArray)

	val runResult = run {
		println("this is run")
		3
	}
	println("runResult = ${runResult}")//3

	println("5.with------------------------------------------------------")
	val withArray = arrayOf(1, 2, 3)
	val withResult = with(withArray) {
		set(0, 4)
		println("this is with inner")
		withArray
	}.let { it }
	printArray(withResult)

}

fun <T> printList(list: List<T>) {
	var str: String = ""
	for (item in list) {
		str = str.plus(item).plus(" ")
	}
	println("list : ${str}")
}

fun <T> printArray(array: Array<T>) {
	var str: String = ""
	for (item in array) {
		str = str.plus(item).plus(" ")
	}
	println("array  : ${str}")
}
