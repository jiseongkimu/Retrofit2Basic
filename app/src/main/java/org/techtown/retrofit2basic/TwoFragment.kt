package org.techtown.retrofit2basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.techtown.retrofit2basic.databinding.FragmentTab2Binding

class TwoFragment : Fragment() {
    lateinit var binding : FragmentTab2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTab2Binding.inflate(inflater, container, false)
        return binding.root
    }
}