package com.tdg.vroom.view.conferenceMeet.livekit.dialog

import android.app.Activity
import android.app.AlertDialog
import android.widget.ArrayAdapter
import com.tdg.vroom.R
import com.tdg.vroom.view.conferenceMeet.livekit.LiveKitMeetConferenceViewModel

fun Activity.showDebugMenuDialog(callViewModel: LiveKitMeetConferenceViewModel) {
    val builder = with(AlertDialog.Builder(this)) {
        setTitle("Debug Menu")

        val arrayAdapter = ArrayAdapter<String>(this@showDebugMenuDialog, R.layout.select_dialog_item)
        arrayAdapter.add("Simulate Migration")
        arrayAdapter.add("Reconnect to Room")
        setAdapter(arrayAdapter) { dialog, index ->
            when (index) {
                0 -> callViewModel.simulateMigration()
                1 -> callViewModel.reconnect()
            }
            dialog.dismiss()
        }
    }
    builder.show()
}
