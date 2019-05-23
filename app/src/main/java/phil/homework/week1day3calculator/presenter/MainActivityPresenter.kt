package phil.homework.week1day3calculator.presenter

import phil.homework.week1day3calculator.model.Calculator
import phil.homework.week1day3calculator.model.Equator
import phil.homework.week1day3calculator.view.CalculatorView

class MainActivityPresenter: CalculatorViewPresenter {

    var view: CalculatorView? = null
    val calculator: Calculator = Equator()

    override fun attachView(view: CalculatorView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun registerDigitInput(digit: Int) {
        calculator.insertDigit(digit)
        updateView()
    }

    override fun registerConstantInput(constant: Calculator.Constant) {
        calculator.enterConstant(constant)
        updateView()
    }

    override fun registerOperatorInput(operator: Calculator.Operator) {
        calculator.enqueueOperator(operator)
        updateView()
    }

    override fun registerDecimalInput() {
        calculator.insertDecimal()
        updateView()
    }

    override fun registerEqualsInput() {
        calculator.equate()
        updateView()
    }

    private fun updateView(){
        view?.updateDisplay(calculator.getCurrentValue())
    }

}