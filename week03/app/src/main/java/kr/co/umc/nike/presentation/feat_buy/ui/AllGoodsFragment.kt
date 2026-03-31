package kr.co.umc.nike.presentation.feat_buy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import kr.co.umc.nike.R
import kr.co.umc.nike.databinding.FragmentAllGoodsBinding
import kr.co.umc.nike.presentation.feat_buy.adapter.GoodsRVAdapter
import kr.co.umc.nike.presentation.feat_buy.adapter.GoodsRVDecorator
import kr.co.umc.nike.presentation.feat_buy.model.Good

class AllGoodsFragment : Fragment() {

    private var _binding: FragmentAllGoodsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: GoodsRVAdapter
    private lateinit var decorator: GoodsRVDecorator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllGoodsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDummyData()
    }
    private fun setDummyData() {
        val goodsList = mutableListOf(
            Good(
                R.drawable.img_mid_socks,
                false,
                "Nike Everyday Plus Cushioned",
                "Training Ankle Socks (6 Pairs)",
                "5 Colours",
                "US$10"
            ),
            Good(
                R.drawable.img_elite_crew,
                false,
                "Nike Elite Crew",
                "Basketball Socks",
                "7 Colours",
                "US$16"
            ),
            Good(
                R.drawable.img_air_force_107,
                true,
                "Nike Air Force 1 '07",
                "Women's Shoes",
                "5 Colours",
                "US$115"
            ),
            Good(
                R.drawable.img_air_force_essential,
                true,
                "Jordan ENike Air Force 1 '07ssentials",
                "Men's Shoes",
                "2 Colours",
                "US$115"
            ),
        )

        adapter = GoodsRVAdapter()
        decorator = GoodsRVDecorator()

        binding.rvGoods.apply {
            adapter = this@AllGoodsFragment.adapter
            layoutManager = GridLayoutManager(context, 2, VERTICAL, false)
            addItemDecoration(decorator)
        }

        adapter.submitList(goodsList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
