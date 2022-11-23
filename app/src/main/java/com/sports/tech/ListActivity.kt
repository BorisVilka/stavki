package com.sports.tech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.sports.tech.databinding.ActivityListBinding
import retrofit2.Call
import retrofit2.Response

class ListActivity : AppCompatActivity() {

    private var ind: Int = 1
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ind = intent.getIntExtra("ind",1)
        Thread {
            val api = Client.getApi()
            api.getAns(ind).enqueue(object : retrofit2.Callback<MutableList<Answer>> {
                override fun onResponse(
                    call: Call<MutableList<Answer>>,
                    response: Response<MutableList<Answer>>
                ) {
                    Log.d("TAG","${response.body()?.size} !")
                    val list = response.body()?.subList(0,10)
                    for(i in list!!.indices) {
                        Log.d("TAG",list[i].op1+" "+list[i].op2)
                    }
                    val adapter = MyAdapter(list)
                    runOnUiThread {
                        binding.progressBar3.visibility = View.GONE
                        binding.list.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<MutableList<Answer>>, t: Throwable) {

                }

            })
        }.start()
    }
}