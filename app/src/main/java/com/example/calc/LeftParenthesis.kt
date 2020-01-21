package com.example.calc

import java.util.*

class LeftParenthesis(private val inExpression: String, private val operatorStack: Stack<Char>): TokenHandler() {
    override fun belongs(current: Int): Boolean {
        return inExpression[current] == '('
    }

    override fun operate(current: Int) {
        if (current > 1 && (inExpression[current-1] in '0'..'9' || inExpression[current-1] == ')')){
            operatorStack.push('*')
            operatorStack.push('(')
        }
        else {
            operatorStack.push('(')
        }
    }

    override fun postFixBelongs(currentToken: String): Boolean {
        return false
    }

    override fun postFixOperate(currentToken: String, stack: Stack<Double>) {

    }
}
