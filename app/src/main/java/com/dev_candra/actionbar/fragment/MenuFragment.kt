package com.dev_candra.actionbar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dev_candra.actionbar.R

class MenuFragment: Fragment()
{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val teks : TextView = view.findViewById(R.id.teks1)
        teks.text = "Ini Adalah Menu 1"
    }

    /*
    Kesimpulan
     Terdapat lima kondisi yang dapat dipasang pada tag app:shoaction
    ifRoom, akan menampilkan action ketika ada ruangan pada action bar.
    withText, akan menampilkan action item beserta judulnya.
    never, tidak akan pernah ditampilkan pada action bar dan hanya akan ditampilkan pada overflow menu.
    always, akan selalu tampil pada action bar.
    collapseActionView, berhubungan dengan komponen collapsible .
     */
}