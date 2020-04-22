package com.candy.caishenaccountbook.home.ui.me

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.candy.caishenaccountbook.R
import com.candy.caishenaccountbook.base.WebActivity

class MeAdapter : RecyclerView.Adapter<MeAdapter.CommonItemViewHolder>() {

    override fun onBindViewHolder(holder: CommonItemViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonItemViewHolder {
        return CommonItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_me_common, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    class CommonItemViewHolder(view : View) : RecyclerView.ViewHolder (view) {
        init {
            val title = view.findViewById<TextView>(R.id.title)
            val container = view.findViewById<ConstraintLayout>(R.id.item_container)
            container.setOnClickListener { v -> WebActivity.start(v.context) }
        }
    }
}