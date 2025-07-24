
package com.example.empowerherwellness
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SongActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_categories)

        // Initialize buttons
        val btnPlaySong1: Button = findViewById(R.id.btn_play_song1)
        val btnPlaySong2: Button = findViewById(R.id.btn_play_song2)
        val btnPlaySong3: Button = findViewById(R.id.btn_play_song3)
        val btnPlaySong4: Button = findViewById(R.id.btn_play_song4)
        val btnPlaySong5: Button = findViewById(R.id.btn_play_song5)
        val btnPlaySong6: Button = findViewById(R.id.btn_play_song6)
        val btnPlaySong7: Button = findViewById(R.id.btn_play_song7)
        val btnPlaySong8: Button = findViewById(R.id.btn_play_song8)
        val btnPlaySong9: Button = findViewById(R.id.btn_play_song9)

        // Set onClickListeners for each button
        btnPlaySong1.setOnClickListener { openSpotify("https://open.spotify.com/track/56zZ48jdyY2oDXHVnwg5Di") }
        btnPlaySong2.setOnClickListener { openSpotify("https://open.spotify.com/track/4XpUiYDVTFjAG7cu5XkiAM") }
        btnPlaySong3.setOnClickListener { openSpotify("https://open.spotify.com/album/3Ip9JCpT1IF9GvhAxzufTH") }
        btnPlaySong4.setOnClickListener { openSpotify("https://open.spotify.com/album/5XfOSDomcrv4lDvlrxknlt") }
        btnPlaySong5.setOnClickListener { openSpotify("https://open.spotify.com/track/0VjIjW4GlUZAMYd2vXMi3b") }
        btnPlaySong6.setOnClickListener { openSpotify("https://open.spotify.com/track/58f4twRnbZOOVUhMUpplJ4") }
        btnPlaySong7.setOnClickListener { openSpotify("https://open.spotify.com/album/3Q6oDVihOpQVi2FC0Mfjlm") }
        btnPlaySong8.setOnClickListener { openSpotify("https://open.spotify.com/track/72zHuDxFQTjbL51qJQSA7j") }
        btnPlaySong9.setOnClickListener { openSpotify("https://open.spotify.com/album/0upenH0uUT36nBbVM5mQhW") }
    }

    private fun openSpotify(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
