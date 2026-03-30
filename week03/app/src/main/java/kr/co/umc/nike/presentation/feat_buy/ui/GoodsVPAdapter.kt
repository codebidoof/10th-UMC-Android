package kr.co.umc.nike.presentation.feat_buy.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class GoodsVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllGoodsFragment()
            1 -> TopsFragment()
            2 -> SaleFragment()
            else -> AllGoodsFragment()
        }
    }

    override fun getItemCount(): Int = 3

}