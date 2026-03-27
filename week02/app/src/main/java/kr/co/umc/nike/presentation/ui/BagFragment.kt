package kr.co.umc.nike.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navOptions
import androidx.navigation.fragment.findNavController
import kr.co.umc.nike.R
import kr.co.umc.nike.databinding.FragmentBagBinding

class BagFragment : Fragment() {

    private var _binding: FragmentBagBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBagBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpClickListener()
    }

    private fun setUpClickListener() {
        binding.apply {
            btnOrder.setOnClickListener {
                findNavController().navigate(
                    R.id.menu_buy,
                    null,
                    navOptions {
                        popUpTo(R.id.menu_bag) { inclusive = true }
                    }
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
