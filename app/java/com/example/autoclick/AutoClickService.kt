package com.example.autoclick

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent

class AutoClickService : AccessibilityService() {

    var running = false

    override fun onServiceConnected() {
        super.onServiceConnected()
        startAutoClick()
    }

    private fun startAutoClick() {
        running = true

        Thread {
            while (running) {
                click(500, 1000)   // 👈 修改这里的坐标
                Thread.sleep(1000) // 👈 点击间隔
            }
        }.start()
    }

    private fun click(x: Int, y: Int) {
        val path = Path()
        path.moveTo(x.toFloat(), y.toFloat())

        val gesture = GestureDescription.Builder()
            .addStroke(GestureDescription.StrokeDescription(path, 0, 50))
            .build()

        dispatchGesture(gesture, null, null)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}

    override fun onInterrupt() {}
}
