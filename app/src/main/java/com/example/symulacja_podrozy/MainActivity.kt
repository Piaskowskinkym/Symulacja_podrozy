package com.example.symulacja_podrozy

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var tVstartDate : TextView
    private lateinit var tVmiddleDate : TextView
    private lateinit var tVendDate : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         tVstartDate = findViewById(R.id.tVstartDate)
         tVmiddleDate= findViewById(R.id.tVmiddleDate)
         tVendDate = findViewById(R.id.tVendDate)
        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)


        }

        tVstartDate.setOnClickListener {
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
            updatetVstartDate(myCalendar)
        }
        tVmiddleDate.setOnClickListener {
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
            updatettVmiddleDate(myCalendar)
        }
        tVendDate.setOnClickListener {
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
            updatetVendDate(myCalendar)
        }

    }



    private fun updatetVstartDate(myCalendar: Calendar) {
            val myFormat = "dd-MM-yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.GERMANY)

            tVstartDate.setText(sdf.format(myCalendar.time))

    }
    private fun updatettVmiddleDate(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.GERMANY)

        tVstartDate.setText(sdf.format(myCalendar.time))

    }
    private fun updatetVendDate(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.GERMANY)

        tVendDate.setText(sdf.format(myCalendar.time))

    }

}