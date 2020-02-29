package com.example.venten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.kotlinmvvm.interfaces.ItemClickListener
import com.example.venten.adapter.listAdapter
import com.example.venten.models.CarOwners
import com.example.venten.models.VenModel
import com.example.venten.viewModel.venViewModel
import com.example.venten.utils.Coroutines
import com.opencsv.CSVReader
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.nio.charset.Charset
import java.util.*
import java.util.concurrent.Executors
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_ASK_PERMISSIONS = 123

    private lateinit var linearLayoutManager: LinearLayoutManager

    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.hasFixedSize()

        Coroutines.main {
            getlistOwners()
        }




    }


    private suspend fun  getlistOwners() {
        Log.e("getlistOfCarowners","yes")


        val mAndroidViewModel = ViewModelProviders.of(this@MainActivity).get(venViewModel::class.java)
        mAndroidViewModel.getListData()?.observe(this, Observer<List<VenModel>> { androidList ->

            Log.e("list",androidList?.size.toString())
            recyclerView.adapter = listAdapter(this@MainActivity, androidList as ArrayList<VenModel>, object :
                ItemClickListener {
                override fun onItemClick(venModel: VenModel) {
                   val i = Intent(this@MainActivity, CarOwnersListActivity::class.java)
                    i.putExtra("filter", venModel )

                    startActivity(i)
                }
            })
        })

    }



}
