package base.compose.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColorScheme(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    // background
    val background: Color,
    val onBackground1: Color,
    val onBackground2: Color,
    // surface
    val surface: Color,
    val onSurface1: Color,
    val onSurface2: Color,
    val onSurface3: Color,
    val surfaceVariant: Color,
    // info surface
    val info: Color,
    val onInfo1: Color,
    val onInfo2: Color,
    // icon
    val iconBackground: Color,
    val onIconBackground: Color,
    // divider
    val border: Color,
    // input
    val input: Color,
    val onInput1: Color,
    val onInput2: Color,
    // warning
    val warning: Color,
    val onWarning: Color,
    val warningBackground: Color,
    val onWarningBackground: Color,
    val onWarningBackground2: Color,
    // error
    val error: Color,
    val onError: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,
    // number
    val positive: Color,
    val negative: Color,
)

val lightAppColors = AppColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    secondary = md_theme_light_secondaryContainer,
    onSecondary = md_theme_light_onSecondaryContainer,
    background = md_theme_light_background,
    onBackground1 = md_theme_light_onBackground,
    onBackground2 = md_theme_light_onSurfaceVariant,
    surface = md_theme_light_surface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurface1 = md_theme_light_onSurface,
    onSurface2 = md_theme_light_onSurfaceVariant,
    onSurface3 = md_theme_light_outline,
    info = md_theme_light_primaryContainer,
    onInfo1 = md_theme_light_onPrimaryContainer,
    onInfo2 = md_theme_light_onSurfaceVariant,
    iconBackground = md_theme_light_surfaceVariant,
    onIconBackground = md_theme_light_onSurface,
    input = md_theme_light_surfaceVariant,
    onInput1 = md_theme_light_onSurface,
    onInput2 = md_theme_light_outline,
    warning = Color(0xFFCA8804),
    onWarning = Color(0xFFFFFFFF),
    warningBackground = Color(0xFFFEF8C3),
    onWarningBackground = Color(0xFF78350F),
    onWarningBackground2 = Color(0xFF954E10),
    error = md_theme_light_error,
    onError = md_theme_light_onError,
    errorContainer = md_theme_light_error,
    onErrorContainer = md_theme_light_onError,
    border = md_theme_light_outlineVariant,
    positive = md_theme_light_primary,
    negative = md_theme_light_error,
)

val darkAppColors = AppColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    secondary = md_theme_dark_secondaryContainer,
    onSecondary = md_theme_dark_onSecondaryContainer,
    background = md_theme_dark_background,
    onBackground1 = md_theme_dark_onBackground,
    onBackground2 = md_theme_dark_onSurfaceVariant,
    surface = md_theme_dark_surface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurface1 = md_theme_dark_onSurface,
    onSurface2 = md_theme_dark_onSurfaceVariant,
    onSurface3 = md_theme_dark_outline,
    info = md_theme_dark_primaryContainer,
    onInfo1 = md_theme_dark_onPrimaryContainer,
    onInfo2 = md_theme_dark_onSurfaceVariant,
    iconBackground = md_theme_dark_surfaceVariant,
    onIconBackground = md_theme_dark_onSurface,
    input = md_theme_dark_surfaceVariant,
    onInput1 = md_theme_dark_onSurface,
    onInput2 = md_theme_dark_outline,
    warning = Color(0xFFCA8804),
    onWarning = Color(0xFFFFFFFF),
    warningBackground = Color(0xFF854C0E),
    onWarningBackground = Color(0xFFFFFFFF),
    onWarningBackground2 = Color(0xFFFFE0BF),
    error = md_theme_dark_error,
    onError = md_theme_dark_onError,
    errorContainer = md_theme_dark_errorContainer,
    onErrorContainer = md_theme_dark_onErrorContainer,
    border = md_theme_dark_outlineVariant,
    positive = md_theme_dark_primary,
    negative = md_theme_dark_error,
)
