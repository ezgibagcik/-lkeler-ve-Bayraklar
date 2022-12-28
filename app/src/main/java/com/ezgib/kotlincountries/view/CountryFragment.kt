package com.ezgib.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ezgib.kotlincountries.R
import com.ezgib.kotlincountries.databinding.FragmentCountryBinding
import com.ezgib.kotlincountries.viewModel.CountryViewModel


class CountryFragment : Fragment() {


    private lateinit var viewModel:CountryViewModel

    private var countryUuId=0

    private lateinit var databinding: FragmentCountryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding= DataBindingUtil.inflate(inflater,R.layout.fragment_country,container,false)

        return databinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {

            countryUuId= CountryFragmentArgs.fromBundle(it).countryUuId

        }
        viewModel=ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuId)


        observeLiveData()

    }

    private fun observeLiveData()
    {
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country->

            country?.let {

                databinding.selectedCountry=it

            }
        })
    }
}