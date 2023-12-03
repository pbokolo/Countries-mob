package com.kitoko.countries.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.kitoko.countries.databinding.FragmentMainBinding
import com.kitoko.countries.model.CountriesVM

class MainFragment : Fragment() {

    private var vBinder: FragmentMainBinding? = null
    private val sharedVM: CountriesVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        vBinder = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vBinder?.apply {
            viewModel = sharedVM
        }
    }


}