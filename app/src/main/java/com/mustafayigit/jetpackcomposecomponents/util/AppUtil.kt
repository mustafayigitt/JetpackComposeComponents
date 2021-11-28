package com.mustafayigit.jetpackcomposecomponents.util

import android.content.Context
import android.widget.Toast

infix fun String.printToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}
