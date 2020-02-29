package com.example.venten

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.venten.adapter.OwnersAdapter
import com.example.venten.databinding.ActivityCarOwnersBinding
import com.example.venten.models.CarOwners
import com.example.venten.models.VenModel
import com.example.venten.viewModel.CarOwnersViewModel
import com.opencsv.CSVReader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import java.io.File
import java.io.FileReader


class CarOwnersListActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCarOwnersBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_car_owners)

        val filter : VenModel = intent.extras!!.getParcelable("filter")!!
        val recyclerView = binding.recyclerView
        val adapter =  OwnersAdapter()
        recyclerView.adapter = adapter

        val viewModel = ViewModelProvider(this).get(CarOwnersViewModel::class.java)



        viewModel.getCarOwnersByFilter(filter).observe(this, Observer {
            it?.let {
                if (it.isNullOrEmpty()) {
                    binding.noResult.visibility = View.VISIBLE
                } else {
                    binding.noResult.visibility = View.GONE
                    adapter.submitList(it)
                }
            }
        })


        viewModel.progress.observe(this, Observer {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })
    }

}
