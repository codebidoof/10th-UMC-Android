package kr.co.umc.nike.presentation.xml.buy.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import kr.co.umc.nike.presentation.xml.buy.ui.AllGoodsFragment
import kr.co.umc.nike.presentation.xml.buy.ui.SaleFragment
import kr.co.umc.nike.presentation.xml.buy.ui.TopsFragment

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