package com.string

/*
 不像StringBuilder，String.plus()不会把结果赋给原值

 */
fun main(args: Array<String>) {
	var str: String = ""
	str = str.plus("1").plus(" ").plus("a")
	println(str)
}