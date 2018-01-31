package com.example.cemil.intentsendmail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun SendMail(view: View){
        val konu = konuText.getText().toString()
        val mail = mailText.getText().toString()
        val mesaj_icerik = icerikText.getText().toString()

        val intent = Intent(Intent.ACTION_SEND)
        val addressees = arrayOf(konu)
        intent.putExtra(Intent.EXTRA_EMAIL, addressees)
        intent.putExtra(Intent.EXTRA_SUBJECT, mail)
        intent.putExtra(Intent.EXTRA_TEXT, mesaj_icerik)
        intent.setType("message/rfc822")
        startActivity(Intent.createChooser(intent, "Maili hangi uygulama ile göndermek istersiniz?:"))
    }
}
