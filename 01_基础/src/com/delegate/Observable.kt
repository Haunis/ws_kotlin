package com.delegate

import kotlin.properties.Delegates

/**
可观察属性

目前还不理解此用法实际用处。。。
 */
class User {
	var name: String by Delegates.observable("初始值") { prob, old, new ->
		println("prob=${prob} , old=${old} , new=${new}")
	}

}


fun main(args: Array<String>) {
	val user = User()
	user.name = "第一次赋值"
	user.name = "第二次赋值"

}