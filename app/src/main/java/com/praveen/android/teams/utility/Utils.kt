package com.praveen.android.teams.utility

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Bitmap
import android.widget.Toast
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.zxing.WriterException
import com.praveen.android.teams.R
import com.praveen.android.teams.application.TeamsApplication
import java.io.IOException
import java.io.InputStream

class Utils {

    fun generateQRCode(text : String): Bitmap?{

        val qrgEncoder = QRGEncoder(text, null, QRGContents.Type.TEXT, 800);
        var bitmap : Bitmap? = null
        try {
            // getting our qrcode in the form of bitmap.
            bitmap = qrgEncoder.encodeAsBitmap();
        } catch (e: WriterException){
            print("exception $e")
        }

        return bitmap
    }

    fun copytoClipBoard(text: String, context: Context){
        text.copyToClipboard(context)
    }

    fun String.copyToClipboard(context: Context) {
        val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText(context.getString(R.string.teamslabel),this)
        clipBoard.setPrimaryClip(clipData)
        Toast.makeText(context, context.getString(R.string.teamsLink_copied_to_Clipboard), Toast.LENGTH_SHORT).show()
    }

    fun loadJSONFile(fileName: String): String? {
        var json: String? = null
        json = try {
            val inputStream: InputStream = TeamsApplication.ctx!!.assets.open(fileName)
            val size: Int = inputStream.available()
            val byteArray = ByteArray(size)
            inputStream.read(byteArray)
            inputStream.close()
            String(byteArray, charset("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return json
    }
}
