package com.aman.bluetoothchat.ui.presenter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.aman.bluetoothchat.data.model.ConversationsStorage
import com.aman.bluetoothchat.ui.view.ContactChooserView
import com.aman.bluetoothchat.ui.viewmodel.converter.ContactConverter
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import kotlin.coroutines.experimental.CoroutineContext

class ContactChooserPresenter(private val view: ContactChooserView,
                              private val model: ConversationsStorage,
                              private val converter: ContactConverter,
                              private val uiContext: CoroutineContext = UI,
                              private val bgContext: CoroutineContext = CommonPool): LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun loadContacts() = launch(uiContext) {

        val contacts = withContext(bgContext) { model.getContacts() }

        if (contacts.isNotEmpty()) {
            val viewModels = converter.transform(contacts)
            view.showContacts(viewModels)
        } else {
            view.showNoContacts()
        }
    }
}
