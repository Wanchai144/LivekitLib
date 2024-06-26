/*
 * Copyright 2023-2024 LiveKit, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tdg.vroom.view.conferenceMeet.livekit.dialog

import android.app.Activity
import android.app.AlertDialog
import android.widget.ArrayAdapter
import com.tdg.vroom.R
import com.tdg.vroom.view.conferenceMeet.livekit.LiveKitMeetConferenceViewModel

fun Activity.showAudioProcessorSwitchDialog(callViewModel: LiveKitMeetConferenceViewModel) {
    val name = callViewModel.audioProcessorOptions?.capturePostProcessor?.getName()
    val enabled = if (callViewModel.enableAudioProcessor.value == true) "On" else "Off"
    val builder = with(AlertDialog.Builder(this)) {
        setTitle("AudioProcessor for mic: \n[$name] is $enabled")

        val arrayAdapter = ArrayAdapter<String>(this@showAudioProcessorSwitchDialog, R.layout.select_dialog_item)
        arrayAdapter.add("On")
        arrayAdapter.add("Off")
        setAdapter(arrayAdapter) { dialog, index ->
            when (index) {
                0 -> callViewModel.toggleEnhancedNs(true)
                1 -> callViewModel.toggleEnhancedNs(false)
            }
            dialog.dismiss()
        }
    }
    builder.show()
}
