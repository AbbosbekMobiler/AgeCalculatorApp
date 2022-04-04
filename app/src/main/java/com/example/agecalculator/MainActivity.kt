package com.example.agecalculator

import android.app.DatePickerDialog
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selectData(view: View) {
        var c = Calendar.getInstance()
        var cDay = c.get(Calendar.DAY_OF_MONTH)
        var cMonth = c.get(Calendar.MONTH)
        var cYear = c.get(Calendar.YEAR)

        val calendarDialog = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
            view,year,month,dayofMonth ->
            cDay = dayofMonth
            cMonth = month
            cYear = year
            calsi.visibility = View.VISIBLE
            calsi.setOnClickListener{
                val currentYear =   Calendar.getInstance().get(Calendar.YEAR)
                val age = currentYear-cYear
                showAge.visibility = View.VISIBLE
                showAge.text = "Sizning Yoshingiz $age yil"

            }
            selectDate.text = "Kiritgan kun : $cDay/${cMonth+1}/$cYear"
        },cYear,cMonth,cDay)
        calendarDialog.show()
    }
}