package com.helloworld

/*
 参考：http://www.runoob.com/kotlin/kotlin-basic-syntax.html
 吐槽：注释奇葩，方法定义奇葩。
 	
 函数的定义:
 	无返回值写成：Unit
 	可变参数用关键字修饰：vararg
 	方式一：	fun test(a:Int,b:Int):Int(){} //方法名后面跟返回值
 	方式二：	fun test(a:Int,b:Int)=a+b;//表达式作为函数体，返回值类型自动推断
 			public fun test(a:Int,b:Int):Int=a+b;//public 方法则必须明确写出返回类型
 
 
 */

fun main(args: Array<String>) {
	println("----------函数、变量、常量的定义-----------");
	//变量的定义：
	var result: Int = sum(3, 4);
	//常量的定义
	val result2: Int = sum(4, 4);
	println("result=${result}, result2 ${result2} ");

	println("----------可变参数------------");
	printArray(1, 2, 3, 4);

	println("----------匿名函数------------");
	doLambdaTest();

	println("----------字符串模板------------");
	var a = 1
	val s1 = "a is $a"
	println("s1 = " + s1);//s1 = a is 1

	a = 2
	val s2 = "${s1.replace("is", "was")}, but now is $a"
	println("s2 = " + s2);//s2 = a was 1, but now is 2
}

//匿名函数
fun doLambdaTest(): Unit {
	val lambdaSum: (Int, Int) -> Int = { x, y -> x + y }
	val lambdaSum2 = { x: Int, y: Int -> x + y }
	println("lambdaSum(5, 5)=${lambdaSum(5, 5)}");
	println("lambdaSum2(5, 6)=${lambdaSum2(5, 6)}");

	val printMsg = { msg: String -> println(msg) }
	printMsg("12")
}

fun sum(a: Int, b: Int): Int {
	return a + b;
}

//可变参数
fun printArray(vararg arrays: Int): Unit {
	for (element in arrays) {
		println("element = " + element);
	}
}













