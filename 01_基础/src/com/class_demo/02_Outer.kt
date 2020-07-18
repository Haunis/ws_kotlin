package com.class_demo

/**
面向对象二：内部类、嵌套类

一、内部类：使用inner关键字修饰，持有外部类引用，实例化格式： val inner :Outer.Inner = Outer().Inner();

二、嵌套类：在类里面定义的类；不持有外部类的引用，实例化： val nest:Outer.Nested = Outer.Nested();

三、匿名内部类：必须使用object关键字，详细见下面示例
 
kotlin嵌套类和java内部类对应，java里没有inner关键字

 */
class Outer {
	private val TYPE: Int = 100
	var mName: String? = "name"
	lateinit var mTestInterface: TestInterface

	fun setInterface(testInterface: TestInterface) {
		this.mTestInterface = testInterface
	}

	fun show() {
		mTestInterface.show()
	}

	/*
	内部类
	 */
	inner class Inner {
		fun getOuterType() = TYPE;//内部类持有外部类的对象的引用，可以直接外部类的成员变量和成员方法
		fun innerFun() {
			var outer: Outer = this@Outer
			println("outer.mName : ${outer.mName}");
			println("outer.mName : ${mName}");//也可以直接访问外部类属性
		}
	}

	/*
	嵌套类
	 */
	class Nested {
		//		var nestName = mName//error;不可以直接访问外部类属性
		val outer = Outer();//可以实例化外部类
		fun getOUterType() = outer.TYPE;
		fun nestFun() = 2;
	}
}

interface TestInterface {
	fun show()
}

fun main(args: Array<String>) {
	println("内部类------------------");
	val inner: Outer.Inner = Outer().Inner()
	println("inner.getOUterType() : ${inner.getOuterType()}");
	println("inner.innerFun() : ${inner.innerFun()}");

	println("嵌套类------------------");
	val nest: Outer.Nested = Outer.Nested();
	println("inner.getOUterType() : ${inner.getOuterType()}");
	println("nest.nestFun() : ${nest.nestFun()}");

	println("匿名内部类------------------");
	val outer: Outer = Outer()
	//必须使用object关键字
	outer.setInterface(object : TestInterface {
		override fun show() {
			println("testInterface show excuted");
		}
	})
	outer.show()
}	













