package vcmsa.ci.musicplaylistapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.*

class MainActivity : AppCompatActivity() {

    // Arrays for storing song info
    val songTitles = Array<String?>(4) { null }
    val artistNames = Array<String?>(4) { null }
    val ratings = IntArray(4)
    val comments = Array<String?>(4) { null }

    var index = 0 // To keep track of entries

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val songTitle = findViewById<EditText>(R.id.SongTitleEdtTxt)
        val artistName = findViewById<EditText>(R.id.ArtistNameEdtTxt)
        val ratingSong = findViewById<EditText>(R.id.RateEdtTxt)
        val commentSongs = findViewById<EditText>(R.id.CommentEdtTxt)

        val addButton = findViewById<Button>(R.id.addToPlaylist)
        val viewButton = findViewById<Button>(R.id.viewPlaylistButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        addButton.setOnClickListener {
            if (index >= 4) {
                Toast.makeText(this, "Playlist is full!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val title = songTitle.text.toString()
            val artist = artistName.text.toString()
            val ratingSongs = ratingSong.text.toString()
            val comment = commentSongs.text.toString()

            if (title.isBlank() || artist.isBlank() || ratingSongs.isBlank()) {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rating = ratingSongs.toIntOrNull()
            if (rating == null || rating !in 1..5) {
                Toast.makeText(this, "Rating must be a number from 1 to 5", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            songTitles[index] = title
            artistNames[index] = artist
            ratings[index] = rating
            comments[index] = comment
            index++

            Toast.makeText(this, "Song added to playlist!", Toast.LENGTH_SHORT).show()

            songTitle.text.clear()
            artistName.text.clear()
            ratingSong.text.clear()
            commentSongs.text.clear()
        }

        viewButton.setOnClickListener {
            val intent = Intent(this, DetailPage::class.java).apply {

                putExtra("titles", songTitles)
                putExtra("artists", artistNames)
                putExtra("ratings", ratings)
                putExtra("comments", comments)
                putExtra("count", index)

            }
             startActivity(intent)
        }

        exitButton.setOnClickListener {
            finish()
        }
    }
}