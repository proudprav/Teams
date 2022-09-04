package com.praveen.android.teams.model

import android.graphics.Bitmap

interface QRScanCodeModel {
    fun getQRCode(qrcodeText: String): Bitmap?
}