package coil.sample.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.Coil
import coil.api.load
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //URL
        firstImageView.load("https://via.placeholder.com/150")

        //RESOURCE
        firstImageView.load(android.R.drawable.ic_btn_speak_now)

        firstImageView.load("https://via.placeholder.com/150") {
            crossfade(true)
            placeholder(android.R.drawable.ic_btn_speak_now)
            transformations(BlurTransformation(this@MainActivity))
        }

        Coil.load(this, "https://via.placeholder.com/150") {
            target {

                val drawable = it.apply {
                    alpha = 1
                }

                firstImageView.setImageDrawable(drawable)
            }
        }

    }
}
