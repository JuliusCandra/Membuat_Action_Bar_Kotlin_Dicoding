package com.dev_candra.actionbar.acitivities

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dev_candra.actionbar.R
import com.dev_candra.actionbar.fragment.MenuFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar()
    }
// membuat sebuah menu di activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as androidx.appcompat.widget.SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
        override fun onQueryTextSubmit(query: String?): Boolean {
            if (query != null){
                makeToast(query)
            }else{
                makeToast(resources.getString(R.string.search_hint))
            }
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            if (newText != null){
                makeToast(newText)
            }else{
                makeToast(resources.getString(R.string.search_hint))
            }
            return true
        }

    })
    return true
    }

    // mengaktifkn mneu yang diminta
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        selectedItem(item.itemId)
        return true
    }

 // memilih dan membuat aksi menu
    private fun selectedItem(item : Int){
        when(item){
            R.id.menu1 -> {
            selectFragment(MenuFragment())
            }
            R.id.menu2 -> {
                val intent = Intent(this,com.dev_candra.actionbar.acitivities.Menu::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    // membuat sebuah fragment
    private fun selectFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.containerFragment,fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun setActionBar(){
        supportActionBar?.title = "Candra Julius Sinaga"
        supportActionBar?.subtitle = "ActionBar"
    }
    private fun makeToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}