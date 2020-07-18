package com.class_demo

/**
继承
1.基类要用open修饰

2.如果子类有主构造，定义时，基类要带构造 ： class Zi(arg1:String,arg2:String):Fu(){}

3.如果子类无主构造，定义时可以有两种定义方式：
a.class Zi:Fu(){}
b.class Zi:Fu{constructor()....};任意一个次级构造均可【次级构造默认调用父类无参次级构造】

4.所有的类默认有一个次级无参构造; 如果定义了主构造或者其他次级构造，默认无无参次级构造
这个时候要使用无参次级构造的话，要显式写出来

5.重写父类方法时，父类方法要用open修饰
如果有多个相同的方法（继承或者实现自其他类，如A、B类），则必须要重写该方法，使用super范型去选择性地调用父类的实现

6.重写属性：子类var属性可以重写父类val属性,但不能反过来；因为val本身定义了getter方法

 */
open class Animal {
	open var name: String = "333"
	open var age = 3//子类val属性不可重写父类var属性

	constructor() {
		println("Animal init");
	}

	//	constructor(name: String, age: Int)
//	constructor(name: String, age: Int, food: String)
	open fun run() {
		println("animal run")
	}
}

/*
 有主构造
 */
class Cat(name: String, age: Int, food: String) : Animal(), RunInterface {
	var food: String
	var catName: String

	override var name: String = "3"
		get() {
			return field
//			return catName
		}
		set(value) {
			field = "catName 23333333"
		}
//	override val age = 7//error；不可用val属性重写var属性

	init {
		this.food = food;
		this.catName = name
		this.name = name;
	}

	override fun run() {
		super<Animal>.run()
		super<RunInterface>.run()
//		println("cat ${this.name} run");
	}
}

/*
 无主构造
 */
class Dog : Animal {
	//默认调用父类无参构造,可以不显示super()
	constructor () /*: super()*/ {
		println("dog init")
	}

	constructor(name: String, age: Int) {}
}

interface RunInterface {
	fun run() {
		println("interface run")
	}
}

fun main(args: Array<String>) {
	println("----------有主构造 cat-------------")
	val cat: Cat = Cat("tom", 12, "fish")
	println("cat.food=${cat.food},cat.name=${cat.name}");
	cat.run()

	println("----------无主构造 dog-------------")
	val dog: Dog = Dog()
	val dog2: Dog = Dog("dog", 7)
}


























