package com.example.newsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val songsObjects: MutableList<Song> = mutableListOf()
        songsObjects.add(Song("Hello", "Just the description"))
        songsObjects.add(Song("ARDG", "John Lennon"))
        songsObjects.add(Song("Dance", "The Rolling Stones"))
        songsObjects.add(Song("Chill", "The Beatles"))
        songsObjects.add(Song("Coders Life", "Just the description"))
        songsObjects.add(Song("Adayein Bhi Main Mohabbat Bhi Hai", "OK Jaanu"))
        songsObjects.add(Song("Aye Udi Udi", "Sathishya"))
        songsObjects.add(Song("Enna Sona", "Random Data"))
        songsObjects.add(Song("FIT IT IT", "Hello"))
        songsObjects.add(Song("Agar Tum Mil Jao", "OK Jaanu"))
        songsObjects.add(Song("Ban Ja Rani", "Sulu"))

        val songList = findViewById<RecyclerView>(R.id.songList)
        songList.layoutManager = LinearLayoutManager(this)
        songList.adapter = MyAdapter(songsObjects)
    }
}
