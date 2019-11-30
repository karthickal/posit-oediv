package com.justplay.posit.video_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.justplay.posit.R

class LiveVideoFragment : Fragment() {

    companion object {
        fun newInstance() = LiveVideoFragment()
    }

    private val viewModel: LiveVideoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.live_video_fragment, container, false)
    }

}
