package com.example.mytourguideapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.mytourguideapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    var categoryAdapter: CategoryAdapter? = null
    var tabLayout: TabLayout? = null
    var viewPager2: ViewPager2? = null

    private lateinit var binding : ActivityMainBinding
    private val titles = arrayOf("Mountains", "Cities", "Islands", "Seas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewPager2 = binding.viewPager
        tabLayout = binding.tabLayout
        categoryAdapter = CategoryAdapter(this)

        //set adapter viewpager
        viewPager2!!.adapter = categoryAdapter
        TabLayoutMediator(
            tabLayout!!,
            viewPager2!!
        ) { tab: TabLayout.Tab, position: Int -> tab.text = titles[position] }.attach()
    }
}