package dev.yaaum.presentation.core.localisation

import android.annotation.SuppressLint
import android.app.LocaleManager
import android.content.Context
import android.os.LocaleList
import androidx.core.content.ContextCompat.getSystemService
import java.util.Locale

@SuppressLint("NewApi")
class LocalisationHelper(context: Context) {

    private var localeManager: LocaleManager? = null

    init {
        localeManager = context.getSystemService(Context.LOCALE_SERVICE) as? LocaleManager
    }

    fun changeLang(lang: SupportedLang) {
        localeManager?.applicationLocales = LocaleList(Locale.forLanguageTag(lang.code))
    }

    fun getCurrentLang(): SupportedLang {
        return SupportedLang.entries.first { it.code == localeManager?.applicationLocales?.toLanguageTags() }
    }

    fun getSupportedLang(): List<SupportedLang> {
        return SupportedLang.entries.toList()
    }

    enum class SupportedLang(val code: String, val language: String) {
        UKR("ukr", "Українська"),
        ENG("en", "English"),
    }
}
