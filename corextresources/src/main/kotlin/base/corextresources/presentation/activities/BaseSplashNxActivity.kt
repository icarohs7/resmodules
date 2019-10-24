package base.corextresources.presentation.activities

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.core.view.isInvisible
import androidx.lifecycle.lifecycleScope
import base.corextresources.R
import base.corextresources.databinding.ActivityBaseNxSplashBinding
import base.coreresources.extensions.animateFadeIn
import base.coreresources.state.addOnLoadingListener

abstract class BaseSplashNxActivity(
    private val version: String,
    timeout: Int = 0
) : BaseTimeoutActivity<ActivityBaseNxSplashBinding>(timeout) {

    @CallSuper
    override fun onBindingCreated(savedInstanceState: Bundle?) {
        super.onBindingCreated(savedInstanceState)
        lifecycleScope.addOnLoadingListener { toggleLoading(it) }
        binding.txtVersion.text = version
        binding.imgLogo.alpha = 0f
        binding.imgLogo.animateFadeIn((timeout).toLong())
    }

    private fun toggleLoading(isLoading: Boolean) {
        binding.progressBar.isInvisible = !isLoading
    }

    override fun getLayout(): Int {
        return R.layout.activity_base_nx_splash
    }
}