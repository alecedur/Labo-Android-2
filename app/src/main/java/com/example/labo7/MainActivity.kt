package com.example.labo7

import android.content.ContentValues.TAG
import android.graphics.Color
import android.media.MediaActionSound
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //inicializamos los botones
        val buttonInit = findViewById<Button>(R.id.Inicio)
        val button1 = findViewById<Button>(R.id.boton1)
        val button2 = findViewById<Button>(R.id.boton2)
        val button3 = findViewById<Button>(R.id.boton3)
        val button4 = findViewById<Button>(R.id.boton4)
        val button5 = findViewById<Button>(R.id.boton5)
        val button6 = findViewById<Button>(R.id.boton6)
        //inicializamos la musica
        val music: MutableList<Int> = ArrayList()
        music.add(R.raw.sound_do)
        music.add(R.raw.sound_re)
        music.add(R.raw.sound_mi)
        music.add(R.raw.sound_fa)
        music.add(R.raw.sound_sol)
        music.add(R.raw.sound_la)
        music.add(R.raw.sound_si)

        buttonInit.setOnClickListener(View.OnClickListener {
            //cambiamos el color de uno solo
            button1.setBackgroundColor(Color.GRAY)
            playSound(music, 1)
            buttonInit.isClickable = false
            button1.isClickable = false
            button2.isClickable = false
            button3.isClickable = false
            button4.isClickable = false
            button5.isClickable = false
            button6.isClickable = false
            Handler().postDelayed(Runnable { // This method will be executed once the timer is over
                button1.setBackgroundColor(Color.RED)
                buttonInit.isClickable = true
                button1.isClickable = true
                button2.isClickable = true
                button3.isClickable = true
                button4.isClickable = true
                button5.isClickable = true
                button6.isClickable = true

            }, 2000) // set time as per your requirement
        })
    }
    private fun playSound(music: MutableList<Int>, button: Int) {
        val sound = music[button]
        val song = MediaPlayer.create(this, sound)
        song.start()
    }
}