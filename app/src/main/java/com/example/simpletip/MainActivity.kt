package com.example.simpletip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simpletip.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(TipViewModel::class.java)

        binding.lifecycleOwner = this
        binding.tipViewModel = viewModel

// TODO: implement observers for tipViewModel members
        viewModel.billValue.observe(this, Observer {

        })
        viewModel.tipPercent.observe(this, Observer {

        })
        viewModel.numPeople.observe(this, Observer {

        })

    }
}