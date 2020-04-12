package com.aman.bluetoothchat.ui.viewmodel

import android.support.annotation.StringRes
import com.aman.bluetoothchat.data.service.message.PayloadType
import com.aman.bluetoothchat.utils.Size

data class ChatMessageViewModel(
        val uid: Long,
        val date: String,
        val text: String?,
        val own: Boolean,
        val type: PayloadType?,
        val isImageAvailable: Boolean,
        @StringRes
        val imageProblemText: Int,
        val imageSize: Size,
        val imagePath: String?,
        val imageUri: String?
)
