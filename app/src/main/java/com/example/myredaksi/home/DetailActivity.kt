package com.example.myredaksi.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.myredaksi.MainActivity
import com.example.myredaksi.R
import com.example.myredaksi.data.Redaksi
import com.example.myredaksi.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(),View.OnClickListener {

    private var _binding:ActivityDetailBinding? = null
    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val btnBack : ImageButton = findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)

        val redaksi = intent.getParcelableExtra<Redaksi>(DATA_REDAKSI)

        val gambarData = intent.getIntExtra(EXTRA_GMBR,0)
        val detailData = intent.getStringExtra(EXTRA_DETAIL)
        val namaData = intent.getStringExtra(EXTRA_NAMA)
        val sumberData = intent.getStringExtra(EXTRA_SUMBER)
        val sumberBerita = intent.getStringExtra(EXTRA_SMBR)
        val isiBerita = intent.getStringExtra(EXTRA_ISI)

        if (redaksi != null){
            binding.imgDetail.setImageResource(redaksi.gambar)
            binding.tvDataJudul.text = redaksi.nama
            binding.tvIsiBerita.text = redaksi.detail
            binding.tvSumberBerita.text = redaksi.sumber
            binding.tvSumber.text = redaksi.smbr
            binding.tvIsi.text = redaksi.isi
        }else{
            binding.imgDetail.setImageResource(gambarData)
            binding.tvDataJudul.text = namaData
            binding.tvIsiBerita.text = detailData
            binding.tvSumberBerita.text = sumberData
            binding.tvSumber.text = sumberBerita
            binding.tvIsi.text = isiBerita
        }
    }


    companion object{
        const val DATA_REDAKSI = "redaksi"
        const val EXTRA_GMBR = "gambar"
        const val EXTRA_NAMA = "nama"
        const val EXTRA_DETAIL = "detail"
        const val EXTRA_SUMBER = "sumber"
        const val EXTRA_ISI = "isi"
        const val EXTRA_SMBR = "smbr"
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_back ->{
                val moveIntent = Intent(this@DetailActivity,MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
