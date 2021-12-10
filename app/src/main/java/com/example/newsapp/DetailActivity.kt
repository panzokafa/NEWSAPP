package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.newsapp.data.News

class DetailActivity : AppCompatActivity() {

    companion object {
        const val  EXTRA_DATA_TITLE = "title"
        const val  EXTRA_DATA_DATE = "date"
        const val  EXTRA_DATA_AUTHOR = "author"
        const val  EXTRA_DATA_CONTENT = "content"
        const val  EXTRA_DATA_IMAGE = "image"
        const val  EXTRA_OBJECT_NEWS = "news"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(findViewById(R.id.toolbar_detail))
        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            title = "News Detail"
        }

        val tvTitleDetail = findViewById<TextView>(R.id.tv_title_detail)
        val tvDateDetail = findViewById<TextView>(R.id.tv_date_detail)
        val tvAuthorDetail = findViewById<TextView>(R.id.tv_author_detail)
        val tvContentDetail = findViewById<TextView>(R.id.tv_content_detail)
        val tvImgDetail = findViewById<ImageView>(R.id.image_news_detail)

        val dataNews = intent.getParcelableExtra<News>(EXTRA_OBJECT_NEWS)

        if (dataNews != null) {
            tvTitleDetail.text = dataNews?.title
            tvDateDetail.text = dataNews?.date
            tvAuthorDetail.text = dataNews?.author
            tvContentDetail.text = dataNews?.content
            dataNews?.let { tvImgDetail.setImageResource(it.photo) }
        } else {
            tvTitleDetail.text = intent.getStringExtra("EXTRA_DATA_TITLE")
            tvDateDetail.text = intent.getStringExtra("EXTRA_DATA_DATE")
            tvAuthorDetail.text = intent.getStringExtra("EXTRA_DATA_AUTHOR")
            tvContentDetail.text = intent.getStringExtra("EXTRA_DATA_CONTENT")
            tvImgDetail.setImageResource(intent.getIntExtra("EXTRA_DATA_IMAGE", 0))
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}