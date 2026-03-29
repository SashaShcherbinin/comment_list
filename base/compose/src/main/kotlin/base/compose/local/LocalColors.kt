package base.compose.local

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import base.compose.theme.AppColorScheme

internal val LocalAppColorScheme: ProvidableCompositionLocal<AppColorScheme> =
    compositionLocalOf {
        error("CompositionLocal AppColors not present")
    }
