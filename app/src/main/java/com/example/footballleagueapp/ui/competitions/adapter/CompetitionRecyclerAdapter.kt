package com.example.footballleagueapp.ui.competitions.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.CompetitionsItem
import com.example.footballleagueapp.databinding.CompetitionItemBinding

class CompetitionRecyclerAdapter(private var competitions: List<CompetitionsItem?>?) :
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
        val oldSize = this.competitions?.size ?: 0
        this.competitions = competitions
        notifyItemRangeInserted(oldSize, this.competitions!!.size)
    }

    override fun getItemCount(): Int = competitions?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(competitions?.get(position))
        onItemClick?.let { onItemClick ->
            holder.itemBinding.root.setOnClickListener {
                onItemClick.onClick(position, competitions?.get(position))
            }
        }
    }

    var onItemClick: OnItemClick? = null

    fun interface OnItemClick {
        fun onClick(position: Int, competition: CompetitionsItem?)
    }
}