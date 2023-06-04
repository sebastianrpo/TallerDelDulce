package com.sebastianrpo.tallerdeldulce.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.sebastianrpo.tallerdeldulce.databinding.FragmentBebidasBinding
import com.sebastianrpo.tallerdeldulce.databinding.FragmentContactBinding
import com.sebastianrpo.tallerdeldulce.databinding.FragmentPostresBinding
import com.sebastianrpo.tallerdeldulce.databinding.FragmentTortasBinding
import com.sebastianrpo.tallerdeldulce.ui.contact.ContactViewModel

class BebidasFragment : Fragment() {

    private var _binding: FragmentBebidasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bebidasViewModel =
            ViewModelProvider(this)[BebidasViewModel::class.java]

        _binding = FragmentBebidasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBebidas
        bebidasViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}