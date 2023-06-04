package com.sebastianrpo.tallerdeldulce.ui.notices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.sebastianrpo.tallerdeldulce.R
import com.sebastianrpo.tallerdeldulce.databinding.FragmentNoticesBinding

class NoticesFragment : Fragment() {

    private var _binding: FragmentNoticesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val noticesViewModel =
            ViewModelProvider(this)[NoticesViewModel::class.java]

        _binding = FragmentNoticesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotices
        noticesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}