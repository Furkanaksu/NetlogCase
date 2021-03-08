package com.mobillium.netlogcase

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.isseiaoki.simplecropview.CropImageView
import com.isseiaoki.simplecropview.callback.CropCallback
import com.isseiaoki.simplecropview.callback.LoadCallback
import com.isseiaoki.simplecropview.callback.SaveCallback
import com.mobillium.netlogcase.managers.Globals


class CropImageActivity : AppCompatActivity() {

    private var mSourceUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crop_image)

        var mCropView = findViewById<CropImageView>(R.id.cropImageView)
        var save = findViewById<ImageButton>(R.id.buttonDone)
        var rotateRight = findViewById<ImageButton>(R.id.buttonRotateRight)
        var rotateLeft = findViewById<ImageButton>(R.id.buttonRotateLeft)
        var cropProgressBar = findViewById<FrameLayout>(R.id.progresView)

        mCropView.setCropMode(CropImageView.CropMode.RATIO_3_4)

        mSourceUri = Uri.parse(intent.getStringExtra("SelectedImageUri"))

        mCropView.load(mSourceUri)
            .useThumbnail(true)
            .execute(mLoadCallback)

        save.setOnClickListener {
            save.isClickable = false
            cropProgressBar.visibility = View.VISIBLE
            mCropView.crop(mSourceUri)
                .execute(object : CropCallback {
                    override fun onSuccess(cropped: Bitmap) {
                        Globals.shared.Cropped = cropped
                        mCropView.save(cropped)
                            .execute(mSourceUri, mSaveCallback)

                    }
                    override fun onError(e: Throwable) {}
                })
        }

        rotateRight.setOnClickListener {

            mCropView.rotateImage(CropImageView.RotateDegrees.ROTATE_90D)

        }

        rotateRight.setOnClickListener {

            mCropView.rotateImage(CropImageView.RotateDegrees.ROTATE_M90D)
        }


    }

    private val mLoadCallback: LoadCallback = object : LoadCallback {
        override fun onSuccess()
        {

        }
        override fun onError(e: Throwable)
        {

        }
    }

    private val mSaveCallback: SaveCallback =
        object : SaveCallback {
            override fun onSuccess(outputUri: Uri)
            {
                val data =  Intent()
                data.data = outputUri
                setResult(RESULT_OK, data)
                finish()
            }

            override fun onError(e: Throwable) {
            }
        }
}
