object AndroidX {
    private const val coreKtxVersion = "1.7.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val appCompatVersion = "1.4.1"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    private const val lifecycleVmVersion = "2.4.1"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVmVersion"

    private const val lifecycleRuntimeVersion = "2.4.1"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeVersion"
}

object AndroidXTest {
    private const val version = "1.4.0"
    const val runner = "androidx.test:runner:$version"
    const val rules = "androidx.test:rules:$version"
    const val testExt = "androidx.test.ext:junit:1.1.3"
}