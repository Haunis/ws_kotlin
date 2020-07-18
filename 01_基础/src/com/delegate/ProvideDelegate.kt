package com.delegate

/*
 无法导入Exception
 */
import kotlin.reflect.KProperty
import kotlin.properties.ReadOnlyProperty

class MyUI {
	val image by bindResource(ResourceID("111", "112"))
	val text by bindResource(ResourceID("222", "223"))

	val url by ResourceLoader(ResourceID("444", "445"))
}

class ResourceID {
	var image_id: String
	var text_id: String

	constructor (image_id: String, text_id: String) {
		this.image_id = image_id
		this.text_id = text_id
	}
}

fun bindResource(id: ResourceID): ResourceLoader {
	val resourceLoader = ResourceLoader(id)
	return resourceLoader
}

class ResourceLoader(id: ResourceID) {
	val d: ResourceID = id
	operator fun provideDelegate(thisRef: MyUI, prop: KProperty<*>): ReadOnlyProperty<MyUI, String> {
		if (checkProperty(thisRef, prop.name)) {
			return RopIml(d)
		} else {
//			throw java.lang.Exception("Error ${prop.name}")
			return RopIml(ResourceID("333", "334"))
		}
	}

	private fun checkProperty(thisRef: MyUI, name: String): Boolean {
		return name.equals("image") || name.equals("text") || name.equals("url")
	}
}

class RopIml(id: ResourceID) : ReadOnlyProperty<MyUI, String> {
	val d = id
	override fun getValue(thisRef: MyUI, property: KProperty<*>): String {
		if (property.name.equals("image"))
			return property.name + "  " + d.image_id
		else
			return property.name + "  " + d.text_id
	}
}


fun main(args: Array<String>) {
//	try {
	var ui = MyUI()
	println(ui.image)
	println(ui.text)
	println(ui.url)
//	} catch (e: java.lang.Exception) {
//		println(e.message)
//	}
}







