package com.sebastianrpo.tallerdeldulce.ui.carrito

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.sebastianrpo.tallerdeldulce.databinding.FragmentCarritoBinding

class CarritoFragment : Fragment() {

    private var _binding: FragmentCarritoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val carritoViewModel =
            ViewModelProvider(this)[CarritoViewModel::class.java]

        _binding = FragmentCarritoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCarrito
        carritoViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}