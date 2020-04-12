package com.aman.bluetoothchat.ui.view

import com.aman.bluetoothchat.data.entity.MessageFile

interface ReceivedImagesView {
    fun displayImages(imageMessages: List<MessageFile>)
    fun showNoImages()
}
