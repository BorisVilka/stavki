package com.sports.tech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.sports.tech.databinding.ActivityListBinding
import retrofit2.Call
import retrofit2.Response
import kotlin.math.min

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
                    val list = response.body()
                    var tmp = mutableListOf<Answer>()
                    for(i in list!!.indices) {
                        if(!contains(tmp,list[i])) {
                            tmp.add(list[i])
                            if(tmp.size>=20) break
                        }
                    }
                    Log.d("TAG","${tmp.size} TT")
                    val adapter = MyAdapter(tmp)
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
    fun contains(list: MutableList<Answer>, a: Answer): Boolean {
        var b = false
        for(i in list) {
            if(i.chemp==a.chemp && i.op1==a.op1 && i.op2==a.op2) {
                b = true
                break
            }
        }
        return b
    }
}