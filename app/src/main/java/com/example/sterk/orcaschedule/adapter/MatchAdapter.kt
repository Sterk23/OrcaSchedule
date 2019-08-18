package com.example.sterk.volleydemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sterk.orcaschedule.R
import com.example.sterk.orcaschedule.model.Match
import kotlinx.android.synthetic.main.item_match.view.*

/**
 * Created by sterk on 5/5/2019.
 */
class MatchAdapter(private val items: ArrayList<Match>?,
                   private val listener: MatchListener?) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_match,parent,false))
    }

    override fun getItemCount() = items!!.size
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bind(items!![position])
        holder.itemView.setOnClickListener{listener?.onItemClick()}
    }

    class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {
        fun bind(match: Match){
            itemView.apply {
                match_team2.text = match.team2
                match_date.text = match.date.substring(0,10)
                match_time.text = match.time.substring(11,19)
                match_tour.text = match.tour
                when(match.tour){
                    "otsc" ->{  team_logo.setImageDrawable(resources.getDrawable(R.mipmap.otsc))
                                team_logo_bg.setImageDrawable(resources.getDrawable(R.mipmap.otsc))
                    }
                    "otac" ->{  team_logo.setImageDrawable(resources.getDrawable(R.mipmap.otac))
                                team_logo_bg.setImageDrawable(resources.getDrawable(R.mipmap.otac))
                    }
                }

            }
        }
    }

}