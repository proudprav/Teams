package com.praveen.android.teams.model

import android.graphics.Bitmap
import com.praveen.android.teams.utility.Utils
import javax.inject.Inject

class QRScanCodeModelImpl @Inject constructor(): QRScanCodeModel {
    override fun getQRCode(qrcodeText: String): Bitmap? {
        return Utils().generateQRCode(qrcodeText)
    }
}