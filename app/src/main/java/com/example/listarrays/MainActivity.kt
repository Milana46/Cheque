package com.example.listarrays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.listarrays.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    



    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




        binding.calculateButton.setOnClickListener{
            calculateType()
        }

    }

    private fun calculateType() {
        //val тк здесь значение при расчете меняться не будет!!!
        val number=binding.coastOfService.text.toString().toDouble()
        val group=binding.tipOprions.checkedRadioButtonId

        val percentage=when(group){
           R.id.option_ten_percent->0.1
            R.id.option_ten_percent1->0.07
            else -> 0.05
        }


        var tip=number*percentage
        val round=binding.roudSwitch.isChecked
        if(round){
            tip.roundToInt()
        }
        //Работа с валютой
        val currencyTip=NumberFormat.getCurrencyInstance().format(tip)
       binding.summa.text=currencyTip.toString()
    }
}