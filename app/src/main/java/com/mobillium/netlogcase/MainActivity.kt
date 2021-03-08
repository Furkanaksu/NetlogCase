package com.mobillium.netlogcase

import android.Manifest
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.mobillium.netlogcase.fragments.*
import com.mobillium.netlogcase.utils.AppUtil
import com.mobillium.netlogcase.utils.PermissionUtil


class MainActivity : AppCompatActivity() {


    private val TAG = "MainActivity"

    private val ERROR_DIALOG_REQUEST = 9001


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<ImageView>(R.id.btn1)
        val mainLayout = findViewById<FrameLayout>(R.id.mainLayout)
        val btn2 = findViewById<ImageView>(R.id.btn2)
        val btn3 = findViewById<ImageView>(R.id.btn3)
        val btn4 = findViewById<ImageView>(R.id.btn4)
        val btn5 = findViewById<ImageView>(R.id.btn5)

        requestPermissions()

        this.supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainLayout, SecondFragment())
            .commit()

        btn2.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200))
        btn2.setColorFilter(ContextCompat.getColor(this, R.color.blue), android.graphics.PorterDuff.Mode.SRC_IN)

        btn1.setOnClickListener {
            btn1.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200))
            btn1.setColorFilter(
                ContextCompat.getColor(this, R.color.blue),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn2.setBackgroundResource(R.drawable.border_img)
            btn2.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn3.setBackgroundResource(R.drawable.border_img)
            btn3.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn4.setBackgroundResource(R.drawable.border_img)
            btn4.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn5.setBackgroundResource(R.drawable.border_img)
            btn5.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )

            this.supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainLayout, FirstFragment())
                .commit()

        }

        btn2.setOnClickListener {
            btn2.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200))
            btn2.setColorFilter(
                ContextCompat.getColor(this, R.color.blue),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn1.setBackgroundResource(R.drawable.border_img)
            btn1.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn3.setBackgroundResource(R.drawable.border_img)
            btn3.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn4.setBackgroundResource(R.drawable.border_img)
            btn4.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn5.setBackgroundResource(R.drawable.border_img)
            btn5.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )

            this.supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainLayout, SecondFragment())
                .commit()

        }

        btn3.setOnClickListener {
            btn3.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200))
            btn3.setColorFilter(
                ContextCompat.getColor(this, R.color.blue),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn2.setBackgroundResource(R.drawable.border_img)
            btn2.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn1.setBackgroundResource(R.drawable.border_img)
            btn1.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn4.setBackgroundResource(R.drawable.border_img)
            btn4.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn5.setBackgroundResource(R.drawable.border_img)
            btn5.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )

            this.supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainLayout, ThirdFragment())
                .commit()

        }

        btn4.setOnClickListener {
            btn4.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200))
            btn4.setColorFilter(
                ContextCompat.getColor(this, R.color.blue),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn2.setBackgroundResource(R.drawable.border_img)
            btn2.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn3.setBackgroundResource(R.drawable.border_img)
            btn3.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn1.setBackgroundResource(R.drawable.border_img)
            btn1.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn5.setBackgroundResource(R.drawable.border_img)
            btn5.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )

            this.supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainLayout, FourthFragment())
                .commit()

        }

        btn5.setOnClickListener {
            btn5.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200))
            btn5.setColorFilter(
                ContextCompat.getColor(this, R.color.blue),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn2.setBackgroundResource(R.drawable.border_img)
            btn2.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn3.setBackgroundResource(R.drawable.border_img)
            btn3.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn4.setBackgroundResource(R.drawable.border_img)
            btn4.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            btn1.setBackgroundResource(R.drawable.border_img)
            btn1.setColorFilter(
                ContextCompat.getColor(this, R.color.gray),
                android.graphics.PorterDuff.Mode.SRC_IN
            )

            this.supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainLayout, FifthFragment())
                .commit()

        }

        isServicesOK()

    }

    fun isServicesOK(): Boolean {
        Log.d(TAG, "isServicesOK: checking google services version")
        val available =
            GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this@MainActivity)
        if (available == ConnectionResult.SUCCESS) {
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working")
            return true
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it")
            val dialog: Dialog = GoogleApiAvailability.getInstance()
                .getErrorDialog(this@MainActivity, available, ERROR_DIALOG_REQUEST)
            dialog.show()
        } else {
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show()
        }
        return false
    }


    private fun requestPermissionForCamera() {
        val permissions = arrayOf(Manifest.permission.CAMERA)
        val isPermissionGranted = PermissionUtil.hasPermissions(this, *permissions)
        if (!isPermissionGranted) {
            AppUtil.showAlertDialog(this, getString(R.string.permission_title), getString(R.string.permission_description), getString(R.string.button_ok), false) { dialogInterface: DialogInterface?, i: Int -> ActivityCompat.requestPermissions(this, permissions, PermissionUtil.REQUEST_CODE_MULTIPLE_PERMISSIONS) }
        }
    }

    private fun requestPermissions() {
        val requiredPermissions = ArrayList<String>()
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !== PackageManager.PERMISSION_GRANTED))
        {
            requiredPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !== PackageManager.PERMISSION_GRANTED))
        {
            requiredPermissions.add(Manifest.permission.CAMERA)
        }
        if (requiredPermissions.isNotEmpty())
        {
            ActivityCompat.requestPermissions(this,
                requiredPermissions.toArray(arrayOf<String>()),
                0)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PermissionUtil.REQUEST_CODE_MULTIPLE_PERMISSIONS) {
            val result = grantResults[0]
            if (result == PackageManager.PERMISSION_DENIED) {
                if (!PermissionUtil.showRationale(this, permissions[0])) {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", packageName, null)
                    intent.data = uri
                    startActivityForResult(intent, APP_SETTINGS_ACTIVITY_REQUEST_CODE)
                } else {
                    requestPermissionForCamera()
                }
            }
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val APP_CAMERA_ACTIVITY_REQUEST_CODE = 150
        private const val APP_SETTINGS_ACTIVITY_REQUEST_CODE = 550
    }


}