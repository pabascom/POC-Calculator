package phil.homework.week1day3calculator.presenter

import android.view.View
import phil.homework.week1day3calculator.model.Calculator

interface CalculatorViewPresenter {

    fun attachView(view: View)

    fun detachView(view: View)

    fun registerDigitInput(digit: Int)

    fun registerConstantInput(constant: Calculator.Constant)

    fun registerOperatorInput(operator: Calculator.Operator)

    fun registerDecimalInput()

    fun registerEqualsInput()
}