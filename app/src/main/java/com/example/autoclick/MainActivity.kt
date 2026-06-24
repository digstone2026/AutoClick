package com.example.autoclick

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = TextView(this)
        text.text = "AutoClick 已安装\n请去设置开启无障碍服务"
        text.textSize = 20f

        setContentView(text)
    }
}
