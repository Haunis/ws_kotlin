package com.for_demo

/*
 循环控制：
 	for循环：
 		一、一般遍历
 		二、遍历数组
 	continue:跳过当前循环，继续下一次循环
 
 */
fun main(args: Array<String>) {
	println("-------------for 区间---------------");
	for (i in 1..4) {
		println(i);
	}
	println("-- with step --");
	for (i in 1..4 step 2) {
		println(i);
	}
	println("-- with step down --");
	for (i in 4 downTo 1 step 2) {
		println(i);
	}
	println("-------------遍历数组---------------");
	val items = listOf("AAA", "BBB", "CCC");
	for (item in items) {
		println(item);
	}
	for (index in items.indices) {
		println("index[$index] : ${items[index]}");
	}
	for ((index, value) in items.withIndex()) {
		println("withIndex: index = $index, value = $value");
	}

	println("-------------continue---------------");
	for (i in 1..7) {
		if (i == 3) continue;
		if (i > 5) break;
		println("i = " + i);
	}

}
