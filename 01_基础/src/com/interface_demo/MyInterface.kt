package com.interface_demo

/**
接口：
跟java一样，单继承多实现
一、接口中的方法可有默认实现；与java不同，java接口里方法默认实现必须有static或者default关键字修饰
二、接口里的成员变量不可以初始化，java接口里的成员变量必须要初始化
三、一个类里若实现的类和接口有相同的方法，区别调用时使用super关键字：super<A>.fun()

 */
interface MyInterface {
	//与java不同，java接口中的属性必须初始化，kotlin里接口的属性不可以初始化
	var name: String

	fun fun1()

	//方法可以有默认实现
	fun fun2() {
		println("MyInterface fun2()")
	}
}

interface MyInterface2 {
	fun fun2() {
		println("MyInterface2 fun2()")
	}
}

open class MyInterfaceIml : MyInterface {
	override var name: String = "iml_name"
	override fun fun1() {
		println("iml fun1()");
	}

	//interface 已经实现的方法可以不用再实现
	override fun fun2() {
		super.fun2()
		println("iml fun2()");
	}
}

class Entity : MyInterfaceIml, MyInterface2 {
	constructor()

	override fun fun2() {
		super<MyInterfaceIml>.fun2()
		super<MyInterface2>.fun2()
	}
}

fun main(args: Array<String>) {
	val iml: MyInterfaceIml = MyInterfaceIml()
	iml.fun1()
	iml.fun2()
	println("iml name = ${iml.name}")

	println("-----------entity------------")
	val entity: Entity = Entity()
	entity.fun2()
}


























