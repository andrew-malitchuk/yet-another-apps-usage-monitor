package dev.yaaum.presentation.core.localisation

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

class LocalisationHelper {

    fun changeLang(lang: SupportedLang) {
        AppCompatDelegate.setApplicationLocales(
            LocaleListCompat.forLanguageTags(
                lang.lang,
            ),
        )
    }

    enum class SupportedLang(val lang: String) {
        UKR("ukr"),
        ENG("en-US"),
    }
}
