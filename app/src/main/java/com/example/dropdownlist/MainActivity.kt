package com.example.dropdownlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvSelectedItem: TextView
    private lateinit var spinner:Spinner
    private val spinnerDropdownList:MutableList<String> =  mutableListOf()
    private lateinit var spinnerAdapter:ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spDropdownList)
        tvSelectedItem = findViewById(R.id.tvSelectedItem)

        prepareDataForSpinner()
        prepareSpinnerAdapter()
    }

    private fun prepareDataForSpinner(){
        for(i in 1 until 10){
            spinnerDropdownList.add("Item $i")
        }
    }
    private fun prepareSpinnerAdapter(){
        spinnerAdapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_spinner_dropdown_item,spinnerDropdownList)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tvSelectedItem.text = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}