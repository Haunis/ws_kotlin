package com.enum_demo

/**
枚举实例化：
以Color为例：
1.Color.RED
2.enumValueOf<Color>("BLUE")
3.Color.valueOf("GREEN")

获取枚举所有元素：
1.enumValues<Color>()
2.Color.values()

枚举名称：
默认枚举字符名，值从0开始；若需要指定值，可使用其构造函数

 */

enum class Week(value: Int) {
	MONDAY(100),
	TUESDAY(200),
	WEDNESDAY(1),
	THURSDAY(2),
}

enum class Color {
	RED,
	BLUE,
	GREEN;
}

//遍历枚举
inline fun <reified T : Enum<T>> printAllValues() {
//	val colors: Array<Color> = enumValues<Color>()
	val colors: Array<T> = enumValues<T>()
	val result: String = colors.joinToString { it.name }
	println("result : ${result}")

	val colors2: Array<Color> = Color.values()
	var str: String = ""
	for (item in colors2) {
		str = str.plus(item).plus(" ")
	}
	println("str : ${str}")
}

fun main(args: Array<String>) {
	val red: Color = Color.RED//实例化
	val blue: Color = enumValueOf<Color>("BLUE");//实例化
	val green: Color = Color.valueOf("GREEN")//实例化

	println("red=${red}, red.name=${red.name}, red.ordinal=${red.ordinal}");
	println("blue=${blue}, blue.name=${blue.name}, blue.ordinal=${blue.ordinal}");
	println("green=${green}, green.name=${green.name}, green.ordinal=${green.ordinal}");

	println("遍历枚举------------------------------")
	printAllValues<Color>()//RED, BLUE, GREEN

	println("有构造的枚举------------------------------")
	val monday = Week.MONDAY
	val thursday = Week.THURSDAY
	println("monday=${monday}, monday.name=${monday.name}, monday.ordinal=${monday.ordinal}");
	println("thursday=${thursday}, thursday.name=${thursday.name}, thursday.ordinal=${thursday.ordinal}");

}















