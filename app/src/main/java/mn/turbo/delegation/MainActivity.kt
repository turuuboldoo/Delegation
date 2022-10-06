package mn.turbo.delegation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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