package com.basic_data_type

/*
 基本数据类型：Byte,Short,Int,Long,Float,Double	--字符不属于数值类型，是一个独立的数据类型
 一、比较两个数字：
 	== 比较值，	=== 比较对象地址
 二、类型转换
 	基本数据类型是对象，所以不能隐式地进行转换。要显式地使用API进行转换
 三、字符
 	和Java不一样，Kotlin里的Char不能直接和数字进行操作
 四、数组
 	生成数组的方式：1.arrayOf()	2.Array()	3.listOf()
 	Array,ByteArray,IntArray;
 五、map
 	map的生成方式： mapOf("key1" to "value1","key2" to "value2")

 */
fun main(args: Array<String>) {
	println("--------------1.比较两个数字-----------------");
	val a: Int = -1000;
	//经过装箱，生成两个不同对象
	val b: Int? = a;
	val c: Int? = a;
	println("a===a : " + (a === a));//true,比较对象地址
	println("b===c : " + (b === c));//false,两个对象地址不同;[如果a定义为可为空(val a:Int?=10000)或者数字[-128,127]则为true
	println("b==c : " + (b == c));//true,虽然地址不同，但值相同

	println("--------------2.类型转换-----------------");
	val byteA: Byte = 1;
//	val intA :Int =byteA;编译错误，不可以直接转换
	val intA: Int = byteA.toInt();
	println("intA = " + intA);
	//有些情况下，根据上下文推断是可以自动转换的
	val l = 1L + 3;
	println("l = " + l);

	println("--------------3.字符Char-----------------");
	val charA: Char = '0';
//	if(charA===47){}//编译报错，字符不可以与数字直接进行操作
	if (charA in '0'..'9') {
		val charToInt: Int = charA.toInt();//48,按ASCII码进行转换
		println("charToInt = " + charToInt);
	} else {
		println("else");
//		throw IllegalArgumentException("Out of range")//不能编译，，，。。。。。。
	}
	println("--------------4.数组-----------------");
	val array1 = arrayOf(1, 2, 3);
	val array2 = Array(3, { i -> i * 2 });
	printArray(array1)
	printArray(array2)//0,2,4

	println("--------------5.map-----------------");
	val map: Map<String, String> = mapOf("zhang" to "21 ", "lee" to "23")
	//要加（）...
	map.forEach { (key, value) -> println("${key}-${value}") }
	println(map.get("zhang"))

	val hint = {
		var msg = "hello"
		println("this is a msg from hint : ${msg}")
	}
	println("hint = ${hint}")//Unit
}

fun printArray(array: Array<Int>): Unit {
	var str: String = ""
	for (index in array.indices) {
		str = str.plus(array[index]).plus(" ")
	}
	println(str)
}

