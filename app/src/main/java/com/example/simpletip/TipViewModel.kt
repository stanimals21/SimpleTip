package com.example.simpletip

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TipViewModel:ViewModel() {

    var billValue = MutableLiveData<Double>()
    var tipPercent = MutableLiveData<Double>()
    var numPeople = MutableLiveData<Int>()

    private var _totalCost = MutableLiveData<Double>()
    val totalCost: LiveData<Double>
        get() = _totalCost

    private var _costPerPerson = MutableLiveData<Double>()
    val costPerPerson: LiveData<Double>
        get() = _costPerPerson

    init{
        // initially set all values to 0
        _totalCost.value = 0.0
        _costPerPerson.value = 0.0
        billValue.value = 0.0
        tipPercent.value = 0.0
        numPeople.value = 1
    }

//    fun calculateValues{ TODO
//    }




}