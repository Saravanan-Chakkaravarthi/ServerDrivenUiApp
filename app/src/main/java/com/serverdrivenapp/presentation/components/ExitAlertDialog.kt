package com.serverdrivenapp.presentation.components

import android.app.Activity
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun ExitAlertDialog(showDialog: Boolean, onShowDialog: (Boolean) -> Unit, context: Activity?) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onShowDialog(false) },
            title = { Text("Exit App") },
            text = { Text("Are you sure you want to exit?") },
            confirmButton = {
                TextButton(onClick = {
                    onShowDialog(false)
                    context?.finish()
                }) {
                    Text("Yes")
                }
            },
            dismissButton = {
                TextButton(onClick = { onShowDialog(false) }) {
                    Text("No")
                }
            }
        )
    }
}