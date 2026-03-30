package kr.co.umc.nike.presentation.feat_home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.umc.nike.databinding.ItemNewGoodBinding
import kr.co.umc.nike.presentation.feat_home.model.NewGood

class GoodsAdapter(private val goodsList: MutableList<NewGood>)
    : RecyclerView.Adapter<GoodsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GoodsViewHolder {
        val binding = ItemNewGoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GoodsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: GoodsViewHolder,
        position: Int
    ) {
        val nowGood = goodsList[position]
        holder.bind(nowGood)
    }

    override fun getItemCount(): Int = goodsList.size
}
