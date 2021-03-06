package com.tistory.comfy91.excuseme_android.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tistory.comfy91.excuseme_android.R
import com.tistory.comfy91.excuseme_android.feature.helper.SelectSortFragment

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
