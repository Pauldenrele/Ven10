package com.example.venten.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.venten.MainActivity
import com.example.venten.Model.venModel
import com.example.venten.R
import com.jakewharton.rxbinding.view.RxView
import kotlinx.android.synthetic.main.carowner_item.view.*

class listAdapter(var context: MainActivity, var mEmpList: ArrayList<venModel>, private val itemClick:ItemClickListener): RecyclerView.Adapter<listAdapter.listHolder>()  {

    companion object {
        var mItemClickListener : ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.carowner_item, parent, false)
        return listHolder(view)
    }

    override fun getItemCount(): Int {
        return mEmpList.size
    }

    override fun onBindViewHolder(holder:listHolder, position: Int) {
        mItemClickListener = itemClick
        holder.gender?.text = mEmpList[position].gender
        holder.startYear?.text = mEmpList[position].startYear.toString()
        holder.endyear?.text = mEmpList[position].endYear.toString()
        holder.list?.text = mEmpList[position].countries.toString()
        holder.colors?.text = mEmpList[position].colors.toString()


        RxView.clicks(holder.mView).subscribe {
            mItemClickListener!!.onItemClick(position)
        }
    }


    class listHolder (view: View) : RecyclerView.ViewHolder(view) {
        val gender = view.gender
        val list = view.listOfCars
        val mView = view
        val startYear = view.startyear
        val endyear = view.endYear
        val colors = view.color
    }

}