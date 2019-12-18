package com.justplay.posit.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.justplay.posit.BuildConfig
import com.justplay.posit.R
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {

    companion object {
        const val USE_FRONT_CAMERA: String = "front_camera"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preference = requireContext().getSharedPreferences(
            BuildConfig.APPLICATION_ID,
            Context.MODE_PRIVATE
        )
        camers_toggle.isChecked = preference.getBoolean(USE_FRONT_CAMERA, false)
        camers_toggle.setOnCheckedChangeListener { _, isChecked ->
            preference.edit()
                .putBoolean(USE_FRONT_CAMERA, isChecked)
                .apply()
        }
    }
}
