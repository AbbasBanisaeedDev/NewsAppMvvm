package github.abbasbanisaeed.newsappmvvmdark.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import github.abbasbanisaeed.newsappmvvmdark.R
import github.abbasbanisaeed.newsappmvvmdark.ui.NewsActivity
import github.abbasbanisaeed.newsappmvvmdark.ui.NewsViewModel
import github.abbasbanisaeed.newsappmvvmdark.util.PrefHelper
import kotlinx.android.synthetic.main.fragment_setting_.*


class Setting_Fragment : Fragment(R.layout.fragment_setting_) {

    lateinit var viewModel: NewsViewModel
    private val pref by lazy {
        PrefHelper(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        switch_dark.setOnCheckedChangeListener { compoundButton, isChecked ->
            when (isChecked) {
                true -> {
                    pref.put("pref_is_dark_mode", true)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                false -> {
                    pref.put("pref_is_dark_mode", false)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }

            }

        }

    }


}