package com.praveen.android.teams.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.praveen.android.teams.model.QRScanCodeModel
import javax.inject.Inject

class QRScanViewmodel @Inject constructor(val qrScanCodeModel: QRScanCodeModel) : ViewModel() {

    fun getQRCode(qrcodeText: String): Bitmap?{
        return qrScanCodeModel.getQRCode(qrcodeText)
    }

}