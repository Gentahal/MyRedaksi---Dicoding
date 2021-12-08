package com.example.myredaksi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myredaksi.adapter.RedaksiAdapter
import com.example.myredaksi.data.Redaksi
import com.example.myredaksi.data.RedaksiData
import com.example.myredaksi.databinding.ActivityMainBinding
import com.example.myredaksi.home.ProfileActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvList: RecyclerView
    private var list: ArrayList<Redaksi> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val btnProfileActivity: ImageView = findViewById(R.id.btn_profile)
        btnProfileActivity.setOnClickListener(this)

        rvList = findViewById(R.id.rv_list)
        rvList.setHasFixedSize(true)

        list.addAll(RedaksiData.listRedaksi)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvList.layoutManager = LinearLayoutManager(this)
        val listRedaksiAdapter = RedaksiAdapter(list)
        rvList.adapter = listRedaksiAdapter
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_profile -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}