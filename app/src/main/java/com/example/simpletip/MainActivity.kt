package com.example.simpletip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simpletip.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.view.bill_value

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(TipViewModel::class.java)

        binding.lifecycleOwner = this
        binding.tipViewModel = viewModel

        binding.calculateBtn.setOnClickListener(){
            if(binding.numPeopleValue.text.toString().toInt() <= 0){
                Toast.makeText(this, "# Of People must be at least 1", Toast.LENGTH_SHORT).show()
            }
            else {
                viewModel.billValue.value = binding.billValue.text.toString().toDouble()
                viewModel.tipPercent.value = binding.tipPercentValue.text.toString().toDouble()
                viewModel.numPeople.value = binding.numPeopleValue.text.toString().toInt()
                viewModel.calculateValues()
            }
        }

    }
}