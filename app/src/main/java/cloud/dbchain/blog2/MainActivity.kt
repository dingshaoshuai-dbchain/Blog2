package cloud.dbchain.blog2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cloud.dbchain.blog2.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent().apply {
                setClass(context, MainActivity::class.java)
                // 携带参数
            }
            context.startActivity(intent)
        }
    }
}