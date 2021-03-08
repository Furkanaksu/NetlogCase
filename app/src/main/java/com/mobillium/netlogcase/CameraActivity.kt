package com.mobillium.netlogcase

import ImageDecoderBitmap
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.camerakit.CameraKitView
import com.mobillium.netlogcase.managers.Globals
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.*


class CameraActivity : AppCompatActivity() {

    var cameraKitView: CameraKitView? = null

    var image : Any? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        cameraKitView = findViewById(R.id.cameraKitView)
        cameraKitView!!.requestPermissions(this)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val ic_new = findViewById<ImageView>(R.id.ic_new)
        val ic_ok = findViewById<ImageView>(R.id.ic_ok)
        val ic_close = findViewById<ImageView>(R.id.ic_close)

        ic_close.setOnClickListener {
            val intent = Intent(this!!, CropImageActivity::class.java)
            intent.putExtra("SelectedImageUri", image.toString())
            startActivityForResult(intent, Globals.shared.IMAGE_CROP_RESULT_CODE)
        }

        ic_new.setOnClickListener {
            imageView.visibility = View.GONE
            cameraKitView?.visibility = View.VISIBLE
        }

        ic_ok.setOnClickListener {
            cameraKitView!!.captureImage { cameraKitView, capturedImage ->

                try {
                    val base64Encoded = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        Base64.getEncoder().encodeToString(capturedImage)
                    } else {
                        android.util.Base64.decode(capturedImage, android.util.Base64.DEFAULT)
                    }


                    image = getImageUri(this, ImageDecoderBitmap.convert(base64Encoded as String) )


                    imageView.visibility = View.VISIBLE
                    cameraKitView.visibility = View.INVISIBLE

                    Glide.with(this@CameraActivity)
                        .load(capturedImage)
                        .into(imageView)


                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }


        cameraKitView!!.gestureListener = object : CameraKitView.GestureListener {
            @SuppressLint("NewApi")
            override fun onTap(cameraKitView: CameraKitView, v: Float, v1: Float) {
                cameraKitView!!.captureImage { cameraKitView, capturedImage ->

                    try {
                        val base64Encoded = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            Base64.getEncoder().encodeToString(capturedImage)
                        } else {
                            android.util.Base64.decode(capturedImage, android.util.Base64.DEFAULT)
                        }


                        image = getImageUri(this@CameraActivity, ImageDecoderBitmap.convert(base64Encoded as String) )

                        imageView.visibility = View.VISIBLE
                        cameraKitView.visibility = View.INVISIBLE

                        Glide.with(this@CameraActivity)
                            .load(capturedImage)
                            .into(imageView)


                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onLongTap(p0: CameraKitView?, p1: Float, p2: Float) {}

            override fun onDoubleTap(p0: CameraKitView?, p1: Float, p2: Float) {}

            override fun onPinch(p0: CameraKitView?, p1: Float, p2: Float, p3: Float) {}
        }
    }

    override fun onStart() {
        super.onStart()
        cameraKitView!!.onStart()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        finish()
    }

    fun getImageUri(inContext: Context, inImage: Bitmap): Uri? {
        val bytes = ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path = MediaStore.Images.Media.insertImage(
            inContext.contentResolver,
            inImage,
            "Title",
            null
        )
        return Uri.parse(path)
    }

    override fun onPause() {
        cameraKitView!!.onPause()
        super.onPause()
    }

    override fun onStop() {
        cameraKitView!!.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        cameraKitView!!.onStop()
        super.onDestroy()
    }
}