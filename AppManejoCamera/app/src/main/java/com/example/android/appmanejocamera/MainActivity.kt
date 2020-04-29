package com.example.android.appmanejocamera
import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val CAMERA_REQUEST_CODE = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_camara.setOnClickListener {
            checkCameraPermission()
        }
    }

    private fun checkCameraPermission() {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
            requestCameraPermission()
        }
         else{
            Toast.makeText(this,"Ya cuenta con el permiso de camera",Toast.LENGTH_LONG).show()
        }
    }

    private fun requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)){
            Toast.makeText(this,"Usted rechazo el permiso previamente",Toast.LENGTH_LONG).show()
        }
        else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),CAMERA_REQUEST_CODE)
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray){
        when (requestCode){
            CAMERA_REQUEST_CODE ->{
                if(grantResults.isNotEmpty()&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Se autorizo el acceso a la camera",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this,"NO se autorizo el acceso a la camera",Toast.LENGTH_LONG).show()
                }
                return
            }
        }

    }
}
