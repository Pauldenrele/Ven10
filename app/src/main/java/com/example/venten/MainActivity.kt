package com.example.venten

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.kotlinmvvm.interfaces.ItemClickListener
import com.example.venten.Adapter.listAdapter
import com.example.venten.Model.venModel
import com.example.venten.ViewModel.venViewModel
import com.example.venten.utils.Coroutines
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        linearLayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.hasFixedSize()

       // getlistofCarOwners()

        Coroutines.main{
            getlistOwners()
        }

    }


    private fun  getlistofCarOwners() {
        Log.e("getlistOfCarowners","yes")



        val mAndroidViewModel = ViewModelProviders.of(this@MainActivity).get(venViewModel::class.java)
        mAndroidViewModel.getListData()?.observe(this, Observer<List<venModel>> { androidList ->

            Log.e("list",androidList?.size.toString())
            recyclerView.adapter = listAdapter(this@MainActivity, androidList as ArrayList<venModel>, object :
                ItemClickListener {
                override fun onItemClick(pos: Int) {
                    Toast.makeText(applicationContext, "item $pos clicked", Toast.LENGTH_LONG).show()
                }
            })
        })

    }

    private suspend fun  getlistOwners() {
        Log.e("getlistOfCarowners","yes")



        val mAndroidViewModel = ViewModelProviders.of(this@MainActivity).get(venViewModel::class.java)
        mAndroidViewModel.getList()?.observe(this, Observer<List<venModel>> { androidList ->

            Log.e("list",androidList?.size.toString())
            recyclerView.adapter = listAdapter(this@MainActivity, androidList as ArrayList<venModel>, object :
                ItemClickListener {
                override fun onItemClick(pos: Int) {
                    Toast.makeText(applicationContext, "item $pos clicked", Toast.LENGTH_LONG).show()
                }
            })
        })

    }
}
