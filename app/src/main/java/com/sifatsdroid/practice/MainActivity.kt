package com.sifatsdroid.practice

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var progerssProgressDialog: ProgressDialog
    var dataList = ArrayList<Photo>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:DataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)

        //setting up the adapter
        recyclerView.adapter= DataAdapter(dataList,this)
        recyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        progerssProgressDialog= ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()


        PhotoHelper.getPhotoes(object:GenericCallbacks{
            override fun onSuccess(vararg args: Any) {
                val list : ArrayList<Photo> = args[0] as ArrayList<Photo>
                progerssProgressDialog.dismiss()
                dataList.addAll(list)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onError(error: String) {
            }
        })
    }
}
