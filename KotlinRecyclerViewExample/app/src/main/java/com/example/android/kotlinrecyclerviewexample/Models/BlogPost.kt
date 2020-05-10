package com.example.android.kotlinrecyclerviewexample.Models

data class BlogPost (
    var title:String,
var body:String,
var image:String,
var username:String) {
    override fun toString(): String {
        return "BlogPost(title='$title', image='$image', username='$username')"
    }
}