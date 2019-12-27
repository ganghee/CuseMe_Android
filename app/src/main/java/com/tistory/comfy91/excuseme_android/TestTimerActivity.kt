package com.tistory.comfy91.excuseme_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TestTimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_timer)

        val fragment = SelectSortFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.layout, fragment)
        transaction.commit()
    }
}
