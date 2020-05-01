package com.example.android.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class detailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        var title = intent.getStringExtra("title")
        var desc = intent.getStringExtra("desc")
        var tvTitle: TextView = findViewById(R.id.tvTitle)
        var tvdesc: TextView = findViewById(R.id.tvDescription)
        tvTitle.text = title.toString()
        tvdesc.text = desc.toString()
    }
}
