package kr.co.umc.nike.presentation.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.umc.nike.databinding.FragmentProfileBinding
import kr.co.umc.nike.presentation.profile.adapter.ProfileRVAdapter
import kr.co.umc.nike.presentation.profile.adapter.ProfileRVDecorator
import kr.co.umc.nike.presentation.profile.model.Profile
import timber.log.Timber

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var profileRVAdapter: ProfileRVAdapter
    private lateinit var profileRVDecorator: ProfileRVDecorator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        profileRVAdapter = ProfileRVAdapter()
        profileRVDecorator = ProfileRVDecorator(16)

        binding.rvFollowingUsers.apply {
            adapter = profileRVAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(profileRVDecorator)
        }
        // 더미 데이터 (API 연동 전 테스트용)
        val dummyList = List(5) { i ->
            Profile(id = i, email = "", name = "", avatar = "")
        }
        profileRVAdapter.submitList(dummyList)
        Timber.d("리사이클러뷰 세팅 완료")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}