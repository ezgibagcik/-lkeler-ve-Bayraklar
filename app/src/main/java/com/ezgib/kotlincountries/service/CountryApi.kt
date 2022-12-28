package com.ezgib.kotlincountries.service

import com.ezgib.kotlincountries.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryApi {
    //Ext->atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries():Single<List<Country>>



    //Single sadece bir defa alır ve bu işi yapar,bir defa alıp garanti bir şekilde almamız gerekiyorsa
    //Observable durmadan devamlı internetten verileri alır ,,devamlı veri almamız gerekiyosa
}