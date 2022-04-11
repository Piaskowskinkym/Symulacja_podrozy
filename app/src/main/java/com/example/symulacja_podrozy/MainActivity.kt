package com.example.symulacja_podrozy

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var tVstartDate : TextView
    private lateinit var tVmiddleDate : TextView
    private lateinit var tVendDate : TextView
    private lateinit var  seekBar : SeekBar
    private  lateinit var  editTextSeconds : EditText
    var lastSeekBarValue = 0
    var seconds = 1.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         tVstartDate = findViewById(R.id.tVstartDate)
         tVmiddleDate= findViewById(R.id.tVmiddleDate)
         tVendDate = findViewById(R.id.tVendDate)
        seekBar = findViewById(R.id.seekBar)
        editTextSeconds = findViewById(R.id.editTextSeconds)

        seekBar.setOnSeekBarChangeListener(object :   SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (seekBar.progress > lastSeekBarValue){
                    seconds += 0.5
                    editTextSeconds.setText(seconds.toString())
                    lastSeekBarValue = seekBar.progress
                }else if(seekBar.progress < lastSeekBarValue){
                    seconds -= 0.5
                    editTextSeconds.setText(seconds.toString())
                    lastSeekBarValue = seekBar.progress
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
        })
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

        tVmiddleDate.setText(sdf.format(myCalendar.time))

    }
    private fun updatetVendDate(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.GERMANY)

        tVendDate.setText(sdf.format(myCalendar.time))

    }

}