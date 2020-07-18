package com.class_demo

/**
面向对象三：抽象类

抽象成员在类中不存在具体的实现。

类的修饰符：
abstract    // 抽象类
final       // 类不可继承，默认属性
enum        // 枚举类
open        // 类可继承，类默认是final的
annotation  // 注解类
 */
open class OpenClass {
	open fun foo() {}
	open fun foo2() {}
}

abstract class AbstractClass : OpenClass() {
	override abstract fun foo()//和OpenClass语法都很怪异：这里不需要"{}",OpenClass方法里却必须“{}”
	override fun foo2() {}
}

class AbstractIml : AbstractClass() {
	override fun foo() {
		println("iml excuted ");
	}
}

fun main(args: Array<String>) {
	val abstractIml: AbstractIml = AbstractIml();
	abstractIml.foo()
}