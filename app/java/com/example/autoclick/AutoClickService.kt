package com.example.autoclick

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.app.Activity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val info = TextView(this)
        info.text = "AutoClick 工具\n\n1. 点击按钮开启无障碍\n2. 开启后自动点击"
        info.textSize = 18f

        val btn = Button(this)
        btn.text = "开启无障碍设置"

        btn.setOnClickListener {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }

        layout.addView(info)
        layout.addView(btn)

        setContentView(layout)
    }
}
