package com.github.bassaer.rxkotlinsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import layout.ContentFragment
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, ContentFragment())
        transaction.commit()

    }
}
