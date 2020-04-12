package com.aman.bluetoothchat.ui.view

import com.aman.bluetoothchat.ui.viewmodel.ContactViewModel

interface ContactChooserView {
    fun showContacts(contacts: List<ContactViewModel>)
    fun showNoContacts()
}
