package com.example.randomuser.ui.list_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.randomuser.R
import com.example.randomuser.databinding.FragmentListBinding
import com.example.randomuser.framework.BaseFragment
import com.example.randomuser.model.Gender
import com.example.randomuser.model.Resource
import com.example.randomuser.model.User
import com.example.randomuser.ui.adapter.UserListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment(), UserListAdapter.Listener {

    private lateinit var binding: FragmentListBinding
    private val viewModel by viewModels<ListViewModel>()
    private var isLoading = false
    private var adapter: UserListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()

        setupRecyclerView()

        setupObserver()

        viewModel.getUsers(gender = Gender.ANY, size = 0)

    }

    private fun setupRecyclerView() {
        adapter = UserListAdapter()
        adapter?.setListener(this)
        binding.recyclerUsers.adapter = adapter
        binding.recyclerUsers.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                val size = adapter?.itemCount ?: 0
                if (!isLoading
                    && !recyclerView.canScrollVertically(1)
                ) {
                    viewModel.getUsers(gender = Gender.ANY, size = size)
                }
            }
        })

    }

    private fun setupObserver() {
        viewModel.users.observe(viewLifecycleOwner) { bindResource(it) }
    }

    private fun bindResource(resource: Resource<List<User>>) {
        when (resource) {
            is Resource.Loading -> if (!isLoading) isLoading = true
            is Resource.Error -> {
                if (isLoading) isLoading = false
            }
            is Resource.Success -> bindListResult(resource.data)
        }
    }

    private fun bindListResult(result: List<User>? = null) {
        if (isLoading) isLoading = false
        adapter?.updateData(result)
    }

    override fun onViewProfileClicked(user: User) {
        findNavController().navigate(
            ListFragmentDirections.navigateFromListScreenToDetailScreen(
                user
            )
        )
    }
}