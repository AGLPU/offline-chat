package com.aman.bluetoothchat.ui.presenter

import com.aman.bluetoothchat.data.model.MessagesStorage
import com.aman.bluetoothchat.utils.toReadableFileSize
import com.aman.bluetoothchat.ui.view.ImagePreviewView
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import java.io.File
import kotlin.coroutines.experimental.CoroutineContext

class ImagePreviewPresenter(private val messageId: Long,
                            private val image: File,
                            private val view: ImagePreviewView,
                            private val storage: MessagesStorage,
                            private val uiContext: CoroutineContext = UI,
                            private val bgContext: CoroutineContext = CommonPool) {

    fun loadImage() {
        view.showFileInfo(image.name, image.length().toReadableFileSize())
        view.displayImage("file://${image.absolutePath}")
    }

    fun removeFile() = launch(bgContext) {

        image.delete()
        storage.removeFileInfo(messageId)

        launch(uiContext) {
            view.close()
        }
    }
}
