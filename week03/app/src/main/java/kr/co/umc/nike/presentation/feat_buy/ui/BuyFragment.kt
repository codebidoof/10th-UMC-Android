package kr.co.umc.nike.presentation.feat_buy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kr.co.umc.nike.R
import kr.co.umc.nike.databinding.FragmentBuyBinding

class BuyFragment : Fragment() {

    private var _binding: FragmentBuyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tblGoodsOnSale.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> childFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, AllGoodsFragment())
                        .commit()
                    1 -> {
                        childFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, TopsFragment())
                            .commit()
                    }
                    2 -> {
                        childFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, SaleFragment())
                            .commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}