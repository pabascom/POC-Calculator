package phil.homework.week1day3calculator.model

import java.lang.StringBuilder

class Equator(): Calculator() {
    private var value = StringBuilder("0")

    override fun getCurrentValue(): String {
        return value.toString()
    }

    override fun updateCurrentValue(digit: Int) {
        value.append(digit)
    }

    override fun insertDecimal() {
        value.append('.')
    }

    override fun enqueueOperator(operator: Operator) {
        when(operator){
            Operator.PLUS -> value.append('+')
            Operator.MINUS -> value.append('-')
            Operator.TIMES -> value.append('*')
            Operator.DIVIDED_BY -> value.append('/')
            else -> value.append("fancy!")
        }
    }

    override fun enqueueConstant(constant: Constant) {
        value = when(constant){
            Constant.PI -> StringBuilder("3.1ish")
            Constant.E -> StringBuilder("like two thirds")
        }
    }

    override fun equate() {
        value = StringBuilder("4")
    }

}