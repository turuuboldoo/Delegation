package mn.turbo.delegation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import mn.turbo.delegation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    AnalyticsDelegate by DefaultAnalyticsDelegate() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.user = User(name = "Turbo dion some Delegation")

        registerAnalytics(lifecycle)
    }

}

interface AnalyticsDelegate {
    fun registerAnalytics(lifecycle: Lifecycle)
}

class DefaultAnalyticsDelegate : AnalyticsDelegate, DefaultLifecycleObserver {

    override fun registerAnalytics(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        traceLifecycle(owner.lifecycle.currentState.name)
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        traceLifecycle(owner.lifecycle.currentState.name)
    }

    private fun traceLifecycle(string: String) {
        Log.w("123123", string)
    }
}