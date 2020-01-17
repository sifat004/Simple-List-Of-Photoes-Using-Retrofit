package com.sifatsdroid.practice

interface GenericCallbacks {
    fun onSuccess(vararg args: Any)
    fun onError(error: String)
}