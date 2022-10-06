package mn.turbo.delegation

import androidx.lifecycle.Lifecycle

interface AnalyticsDelegate {
    fun registerAnalytics(lifecycle: Lifecycle)
}