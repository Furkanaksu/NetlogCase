package com.mobillium.netlogcase.managers

import android.graphics.Bitmap

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


    var City = ""
    var Prov = ""
    var Adress = ""
}