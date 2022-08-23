package com.udacity.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding:FragmentShoeDetailsBinding
    private val viewModel:ShoeViewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailsBinding.inflate(inflater,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.eventNavigateToShowList.observe(viewLifecycleOwner, Observer { navigate ->
            if(navigate){
                handleNavigateToShowList()
                viewModel.clearFields()
                viewModel.onDoneListNavigation()
            }
        })
    }

    private fun handleNavigateToShowList() {
        requireView().findNavController().navigateUp()
    }

    private fun onSaveClicked() {
        viewModel.onSaveShoeClicked()
    }
}