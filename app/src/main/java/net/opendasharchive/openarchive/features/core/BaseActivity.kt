package net.opendasharchive.openarchive.features.core

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MotionEvent
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity(){

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q && event != null) {
            val obscuredTouch = event.flags and MotionEvent.FLAG_WINDOW_IS_PARTIALLY_OBSCURED != 0
            if (obscuredTouch) return false
        }
        return super.dispatchTouchEvent(event)
    }

}