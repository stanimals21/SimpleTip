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

    private var _totalTip = MutableLiveData<Double>()
    val totalTip: LiveData<Double>
        get() = _totalTip

    init{
        // initially set all values to 0
        _totalCost.value = 0.0
        _totalTip.value = 0.0
        billValue.value = 0.0
        tipPercent.value = 0.15
        numPeople.value = 1
    }

    // TODO: test for correctness and possible crashes
    fun calculateValues(){
       _totalTip.value = tipPercent.value?.let { billValue.value?.times(it) }
       _totalCost.value = _totalCost.value?.let { _totalTip.value?.plus(it) }
    }




}