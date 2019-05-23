package phil.homework.week1day3calculator.presenter

import android.view.View
import phil.homework.week1day3calculator.model.Calculator
import phil.homework.week1day3calculator.view.CalculatorView

interface CalculatorViewPresenter {

    fun attachView(view: CalculatorView)

    fun detachView()

    fun registerDigitInput(digit: Int)

    fun registerConstantInput(constant: Calculator.Constant)

    fun registerOperatorInput(operator: Calculator.Operator)

    fun registerDecimalInput()

    fun registerEqualsInput()
}