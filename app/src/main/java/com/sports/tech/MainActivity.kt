package com.sports.tech


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sports.tech.databinding.ActivityMainBinding
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var ind: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        binding.button1.setOnClickListener {
            Thread {
                val api = Client.getApi()
                api.getAns(1).enqueue(object : retrofit2.Callback<MutableList<Answer>> {
                    override fun onResponse(
                        call: Call<MutableList<Answer>>,
                        response: Response<MutableList<Answer>>
                    ) {
                        Log.d("TAG","${response.body()?.size} !")
                    }

                    override fun onFailure(call: Call<MutableList<Answer>>, t: Throwable) {

                    }

                })
            }.start()
        }
    }
}



