package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var viewModel: WelcomeViewModel
    private lateinit var binding:FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = WelcomeFragmentArgs.fromBundle(requireArguments())
        viewModel.init(args.emailField)
        viewModel.eventNavigateToInstruction.observe(viewLifecycleOwner, Observer { navigate ->
            if(navigate){
                navigateToInstructionScreen()
                viewModel.onDoneNavigation()
            }
        })
    }

    private fun navigateToInstructionScreen() {
        requireView().findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
    }

}