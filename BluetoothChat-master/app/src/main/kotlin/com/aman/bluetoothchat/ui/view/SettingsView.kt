package com.aman.bluetoothchat.ui.view

import android.support.annotation.ColorInt

interface SettingsView {
    fun displayNotificationSetting(sound: Boolean)
    fun displayDiscoverySetting(classification: Boolean)
    fun displayAppearanceSettings(@ColorInt color: Int)
    fun displayColorPicker(@ColorInt color: Int)
}
