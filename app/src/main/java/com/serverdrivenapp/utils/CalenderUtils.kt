package com.serverdrivenapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import java.util.concurrent.TimeUnit

object CalenderUtils {
    fun formatRelativeTime(timestamp: String?): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC") // Parse as UTC

        val past = sdf.parse(timestamp ?: "")
        val now = Date()

        val diff = now.time - (past?.time ?: 0)

        return when {
            diff < TimeUnit.MINUTES.toMillis(1) -> "${diff / 1000} seconds ago"
            diff < TimeUnit.HOURS.toMillis(1) -> "${diff / TimeUnit.MINUTES.toMillis(1)} minutes ago"
            diff < TimeUnit.DAYS.toMillis(1) -> "${diff / TimeUnit.HOURS.toMillis(1)} hours ago"
            diff < TimeUnit.DAYS.toMillis(7) -> "${diff / TimeUnit.DAYS.toMillis(1)} days ago"
            diff < TimeUnit.DAYS.toMillis(30) -> "${diff / TimeUnit.DAYS.toMillis(7)} weeks ago"
            diff < TimeUnit.DAYS.toMillis(365) -> "${diff / TimeUnit.DAYS.toMillis(30)} months ago"
            else -> "${diff / TimeUnit.DAYS.toMillis(365)} years ago"
        }
    }
}