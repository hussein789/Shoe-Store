package com.udacity.shoestore.screens.instructions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var viewModel: InstructionsViewModel
    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.eventNavigateToShowList.observe(viewLifecycleOwner, Observer { navigate ->
            if (navigate) {
                navigateToShowListScreen()
                viewModel.onDoneNavigation()
            }
        })
    }

    private fun navigateToShowListScreen() {
        requireView().findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment())
    }
}

