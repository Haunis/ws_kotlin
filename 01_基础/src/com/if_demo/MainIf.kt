package com.if_demo

/*
 条件控制：
 	一、if既可以像java一样使用，也可以作为表达式有返回值。所以kotlin可以不需要像Java一样需要三元运算符
 	二、使用区间in
 	三、when : 可以像Java里switch一样使用，但语法不同，默认使用else不是default。可以使用关键字 【is,in】
 		when 亦可以代替if-else链使用
 */
fun main(args: Array<String>) {
	println("------------if---------------");
	val a: Int = 3;
	val b: Int = 4;
	val max: Int;
	if (a > b) {
		max = a;
	} else {
		max = b;
	}
	println("max = " + max);
	//作为表达式直接返回结果
	val min: Int = if (a < b) a else b;
	println("min = " + min);
	//is 关键字
	val str: String = "abc"
	if (str is String) {
		println("str is String")
	} else {
		println("str is NOT String")
	}

	println("------------in---------------");
	val x: Int = 7;
	println("" + x + "是否在区间(1..8)：　" + if (x in 1..8) true else false);

	println("------------when---------------");
	val y: Int = 7;
	when (y) {
		0, 1 -> println("y ==0 or y==1");
		else -> println("y is not 0 nor 1");
	}
	when (y) {
		0 -> println("y==0");
		1 -> println("y==1");
		else -> {
			println("y not 0,,not 1")
		}
	}
	when (y) {
		in 1..10 -> println("y = " + y + ",  y in 1..10");
		else -> println("not in 1..10");
	}
	when (y) {
		is Int -> println("y is Int")
		else -> println("y is not Int");
	}
	//代替 if-else 链使用，when后面不跟()
	when {
		y is Int -> println("y is Int")
		else -> println("y is not Int")
	}
}
