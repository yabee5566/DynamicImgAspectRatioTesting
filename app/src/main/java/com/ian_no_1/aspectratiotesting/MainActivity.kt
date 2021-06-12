package com.ian_no_1.aspectratiotesting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import com.facebook.drawee.backends.pipeline.Fresco
import com.ian_no_1.aspectratiotesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Fresco.initialize(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            squareBtn.setOnClickListener {

                block.updateLayoutParams<ConstraintLayout.LayoutParams> {
                    dimensionRatio = RATIO_SQUARE_MEDIA

                }
            }
            longBtn.setOnClickListener {
                block.updateLayoutParams<ConstraintLayout.LayoutParams> {
                    dimensionRatio = RATIO_VERTICAL_MEDIA

                }
            }
            flatBtn.setOnClickListener {
                block.updateLayoutParams<ConstraintLayout.LayoutParams> {
                    dimensionRatio = RATIO_HORIZONTAL_MEDIA
                }
            }

        }
    }
    companion object {
        const val RATIO_SQUARE_MEDIA = "H,3:3"
        const val RATIO_VERTICAL_MEDIA = "H,3:4"
        const val RATIO_HORIZONTAL_MEDIA = "H,3:2.25"
    }
}