package com.example.datetimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.datetimepicker.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity(),DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    var day=0
    var month=0
    var year=0
    var hour=0
    var minute=0

    var savedDay=0
    var savedMonth=0
    var savedYear=0
    var savedHour=0
    var savedMinute=0


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            pickDate()
    }

    private fun pickDate() {
       binding.buttonTime.setOnClickListener {
           getDateTimeCalender()

            // Display DatePicker Dialog
           DatePickerDialog(this,this,year,month,day) .show()
       }
    }

    private fun getDateTimeCalender(){
        val cal:Calendar= Calendar.getInstance()
         day=cal.get(Calendar.DAY_OF_MONTH)
         month=cal.get(Calendar.MONTH)
         year=cal.get(Calendar.YEAR)
         hour=cal.get(Calendar.HOUR)
         minute=cal.get(Calendar.MINUTE)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                   savedDay=dayOfMonth
                    savedMonth=month
                    savedYear=year
        TimePickerDialog(this,this,hour,minute,true).show()

    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour=hourOfDay
        savedMinute=minute

        binding.textViewTime.text="$savedDay-$savedMonth-$savedYear\n Hour: $savedHour Minutes: $savedMinute"
    }
}