package com.delegate

/**
 把属性存储在map中。
 
 val属性使用Map
 var属性使用MutableMap,定义MutableMap的语法：mutableMapOf()	
 */
class Site(map: Map<String, String>) {
	val name: String by map
	val url: String by map
}

fun main(args: Array<String>) {
	val map: Map<String, String> = mapOf("name" to "BaiDu", "url" to "www.baidu.com")
	val site = Site(map)

	println("site.name = ${site.name}")
	println("site.url = ${site.url}")
}