package com.serverdrivenapp.utils

import android.content.Context
import java.io.InputStreamReader

fun loadJsonFromRaw(resourceId: Int, context: Context): String {
    val inputStream = context.resources.openRawResource(resourceId)
    return InputStreamReader(inputStream).readText()
}