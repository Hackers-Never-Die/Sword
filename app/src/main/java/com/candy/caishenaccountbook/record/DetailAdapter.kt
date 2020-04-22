package com.candy.caishenaccountbook.record

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.candy.caishenaccountbook.R
import com.candy.caishenaccountbook.bean.Record
import kotlinx.coroutines.newFixedThreadPoolContext

class DetailAdapter() : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    val list : List<Record> = ArrayList()

    fun addData(data : List<Record>) {

    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class DetailViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    }
}