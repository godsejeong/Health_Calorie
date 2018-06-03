package com.example.pc.mobile_contents

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bacordBtn.setOnClickListener{
            IntentIntegrator(this).initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        var intent = Intent(this,BacordReaderActivity::class.java)
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                intent.putExtra("result","바코드 인식을 실패하였습니다.")
                startActivity(intent)
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                intent.putExtra("result",result.contents)
                startActivity(intent)
                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
