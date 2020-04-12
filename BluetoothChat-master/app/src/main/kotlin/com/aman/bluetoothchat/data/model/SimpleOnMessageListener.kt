package com.aman.bluetoothchat.data.model

abstract class SimpleOnMessageListener : OnMessageListener {

    override fun onMessageDelivered(id: Long) {}

    override fun onMessageNotDelivered(id: Long) {}

    override fun onMessageSeen(id: Long) {}
}