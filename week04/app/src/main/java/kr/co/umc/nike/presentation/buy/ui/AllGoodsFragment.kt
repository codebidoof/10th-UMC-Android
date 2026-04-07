package kr.co.umc.nike.presentation.buy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kr.co.umc.nike.R
import kr.co.umc.nike.databinding.FragmentAllGoodsBinding
import kr.co.umc.nike.presentation.buy.adapter.GoodsRVAdapter
import kr.co.umc.nike.presentation.buy.adapter.GoodsRVDecorator
import kr.co.umc.nike.presentation.buy.model.Good
import kr.co.umc.nike.presentation.buy.viewmodel.GoodsViewModel
import kr.co.umc.nike.presentation.util.UiState

@AndroidEntryPoint
class AllGoodsFragment : Fragment() {

    private val viewModel: GoodsViewModel by viewModels()
    private var _binding: FragmentAllGoodsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: GoodsRVAdapter
    private lateinit var decorator: GoodsRVDecorator

    private val spanCount: Int = 2
    private val space: Int = 16

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllGoodsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //setDummyData()
        setRecyclerView()
        observeGoodsState()
    }

    private fun setRecyclerView() {
        adapter = GoodsRVAdapter()
        decorator = GoodsRVDecorator(spanCount, space)

        binding.rvGoods.apply {
            adapter = this@AllGoodsFragment.adapter
            layoutManager = GridLayoutManager(context, 2, VERTICAL, false)
            addItemDecoration(decorator)
        }
    }

    private fun observeGoodsState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.goodsState.collect { state ->
                when (state) {
                    is UiState.Idle -> {
                        //초기 상태, 아무것도 안함
                    }
                    is UiState.Loading -> {
                        // 추후 ProgressBar 삽입
                    }
                    is UiState.Success -> {
                        adapter.submitList(state.data)
                    }
                    is UiState.Error -> {
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }
    }
//    private fun setDummyData() {
//        val goodsList = mutableListOf(
//            Good(
//                goodImage = R.drawable.img_mid_socks,
//                isWished = true,
//                isBestSeller = false,
//                goodName = "Nike Everyday Plus Cushioned",
//                goodDescription = "Training Ankle Socks (6 Pairs)",
//                colorDescription = "5 Colours",
//                goodPrice = "US$10"
//            ),
//            Good(
//                goodImage = R.drawable.img_elite_crew,
//                isWished = false,
//                isBestSeller = false,
//                goodName = "Nike Elite Crew",
//                goodDescription = "Basketball Socks",
//                colorDescription = "7 Colours",
//                goodPrice = "US$16"
//            ),
//            Good(
//                goodImage = R.drawable.img_air_force_107,
//                isWished = false,
//                isBestSeller = true,
//                goodName = "Nike Air Force 1 '07",
//                goodDescription = "Women's Shoes",
//                colorDescription = "5 Colours",
//                goodPrice = "US$115"
//            ),
//            Good(
//                goodImage = R.drawable.img_air_force_essential,
//                isWished = false,
//                isBestSeller = true,
//                goodName = "Jordan ENike Air Force 1 '07ssentials",
//                goodDescription = "Men's Shoes",
//                colorDescription = "2 Colours",
//                goodPrice = "US$115"
//            ),
//        )
//
//        adapter = GoodsRVAdapter()
//        decorator = GoodsRVDecorator(spanCount, space)
//
//        binding.rvGoods.apply {
//            adapter = this@AllGoodsFragment.adapter
//            layoutManager = GridLayoutManager(context, 2, VERTICAL, false)
//            addItemDecoration(decorator)
//        }
//
//        adapter.submitList(goodsList)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
