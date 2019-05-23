package phil.homework.week1day3calculator.view

import android.app.Activity
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import phil.homework.week1day3calculator.R
import phil.homework.week1day3calculator.model.Calculator
import phil.homework.week1day3calculator.presenter.CalculatorViewPresenter
import phil.homework.week1day3calculator.presenter.MainActivityLandscapePresenter
import phil.homework.week1day3calculator.presenter.MainActivityPresenter
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity(), View.OnClickListener, CalculatorView {
    lateinit var presenter: CalculatorViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            this.presenter = MainActivityLandscapePresenter()
        } else {
            this.presenter = MainActivityPresenter()
        }
        presenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun updateDisplay(value: String) {
        tvCalcText.text = value
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnAdd -> presenter.registerOperatorInput(Calculator.Operator.PLUS)
            R.id.btnSubtract -> presenter.registerOperatorInput(Calculator.Operator.MINUS)
            R.id.btnMultiply -> presenter.registerOperatorInput(Calculator.Operator.TIMES)
            R.id.btnDivide -> presenter.registerOperatorInput(Calculator.Operator.DIVIDED_BY)
            R.id.btnSine -> presenter.registerOperatorInput(Calculator.Operator.SINED)
            R.id.btnCosine -> presenter.registerOperatorInput(Calculator.Operator.COSINED)
            R.id.btnTangent -> presenter.registerOperatorInput(Calculator.Operator.TANGENTED)
            R.id.btnPower -> presenter.registerOperatorInput(Calculator.Operator.RAISED_TO)
            R.id.btnLogarithm -> presenter.registerOperatorInput(Calculator.Operator.LOGARITHMED)
            R.id.btnNaturalLog -> presenter.registerOperatorInput(Calculator.Operator.NATURALLY_LOGARITHMED)
            R.id.btnPi -> presenter.registerConstantInput(Calculator.Constant.PI)
            R.id.btnEuler -> presenter.registerConstantInput(Calculator.Constant.E)
            R.id.btnFullStop -> presenter.registerDecimalInput()
            R.id.btnEquals -> presenter.registerEqualsInput()
            else -> {
                val v = view as TextView
                val d = parseInt(v.text.toString())
                presenter.registerDigitInput(d)
            }
        }
    }
}
