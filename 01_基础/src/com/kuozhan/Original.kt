package com.kuozhan

/**
参考:http://www.runoob.com/kotlin/kotlin-extensions.html

扩展函数：扩展函数和成员函数同名时，优先执行成员函数,保证对象安全性--如果类的成员函数被扩展函数覆盖了，就无法保证类的安全性
扩展函数可以使用当前对象的上下文this

扩展属性：扩展属性只能是val,所以没有setter方法。没有后端变量field，所以不可以被初始化

扩展函数所在的分发接受者被子类重写扩展函数时，扩展函数是静态的，多态是动态的

 */

//1.扩展函数基础------------------------------------------------------------------
class Original {
	fun originalFun() {
		println("originalFun ")
	}
}

//Original 的扩展函数
fun Original.ExFun() {
	originalFun()
	println("ExFun this = ${this}");
}

//扩展函数和成员函数同名时，优先执行成员函数---就是说无法扩展已经存在的方法
fun Original.originalFun() {
	println("扩展的originalFun")
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
	val temp = this[index1]
	this[index1] = this[index2]
	this[index2] = temp
}

//2.扩展属性------------------------------------------------------------------
val Original.name: String
	get() = "this is expand name"

//3.扩展函数是静态解析的------------------------------------------------------------------
open class Fu {
	open fun run() {
		println("fu run");
	}
}

class Zi : Fu() {
	override fun run() {
		println("zi run");
	}
}

fun Fu.foo() {
	println("fu foo")
}

fun Zi.foo() {
	println("zi foo")
}

fun testFoo(fu: Fu) {//测试扩展函数,静态,"fu foo"
	fu.foo()
}

fun testRun(fu: Fu) {//测试多态，动态
	fu.run()
}

//4.扩展空对象,如果不加“？”扩展函数会被Any的成员函数覆盖-----------------------------
fun Any?.toString(): String {
	if (this == null) {
		return "null null null  "
	}
	return toString()
}

//5.伴生对象------------------------------------------------------------------
class MyClass {
	companion object {}
}

fun MyClass.Companion.foo() {
	println("伴随对象的扩展函数")
}

val MyClass.Companion.num: Int
	get() = 10

//6.扩展函数可以在其他类里，作为其他类的成员函数-------------------------------------
//扩展接受者
class A {
	fun aFun() {
		println("aFun")
	}

	fun call() {
		println("a call");
	}
}

//分发接受者--就是含有扩展函数的类
class B {
	fun bFun() {
		println("bFun")
	}

	fun call() {
		println("b call");
	}

	fun A.expandFun() {
		aFun()
		bFun()

		call()//a call;假如某一函数在分发接受者和扩展接受者中均存在，以扩展接受者优先
		this@B.call()//b call
		println("this = ${this}")//上下文引用this 是A
	}

	fun foo(a: A) {
		a.expandFun()
	}
}

//7.作为其他类的成员函数,可以被子类重写--------------------------------------------------------------
open class FuA {}

class ZiA : FuA() {}

open class ExFu {
	open fun FuA.foo() {
		println("FuA foo in ExFu")
	}

	open fun ZiA.foo() {
		println("ZiA foo in ExFu");
	}

	fun call(fuA: FuA) {
		fuA.foo()//静态，始终调用FuA.foo();如果分发接受者被子类重写的话，调用分发接受者子类里的FuA.foo()
	}

	fun CallZiAFoo() {
		ZiA().foo()
	}
}

class ExZi : ExFu() {
	override fun FuA.foo() {
		println("FuA foo in ExZi")
	}

	override fun ZiA.foo() {
		println("ZiA foo in ExZi");
	}
}

fun FuA.test() {
	println("FuA.test()")
}

fun ZiA.test() {
	println("ZiA.test()")
}

fun main(args: Array<String>) {
	println("1.扩展函数基础--------------------------")
	val original: Original = Original()
	original.ExFun()
	original.originalFun()//扩展函数和成员函数同名时，优先执行成员函数

	val list = mutableListOf(1, 2, 3)
	println("original list:${list}");
	list.swap(0, 2)
	println("swaped list: ${list}");

	println("1.扩展属性--------------------------")
	println("original.name = ${original.name}")

	println("3.扩展函数是静态解析的------------------------")
	testFoo(Zi())//fu foo
	testRun(Zi())//多态是动态的

	println("4.扩展空对象--------------------------")
	val t = null
	println(t.toString());//如果t为null，调用上面定义的toString()；否则调用Any的toString()

	println("5.伴生对象--------------------------")
	println("MyClass.num = ${MyClass.num}");
	MyClass.foo()

	println("6.扩展函数作为成员变量--------------------------")
	val b: B = B()
	b.foo(A())

	println("7.扩展函数的重写-------------------------")
	ExFu().call(FuA())//FuA foo in ExFu
	ExFu().call(ZiA())//FuA foo in ExFu
	ExZi().call(FuA())//FuA foo in ExZi 分发接受者虚拟解析
	ExZi().call(ZiA())//FuA foo in ExZi

	ExFu().CallZiAFoo()//ZiA foo in ExFu

	val ziA: FuA = ZiA()
	ziA.test()//FuA.test() 静态解析
}












