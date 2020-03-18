package com.vokasi.abyan_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.vokasi.abyan_uts.input
import kotlinx.android.synthetic.main.activity_input.*
import org.json.JSONArray

class input : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        val context=this

        home.setOnClickListener {
            val intent= Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        input.setOnClickListener {
            var judul = judul.text.toString()
            var waktu = waktu.text.toString()
            var penulis = penulis.text.toString()
            var isi = isi.text.toString()

            postkerserver(judul, waktu, penulis, isi)

            val intent= getIntent()
            startActivity(intent)
            finish()
        }
    }

    fun postkerserver(judul:String,waktu:String, penulis:String, isi:String){
        AndroidNetworking.post("http://192.168.43.68/uts_vokasi/insert_data.php")
            .addBodyParameter("judul", judul)
            .addBodyParameter("waktu", waktu)
            .addBodyParameter("penulis", penulis)
            .addBodyParameter("isi", isi)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
                    Log.i("Teguh", "MANTAP")
                }

                override fun onError(anError: ANError?) {
                    Log.i("Teguh", "BOCOR")
                }
            })
    }

}
