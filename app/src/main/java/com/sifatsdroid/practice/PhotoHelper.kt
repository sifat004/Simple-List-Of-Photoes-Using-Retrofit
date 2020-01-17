package com.sifatsdroid.practice

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PhotoHelper {
    fun getPhotoes(callbacks: GenericCallbacks){
        val call: Call<List<Photo>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<Photo>> {

            override fun onResponse(call: Call<List<Photo>>?, response: Response<List<Photo>>?) {
                callbacks.onSuccess(response!!.body()!!)
            }

            override fun onFailure(call: Call<List<Photo>>?, t: Throwable?) {
                callbacks.onError(t.toString())
            }

        })
    }
}