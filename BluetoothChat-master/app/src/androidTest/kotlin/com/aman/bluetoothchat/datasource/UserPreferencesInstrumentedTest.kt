package com.aman.bluetoothchat.datasource

import android.graphics.Color
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.aman.bluetoothchat.data.model.UserPreferences
import com.aman.bluetoothchat.data.model.UserPreferencesImpl
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserPreferencesInstrumentedTest {

    private lateinit var storage: UserPreferences

    @Before
    fun prepare() {
        val context = InstrumentationRegistry.getTargetContext()
        storage = UserPreferencesImpl(context).apply {
            saveNewSoundPreference(false)
            saveNewClassificationPreference(true)
            saveChatBgColor(Color.RED)
        }
    }

    @After
    fun release() = with(storage) {
        saveNewSoundPreference(false)
        saveNewClassificationPreference(true)
        saveChatBgColor(0)
    }

    @Test
    fun color() {
        storage.saveChatBgColor(Color.GREEN)
        val savedColor = storage.getChatBackgroundColor()
        assertTrue(Color.GREEN == savedColor)
    }

    @Test
    fun sound() {
        storage.saveNewSoundPreference(true)
        val savedSound = storage.isSoundEnabled()
        assertTrue(savedSound)
    }

    @Test
    fun classification() {
        storage.saveNewClassificationPreference(false)
        val savedClassification = storage.isClassificationEnabled()
        assertTrue(!savedClassification)
    }
}
