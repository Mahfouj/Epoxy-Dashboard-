package hr.factory.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.factory.fragment.EpoxySampleFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, EpoxySampleFragment())
            .commitAllowingStateLoss()


     }
}