package com.aman.bluetoothchat.di

import com.aman.bluetoothchat.data.database.Database
import com.aman.bluetoothchat.data.model.*
import com.aman.bluetoothchat.ui.view.NotificationView
import com.aman.bluetoothchat.ui.view.NotificationViewImpl
import com.aman.bluetoothchat.ui.viewmodel.converter.ChatMessageConverter
import com.aman.bluetoothchat.ui.viewmodel.converter.ContactConverter
import com.aman.bluetoothchat.ui.viewmodel.converter.ConversationConverter
import com.aman.bluetoothchat.ui.widget.ShortcutManager
import com.aman.bluetoothchat.ui.widget.ShortcutManagerImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val bluetoothConnectionModule = module {
    single { BluetoothConnectorImpl(androidContext()) as BluetoothConnector }
    factory { BluetoothScannerImpl(androidContext()) as BluetoothScanner }
}

val databaseModule = module {
    single { Database.getInstance(androidContext()) }
    single { MessagesStorageImpl(get()) as MessagesStorage }
    single { ConversationsStorageImpl(get()) as ConversationsStorage }
}

val localStorageModule = module {
    single { FileManagerImpl(androidContext()) as FileManager }
    single { UserPreferencesImpl(androidContext()) as UserPreferences }
    single { ProfileManagerImpl(androidContext()) as ProfileManager }
}

val viewModule = module {
    single { NotificationViewImpl(androidContext()) as NotificationView }
    single { ShortcutManagerImpl(androidContext()) as ShortcutManager }
    single { ContactConverter() }
    single { ConversationConverter(androidContext()) }
    single { ChatMessageConverter(androidContext()) }
}
