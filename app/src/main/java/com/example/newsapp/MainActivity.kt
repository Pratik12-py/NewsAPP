package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback



class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("us", 1)

        news.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("MainActivity", "Error: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                if (response.isSuccessful) {
                    val newsData = response.body()
                    if (newsData != null) {
                        recyclerView.adapter = ArticleAdapter(newsData.articles)
                    }
                } else {
                    Log.d("MainActivity", "Response failed: ${response.errorBody()}")
                }
            }
        })
    }
}


