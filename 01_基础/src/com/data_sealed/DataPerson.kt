package com.data_sealed

/**
数据类：http://www.runoob.com/kotlin/kotlin-data-sealed-classes.html
一、数据类使用关键字data声明
二、主构造必须至少包含一个参数，参数必须使用val或者var修饰
三、数据类不可以声明为abstract,open,sealed或者inner
四、数据类不可以继承其他类，但可以实现接口

 */
data class Person(val name: String, val age: Int) {
}

fun main(args: Array<String>) {
	//以下两种实例化都可以
//	val p1: Person = Person(name = "Jack", age = 22)
	val p1: Person = Person("Jack", 22)
	val p2 = p1.copy(age = 17)//吐槽：这个语法真是怪异。

	println("p1 = ${p1}")
	println("p2 = ${p2}")

	val (name, age) = p1//
	println("name=${name},age=${age}")
}