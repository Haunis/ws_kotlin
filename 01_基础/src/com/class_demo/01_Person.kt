package com.class_demo

/**
面向对象一：基础


一、构造函数：
1.类的声明可以有主构造，也可以没有。格式: class Person constructor (name:String){};可以没有construct关键字
2.次构造函数要直接或间接通过另一个次构造函数代理主构造函数。格式： constructor(name:String ,age:Int):this(name){}
3.所有的类默认有一个次级无参构造; 如果定义了主构造或者其他次级构造，默认无无参次级构造
这个时候要使用无参次级构造的话，要显式写出来

二、成员变量
1.var成员属性默认有getter(),setter()方法。val默认实现getter,重写的话注意后端变量field的使用
2.非空属性必须在定义的时候初始化，如果不想初始化可以使用lateinit关键字修饰
3.如果构造方法里的变量用var或val修饰，则默认该类拥有此成员变量

 */


//类的定义可以不带 {}---这一点kotlin也是奔放。
class JustDemo

//主构造
class Person constructor(name: String) {
	//	var allByDefault: Int? // 错误: 需要一个初始化语句, 默认实现了 getter 和 setter 方法
	var initialized = 1    // 类型为 Int, 默认实现了 getter 和 setter
	val MY_TYPE: Int?  // 类型为 Int ，默认实现 getter ，但必须在构造函数中初始化
	val TYPE: Int = 1  // 类型为 Int 类型,默认实现 getter

	lateinit var heigth: String//非空属性必须在定义的时候初始化，如果不想初始化可以使用lateinit关键字修饰

	//getter,setter:关键字使用field
	var name: String?
		get() = field?.toUpperCase()
		set
	var age: Int = 99
		get() = field
		set(value) {
			if (value > 0) field = value else field = -1
		}

	init {
		this.name = name
		this.MY_TYPE = 3;
	}

	//次构造函数要直接或间接通过另一个次构造函数代理主构造函数
	constructor(name: String, age: Int) : this(name) {
		this.name = name
		this.age = age
	}


	fun eat(food: String): Unit {
		println(this.name + " eat  $food");
	}
}

fun main(args: Array<String>) {
	//新建对象的格式,前面要用修饰符var/val修饰，没有new 关键字
	var person: Person = Person("zhang ");
	println("person.name=${person.name} ,person.age=${person.age}");

	val person2: Person = Person("lee", -99);
	println("person2.name=${person2.name} ,person2.age=${person2.age}");
	person2.eat("apple");

	val p3: Person = Person(name = "Lee")
	println("p3= ${p3},p3.name=${p3.name}")
}


