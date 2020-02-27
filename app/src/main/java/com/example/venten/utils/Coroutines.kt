package com.example.venten.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//Higher order functions
//LAMBDA Functions

//This function is taking another function as another param and we are executing that function
//Putting that function inside another fun to execute it
object Coroutines {
    fun main(work: suspend (() -> Unit) ) =
        CoroutineScope(Dispatchers.Main).launch {
                     work()
        }
}