package com.route.basicsc39

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.basicsc39.databinding.ActivityFragmentBasicsBinding

class FragmentBasicsActivity: AppCompatActivity() {
    lateinit var binding: ActivityFragmentBasicsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBasicsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment(),"")

            .commit()
        initListeners()
    }

    private fun initListeners() {
        binding.homeTv.setOnClickListener{
           supportFragmentManager.beginTransaction()
               .add(R.id.fragmentContainer, HomeFragment(),"")
               .addToBackStack("")
               .commit()
        }
        binding.settingsTv.setOnClickListener{
            var settings = SettingsFragment()
            settings.show(supportFragmentManager, "")
        }
    }
}