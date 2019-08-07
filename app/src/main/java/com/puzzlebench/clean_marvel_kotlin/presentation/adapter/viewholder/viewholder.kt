package com.puzzlebench.clean_marvel_kotlin.presentation.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.getImageByUrl
import com.puzzlebench.clean_marvel_kotlin.presentation.listener.CharacterListener
import kotlinx.android.synthetic.main.character_cards_layout.view.*


class CharactersAdapterViewHolder(view: View, val listener: CharacterListener) : RecyclerView.ViewHolder(view) {

    fun bind(item: Character) = with(itemView) {
        tv_item.text = item.name
        val thumbnaiPath = item.thumbnail.path
        val thumbnailExtension = item.thumbnail.extension
        val thumbnailUrl = "$thumbnaiPath.$thumbnailExtension"
        image_thumbnail.getImageByUrl(thumbnailUrl)
        setOnClickListener { listener(item) }
    }
}