package com.diky.rickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diky.rickapp.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val morty = findViewById<RecyclerView>(R.id.rv_rick)

        ApiConfig.getService().getrick().enqueue(object : Callback<ResponseRick>{
            override fun onResponse(call: Call<ResponseRick>, response: Response<ResponseRick>) {
                if (response.isSuccessful){
                    val responseMorty = response.body()
                    val dataMorty = responseMorty?.results
                    val rickAdapter = RickAdapter(dataMorty)
                    morty.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        rickAdapter.notifyDataSetChanged()
                        adapter = rickAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseRick>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

    }
}