package com.example.randomuser.ui.details_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.randomuser.R
import com.example.randomuser.databinding.FragmentDetailsBinding
import com.example.randomuser.framework.BaseFragment
import com.example.randomuser.model.User

class DetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args by navArgs<DetailsFragmentArgs>()
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user = args.user
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.apply {
            if (user != null) {
                Glide.with(requireActivity()).load(user?.picture?.large)
                    .placeholder(R.drawable.ic_girl_profile)
                    .error(R.drawable.ic_girl_profile).into(binding.profileImage)

                tvUserName.text = user?.name
                tvGender.text = String.format("Gender: %s", user?.gender?.name)
                tvAddress.text = String.format("Address: %s", user?.location?.address)
            }
        }
    }
}