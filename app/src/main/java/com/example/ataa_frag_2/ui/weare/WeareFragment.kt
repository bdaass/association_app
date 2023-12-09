package com.example.ataa_frag_2.ui.weare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ataa_frag_2.R
import com.example.ataa_frag_2.databinding.FragmentDashboardBinding
import com.example.ataa_frag_2.databinding.FragmentWeareBinding
import com.example.ataa_frag_2.ui.contact.ContactViewModel

class WeareFragment : Fragment() {

    private var _binding: FragmentWeareBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeareBinding.inflate(inflater, container, false)
        val view = binding.root
        val titleTextView = binding.weareDescription
        titleTextView.text = "Text about the association"
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
