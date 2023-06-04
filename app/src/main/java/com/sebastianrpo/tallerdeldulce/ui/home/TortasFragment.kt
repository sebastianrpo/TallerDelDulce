package com.sebastianrpo.tallerdeldulce.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.sebastianrpo.tallerdeldulce.databinding.FragmentContactBinding
import com.sebastianrpo.tallerdeldulce.databinding.FragmentTortasBinding
import com.sebastianrpo.tallerdeldulce.ui.contact.ContactViewModel

class TortasFragment : Fragment() {

    private var _binding: FragmentTortasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tortasViewModel =
            ViewModelProvider(this)[TortasViewModel::class.java]

        _binding = FragmentTortasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTortas
        tortasViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}