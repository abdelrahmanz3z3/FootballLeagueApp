package com.example.footballleagueapp.ui.competition.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.footballleagueapp.databinding.CompetitionItemBinding
import com.example.footballleagueapp.datasource.model.CompetitionsItem

class CompetitionRecyclerAdapter(private var competitions: List<CompetitionsItem?>) :
    RecyclerView.Adapter<CompetitionRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val itemBinding: CompetitionItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(competition: CompetitionsItem?) {
            itemBinding.competition = competition
            itemBinding.invalidateAll()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            CompetitionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    fun bindNewList(competitions: List<CompetitionsItem?>) {
        this.competitions = competitions
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = competitions.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(competitions[position])
        onItemClick?.let { onItemClick ->
            holder.itemBinding.root.setOnClickListener {
                onItemClick.onClick(position, competitions[position])
            }
        }
    }

    var onItemClick: OnItemClick? = null

    fun interface OnItemClick {
        fun onClick(position: Int, competition: CompetitionsItem?)
    }
}