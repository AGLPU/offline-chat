package com.aman.bluetoothchat.presenter

import com.aman.bluetoothchat.data.model.MessagesStorage
import com.aman.bluetoothchat.utils.toReadableFileSize
import com.aman.bluetoothchat.ui.presenter.ImagePreviewPresenter
import com.aman.bluetoothchat.ui.view.ImagePreviewView
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import java.io.File
import kotlin.coroutines.experimental.EmptyCoroutineContext

class ImagesPreviewPresenterUnitTest {

    @RelaxedMockK
    private lateinit var storage: MessagesStorage
    @RelaxedMockK
    private lateinit var view: ImagePreviewView
    @RelaxedMockK
    private lateinit var file: File

    private lateinit var presenter: ImagePreviewPresenter

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        presenter = ImagePreviewPresenter(0, file, view, storage,
                EmptyCoroutineContext, EmptyCoroutineContext)
    }

    @Test
    fun file_removing() {
        presenter.removeFile()
        coVerify { storage.removeFileInfo(0) }
        verify { view.close() }
    }

    @Test
    fun file_display() {
        val fileName = "file.png"
        val fileSize = 1024.toLong().toReadableFileSize()
        val fileUri = "file://$fileName"
        every { file.name } returns fileName
        every { file.length() } returns 1024
        every { file.absolutePath } returns fileName
        presenter.loadImage()
        verify { view.showFileInfo(fileName, fileSize) }
        verify { view.displayImage(fileUri) }
    }
}
