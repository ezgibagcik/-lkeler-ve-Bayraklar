package com.ezgib.kotlincountries.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ezgib.kotlincountries.model.Country
import com.ezgib.kotlincountries.service.CountryDatabase
import kotlinx.coroutines.launch

class CountryViewModel(application: Application):BaseViewModel(application) {
    val countryLiveData=MutableLiveData<Country>()

    fun getDataFromRoom(uuid:Int)
    {

        launch {
            val dao=CountryDatabase(getApplication()).countryDao()
            val country=dao.getCountry(uuid)
            countryLiveData.value=country
        }

    }
}