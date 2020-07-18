package com.delegate

import kotlin.reflect.KProperty
/*
 类的委托:
 一个类中定义的方法实际上是调用另一个类的对象的方法实现
 
 
 */
//类委托-----------------------------------------------------
interface Base {
	fun foo()
}

class BaseIml : Base {
	override fun foo() {
		println("BaseIml foo")
	}
}

//通过关键字by建立委托
class Derived(b: Base) : Base by b{
	fun derivedFun(){
		println("derivedFun excuted")
	}
}

//属性委托-----------------------------------------------------
class Example {
	var p: String by Delegate()
}

class Delegate {
	operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
		return "$thisRef, 这里委托了${property.name}属性"
	}

	operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
		println("$thisRef 的 ${property.name}属性赋值为 $value")
	}
}

fun main(args: Array<String>) {
	println("类委托----------------------------------")
	val baseIml = BaseIml()
	val derived: Derived = Derived(baseIml)
	derived.foo()
	derived.derivedFun()

	println("属性委托--------------------------------")
	val example: Example = Example()
	println("example.p=${example.p}")//访问属性p,调用getValue()函数
	
	example.p = "Lee"//调用setValue()函数

}
























