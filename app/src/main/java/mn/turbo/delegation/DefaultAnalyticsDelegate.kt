package mn.turbo.delegation

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

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