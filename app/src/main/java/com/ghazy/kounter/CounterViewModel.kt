package com.ghazy.kounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val _result = MutableLiveData("")
    val result: LiveData<String> = _result

    private val _scoreA = MutableLiveData<Int>(0)
    val scoreA : LiveData<Int> = _scoreA

    private val _scoreB = MutableLiveData<Int>(0)
    val scoreB : LiveData<Int> = _scoreB

    fun addOne(isTeamA: Boolean) {
        if (isTeamA) {
            _scoreA.value = _scoreA.value?.plus(1)
        } else {
            _scoreB.value = _scoreB.value?.plus(1)
        }
        checkResult()
    }

    fun addTwo(isTeamA: Boolean) {
        if (isTeamA) {
            _scoreA.value = _scoreA.value?.plus(2)
        } else {
            _scoreB.value = _scoreB.value?.plus(2)
        }
        checkResult()
    }

    fun resetScore() {
        _scoreA.value = 0
        _scoreB.value = 0
    }

    fun checkResult() {
        if (_scoreA.value!! > 10) {
            _result.value = "Team A Menang"
            resetScore()
        } else if (_scoreB.value!! > 10) {
            _result.value = "Team B Menang"
            resetScore()
        } else {
            _result.value = ""
        }
    }
}