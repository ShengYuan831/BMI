package edu.my.tarc.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextWeight : EditText = findViewById(R.id.editTextWeight)
        val editTextHeight : EditText = findViewById(R.id.editTextHeight)
        val imageViewBMI : ImageView = findViewById(R.id.imageViewBMI)
        val textViewBMI : TextView = findViewById(R.id.textViewBMI)
        val textViewStatus : TextView = findViewById(R.id.textViewStatus)
        val buttonCalculate : Button = findViewById(R.id.buttonCalculate)
        val buttonReset : Button = findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener {

            if(editTextHeight.text.isEmpty()){
                editTextHeight.setError(getString(R.string.error_value_required))
                return@setOnClickListener
            }
            if(editTextWeight.text.isEmpty()){
                editTextWeight.setError(getString(R.string.error_value_required))
                return@setOnClickListener
            }

            var weight = editTextWeight.text.toString().toFloat()
            var height = editTextHeight.text.toString().toFloat()
            var bmi = weight / (height/100).pow(2)

            if(bmi <= 18.5) {
                //underweight
                imageViewBMI.setImageResource(R.drawable.under)
                textViewBMI.text = bmi.toString()
                textViewStatus.text = String.format("%s : %s" , getString(R.string.status),getString(R.string.under))

            }
            else if(bmi > 18.5 && bmi < 25.0) {
                //normalweight
                imageViewBMI.setImageResource(R.drawable.normal)
                textViewBMI.text = bmi.toString()
                textViewStatus.text = String.format("%s : %s" , getString(R.string.status),getString(R.string.normal))

            }
            else if(bmi >= 25.0 ){
                //overweight
                imageViewBMI.setImageResource(R.drawable.over)
                textViewBMI.text = bmi.toString()
                textViewStatus.text = String.format("%s : %s" , getString(R.string.status),getString(R.string.over))

            }



        }

        buttonReset.setOnClickListener {
            imageViewBMI.setImageResource(R.drawable.empty)
            textViewBMI.text = "Body Mass Index "
            textViewStatus.text = "Status "
            editTextHeight.text.clear()
            editTextWeight.text.clear()

        }
    }
}