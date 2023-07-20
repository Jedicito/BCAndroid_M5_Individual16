package chl.ancud.m5_individual16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import chl.ancud.m5_individual16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }

    private fun initAdapter() {
        val adapter = Adapter()
        adapter.setData(PaisesLatam.paises)
        binding.mainRv.adapter = adapter
    }


}