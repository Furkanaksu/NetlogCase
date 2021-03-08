package com.mobillium.netlogcase.pdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.github.barteksc.pdfviewer.PDFView
import com.mobillium.netlogcase.R
import java.io.InputStream

class PdfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)

        val pdf_view = findViewById<PDFView>(R.id.pdf_viewer)
        val ic_close: ImageView = findViewById(R.id.ic_close)


        ic_close.setOnClickListener {
            finish()
        }

        pdf_view.fromAsset("akbank_sozlesme.pdf")
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .defaultPage(0)
            .enableAnnotationRendering(true)
            .spacing(0)
            .load()

    }
}