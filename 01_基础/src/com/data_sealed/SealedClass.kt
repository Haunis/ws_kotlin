package com.data_sealed
/*
 密封类：
 相当于限定了子类有哪些
 
 */

sealed class Expr
data class Const(val num: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotNum : Expr()

fun eval(ex: Expr): Double = when (ex) {
	is Const -> ex.num
	is Sum -> eval(ex.e1) + eval(ex.e2)
	NotNum -> Double.NaN
}

fun main(args: Array<String>) {
	val e1 = Const(33.0)
	val e2 = Sum(Const(2.0), Const(3.0))
	val e2_2 = Sum(e2, e2)

	println("eval(e1) = ${eval(e1)}")
	println("eval(e2) = ${eval(e2)}")
	println("eval(e2_2) = ${eval(e2_2)}")
}