package com.bcit.kotlinflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bcit.kotlinflow.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    var _binding: FragmentUserBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUserBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val str = "Good night"
        binding.textViewUsers.text = str

        val viewModel: UserViewModel by activityViewModels()
        binding.myViewModel = viewModel

        viewModel.currentUser.value = User("111", "Blimey", "https://tinyjpg.com/images/social/website.jpg")

        binding.buttonUsers.setOnClickListener{
            viewModel.currentUser.value = User("112", "TestUser", "https://tinypng.com/images/smart-resizing/new-aspect-ratio.jpg")
        }

        val userObserver = Observer<List<User>>{ users ->
            println(users.size)
        }

        viewModel.allUsers.observe(viewLifecycleOwner, userObserver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // kill the bindings with fragment so no mem leak
        _binding = null
    }
}