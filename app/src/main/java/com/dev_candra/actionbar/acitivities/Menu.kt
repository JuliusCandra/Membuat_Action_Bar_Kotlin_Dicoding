package com.dev_candra.actionbar.acitivities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dev_candra.actionbar.R

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        supportActionBar?.title = "Candra Julius Sinaga"
        supportActionBar?.subtitle = "Menu 2"
    }
}