package com.sebastianrpo.tallerdeldulce.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sebastianrpo.tallerdeldulce.R
import com.sebastianrpo.tallerdeldulce.ui.contact.ContactFragment
import com.sebastianrpo.tallerdeldulce.ui.notices.NoticesFragment

private val TAB_TITLES = arrayOf(
    R.string.tortas,
    R.string.postres,
    R.string.bebidas
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TortasFragment()
            1 -> PostresFragment()
            2 -> BebidasFragment()
            else -> TortasFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 3
    }
}