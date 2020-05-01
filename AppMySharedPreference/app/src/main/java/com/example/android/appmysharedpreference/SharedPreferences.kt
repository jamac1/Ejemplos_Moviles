package com.example.android.appmysharedpreference

import android.content.Context

class SharedPreferences(val context:Context) {
    val PREFS_NAME ="sharedPreferences"
    val sharedPreferences = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)

    fun save(keyname:String, value:String){
        val editor= sharedPreferences.edit()
        editor.putString(keyname,value)
        editor.commit()

    }
    fun getvalueString(keyname:String):String?{
        return sharedPreferences.getString(keyname,null)

    }
    fun clear(){
        val editor= sharedPreferences.edit()
        editor.clear()
        editor.commit()
    }
    fun removeValue(keyname:String){
        val editor= sharedPreferences.edit()
        editor.remove(keyname)
        editor.commit()

    }
}