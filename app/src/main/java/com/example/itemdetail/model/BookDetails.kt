package com.example.itemdetail.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.itemdetail.R
import kotlinx.android.synthetic.main.activity_book_details.*

class BookDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val bundle = intent.extras

        if (bundle != null) {
            imgBookDetails.setImageResource(bundle.getInt("image"))
            tvName.text = bundle.getString("name")
            tvDetails.text = bundle.getString("description")
        }
    }
}
