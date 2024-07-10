package java.a1.deptask1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
                val intent = Intent(this, Activity_showlist::class.java)
                startActivity(intent)


            finish() // Optional: Finish the current activity if you don't want to go back to it
        }, 5000)
    }
}