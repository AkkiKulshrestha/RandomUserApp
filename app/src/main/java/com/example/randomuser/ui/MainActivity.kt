package com.example.randomuser.ui

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import com.example.randomuser.R
import com.example.randomuser.databinding.ActivityMainBinding
import com.example.randomuser.utils.ConnectionLiveData
import com.example.randomuser.utils.extensions.goneWithScaleFade
import com.example.randomuser.utils.extensions.visibleWithScaleFade
import com.example.randomuser.utils.transition.Scale
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Global
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val colorBackground = resources.getColor(R.color.color_background, null)
            window.statusBarColor = colorBackground
            window.navigationBarColor = colorBackground
            val isNightMode =
                when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                    Configuration.UI_MODE_NIGHT_YES -> true
                    else -> false
                }
            if (!isNightMode) {
                val decorView = window.decorView
                val controller = WindowInsetsControllerCompat(window, decorView)
                controller.isAppearanceLightStatusBars = true
                controller.isAppearanceLightNavigationBars = true
            }
        }
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ConnectionLiveData(this).observe(this) { isNetworkAvailable ->
            binding.txtNetworkStatus.apply {
                val parent = this.parent as ViewGroup
                val direction = Scale.Direction.DOWN
                if (!isNetworkAvailable)
                    visibleWithScaleFade(parent = parent, direction = direction)
                else
                    goneWithScaleFade(parent = parent, direction = direction)
            }
        }
    }
}