package com.example.android.kotlinrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), recyclerViewAdapter.OnItemClickListener {

    override fun onItemClick(user: userDataModel) {
        var intent = Intent (this,detailedActivity::class.java)
        intent.putExtra("title",user.title)
        intent.putExtra("desc",user.desc)
        startActivity(intent)
        finish()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView:RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager( this,LinearLayoutManager.VERTICAL,false)
        var user = ArrayList<userDataModel>()
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))
        user.add(userDataModel("Blacky y Perlita","La historia de amor entre dos perritos en el tiempo del covid-19"))

        var adapter = recyclerViewAdapter(user,this)
        recyclerView.setAdapter(adapter)
    }


}
