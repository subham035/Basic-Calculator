package com.example.calculatorapk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapk.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAc.setOnClickListener {
            binding.inputtext.text=""
            binding.outputtext.text=""
        }

        binding.btn0.setOnClickListener {
            binding.inputtext.append("0")
        }
        binding.btn1.setOnClickListener {
            binding.inputtext.append("1")
        }
        binding.btn2.setOnClickListener {
            binding.inputtext.append("2")
        }
        binding.btn3.setOnClickListener {
            binding.inputtext.append("3")
        }
        binding.btn4.setOnClickListener {
            binding.inputtext.append("4")
        }
        binding.btn5.setOnClickListener {
            binding.inputtext.append("5")
        }
        binding.btn6.setOnClickListener {
            binding.inputtext.append("6")
        }
        binding.btn7.setOnClickListener {
            binding.inputtext.append("7")
        }
        binding.btn8.setOnClickListener {
            binding.inputtext.append("8")
        }
        binding.btn9.setOnClickListener {
            binding.inputtext.append("9")
        }
        binding.btnDot.setOnClickListener {
            binding.inputtext.append(".")
        }
        binding.btnPlus.setOnClickListener {
            binding.inputtext.append(" + ")
        }
        binding.btnMinus.setOnClickListener {
            binding.inputtext.append(" - ")
        }
        binding.btnMultiple.setOnClickListener {
            binding.inputtext.append(" * ")
        }
        binding.btnDivide.setOnClickListener {
            binding.inputtext.append(" / ")
        }
        binding.btnRightbracket.setOnClickListener {
            binding.inputtext.append(" ) ")
        }
        binding.btnLeftbracket.setOnClickListener {
            binding.inputtext.append(" ( ")
        }



        binding.btnEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
                val result = expression.evaluate()
                val longresult = result.toLong()

                if (result == longresult.toDouble()) {
                    binding.outputtext.text = longresult.toString()
                } else {
                    binding.outputtext.text = result.toString()
                }
            } catch (e: ArithmeticException) {
                binding.outputtext.text = "Error: infinite"
            } catch (e: Exception) {
                binding.outputtext.text = "Error"
            }
        }

        binding.btnDlt.setOnClickListener {
            val currentText = binding.inputtext.text.toString()
            if (currentText.isNotEmpty()) {
                binding.inputtext.text = currentText.dropLast(1)
            }
        }











        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
