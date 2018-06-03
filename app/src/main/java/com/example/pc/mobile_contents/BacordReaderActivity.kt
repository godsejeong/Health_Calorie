package com.example.pc.mobile_contents

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bacord_reader.*

class BacordReaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bacord_reader)

        val intent = intent
        var result = intent.getStringExtra("result")
        resultText.text = result.toString()

    }
}
