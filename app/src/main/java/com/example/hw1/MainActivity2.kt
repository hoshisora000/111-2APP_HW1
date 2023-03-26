package com.example.hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var val1 = ""
        var val2 = ""
        intent?.extras?.let{
            var val1 = it.getString("inf1")
            var val2 = it.getString("inf2")
        }

        var sugarVolume="no input"
        val RadioGroup_sugar = findViewById<RadioGroup>(R.id.sugar)
        RadioGroup_sugar.setOnCheckedChangeListener { _, i ->
            sugarVolume = RadioGroup_sugar.findViewById<RadioButton>(i).text.toString()
            Log.d("Sugar", sugarVolume)
        }

        var iceVolume="no input"
        val RadioGroup_ice = findViewById<RadioGroup>(R.id.ice)
        RadioGroup_ice.setOnCheckedChangeListener { _, i ->
            iceVolume = RadioGroup_ice.findViewById<RadioButton>(i).text.toString()
            Log.d("ice", iceVolume)
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {

            var input_drink = findViewById<EditText>(R.id.drink).text
            val bundle=Bundle()
            bundle.putString("inf1",val1)
            bundle.putString("inf2",val2)
            bundle.putString("inf3",input_drink.toString())
            bundle.putString("inf4",sugarVolume)
            bundle.putString("inf5",iceVolume)
            val intent = Intent().putExtras(bundle)
            setResult(Activity.RESULT_OK,intent.putExtras(bundle))
            finish()
        }
    }

}