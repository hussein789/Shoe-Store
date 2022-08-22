package com.udacity.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShowListBinding
import com.udacity.shoestore.databinding.ShowItemLayoutBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private lateinit var binding:FragmentShowListBinding
    private val viewModel:ShoeViewModel by activityViewModels<ShoeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowListBinding.inflate(inflater,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout_action -> {
                requireView().findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
                viewModel.clearList()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showList.observe(viewLifecycleOwner, Observer { showList ->
            showList?.let { handleShowList(it) }
        })
        viewModel.eventNavigateToShoeDetails.observe(viewLifecycleOwner, Observer { navigate ->
            if(navigate){
                handleNavigationToDetails()
                viewModel.onDoneDetailsNavigation()
            }
        })
    }

    private fun handleNavigationToDetails() {
        requireView().findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateList()
    }

    private fun handleShowList(showList: List<Shoe>) {
        binding.itemsContainer.removeAllViews()
        showList.forEach {
            val layout = ShowItemLayoutBinding.inflate(layoutInflater,binding.itemsContainer,true)
            layout.model = it
            layout.invalidateAll()
        }
    }

}