package com.mobillium.netlogcase.managers

import android.graphics.Bitmap
import android.net.Uri

import java.util.*


public class Globals {

    companion object {
        private var instance: Globals? = null

        val shared: Globals
            get() {
                if (instance == null) {
                    instance = Globals()
                }

                return instance!!
            }
    }

    val IMAGE_CROP_RESULT_CODE = 1000;
    val PERMISSION_CODE_CAMERA = 1001;
    val PERMISSION_CODE_GALLERY = 1002;

    var City = ""
    var Prov = ""
    var Adress = ""
    var Cropped: Bitmap? = null
    var Lat: Double? = null
    var Long: Double? = null
}