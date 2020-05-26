package com.example.itemdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.itemdetail.model.Book
import com.example.itemdetail.model.BookDetails
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.book_entry.view.*

class MainActivity : AppCompatActivity() {

    var adapter: BookAdapter? = null
    var booksList = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // load foods
        booksList.add(
            Book(
                "Learn Kotlin",
                "This book will teach you the key Kotlin skills and techniques important for creating your very own Android apps. Apart from introducing Kotlin programming, Learn Kotlin for Android Development stresses clean code principles and introduces object-oriented and functional programming as a starting point for developing Android apps.",
                R.drawable.learn_kotlin
            )
        )
        booksList.add(
            Book(
                "Kotlin in Action",
                "Kotlin in Action guides experienced Java developers from the language basics of Kotlin all the way through building applications to run on the JVM and Android devices. Foreword by Andrey Breslav, Lead Designer of Kotlin.",
                R.drawable.kotlinaction
            )
        )
        booksList.add(
            Book(
                "Android Studio Development Essentials",
                "An overview of Android Studio is included covering areas such as tool windows, the code editor and the Layout Editor tool. An introduction to the architecture of Android is followed by an in-depth look at the design of Android applications and user interfaces using the Android Studio environment.",
                R.drawable.essentials
            )
        )
        booksList.add(
            Book(
                "Android Development with Kotlin",
                "Learn how to make Android development much faster using a variety of Kotlin features, from basics to advanced, to write better quality code.Write code based on both object oriented and functional programming to build robust applications, filled with various practical examples.",
                R.drawable.android_dev
            )
        )
        booksList.add(
            Book(
                "Kotlin Cookbook",
                "Use Kotlin to build Android apps, web applications, and more while you learn the nuances of this popular language. Both experienced programmers and those new to Kotlin will benefit from the practical recipes in this book.",
                R.drawable.cookbook
            )
        )
        booksList.add(
            Book(
                "Kotlin for Android Developers ",
                "Recommended by Google and JetBrains, this book by Antonio Leiva is an easy-to-follow guide that will show you how to develop an Android app using Kotlin.",
                R.drawable.kotlin_for
            )
        )
        adapter = BookAdapter(this, booksList)

        gvBooks.adapter = adapter
    }
}

class BookAdapter : BaseAdapter {
    var booksList = ArrayList<Book>()
    var context: Context? = null

    constructor(context: Context, booksList: ArrayList<Book>) : super() {
        this.context = context
        this.booksList = booksList
    }

    override fun getCount(): Int {
        return booksList.size
    }

    override fun getItem(position: Int): Any {
        return booksList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val book = this.booksList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var bookView = inflator.inflate(R.layout.book_entry, null)
        bookView.imgBook.setOnClickListener {

            val intent = Intent(context, BookDetails::class.java)
            intent.putExtra("name", book.name!!)
            intent.putExtra("description", book.description!!)
            intent.putExtra("image", book.image!!)
            context!!.startActivity(intent)
        }

        bookView.imgBook.setImageResource(book.image!!)
        bookView.tvName.text = book.name!!

        return bookView
    }
}