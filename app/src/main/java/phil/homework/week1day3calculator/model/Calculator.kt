package phil.homework.week1day3calculator.model

abstract class Calculator {

    enum class Operator{PLUS, MINUS, TIMES, DIVIDED_BY, SINED, COSINED, TANGENTED, RAISED_TO, LOGARITHMED, NATURALLY_LOGARITHMED}

    enum class Constant{PI, E}

    abstract fun getCurrentValue(): String

    abstract fun insertDigit(digit: Int)

    abstract fun insertDecimal()

    abstract fun enqueueOperator(operator: Operator)

    abstract fun enterConstant(constant: Constant)

    abstract fun equate()

}