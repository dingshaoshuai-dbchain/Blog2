package cloud.dbchain.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import dingshaoshuai.function.Function

open class MApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
        Function.init(this)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}