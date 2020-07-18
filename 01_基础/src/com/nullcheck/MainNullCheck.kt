package com.nullcheck

fun main(args: Array<String>) {
	//后面加？表示可为空。默认不可为null
	var age: String? = "22";
	//!!抛出空指针异常
	val ageInt1 = age!!.toInt();
	//不处理，返回null
	val ageInt2 = age?.toInt();
	//如果为空，则返回-1
	val ageInt3 = age?.toInt() ?: -1;

	println("ageInt1 = " + ageInt1);
	println("ageInt2 = " + ageInt2);
	println("ageInt3 = " + ageInt3);

	var str: String?;//如果不定义可为null，str不可赋值为null
	str = null;
	val result: Int? = doNullTest(str);
	println("result = " + result);
}

//当一个引用可能为null时，参数里的类型声明必须明确地标记为可为null
fun doNullTest(str: String?): Int? {
	println("str = " + str);
	return str?.toInt();
}