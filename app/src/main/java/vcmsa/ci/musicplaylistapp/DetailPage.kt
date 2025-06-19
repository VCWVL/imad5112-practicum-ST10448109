package vcmsa.ci.musicplaylistapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView


class DetailPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val songList = findViewById<TextView>(R.id.songList)
        val averageText = findViewById<TextView>(R.id.averageText)
        val backButton = findViewById<Button>(R.id.backButton)

        val titles = intent.getStringArrayExtra("titles")
        val artists = intent.getStringArrayExtra("artists")
        val ratings = intent.getIntArrayExtra("ratings")
        val comments = intent.getStringArrayExtra("comments")
        val count = intent.getIntExtra("count", 0)

        var totalRating = 0
        val displayText = StringBuilder()

        for (i in 0 until count) {
            displayText.append("🎵 ${titles?.get(i)} by ${artists?.get(i)}\n")
            displayText.append("⭐ Rating: ${ratings?.get(i)}\n")
            displayText.append("💬 Comment: ${comments?.get(i)}\n\n")
            totalRating += ratings?.get(i) ?: 0
        }

        songList.text = displayText.toString()

        val avgRating = if (count > 0) totalRating.toDouble() / count else 0.0
        averageText.text = "Average Rating: %.2f".format(avgRating)

        backButton.setOnClickListener {
            finish()
        }
    }
}
