/*
 * Copyright 2016 Frap
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.frap.goohara

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Bundle

inline fun <reified T : Activity> Context.startActivity() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T : Activity> Context.startActivity(flags: Int) {
    startActivity(Intent(this, T::class.java).setFlags(flags))
}

inline fun <reified T : Activity> Context.startActivity(extras: Bundle) {
    startActivity(Intent(this, T::class.java).putExtras(extras))
}

inline fun <reified T : Activity> Context.startActivity(extras: Bundle, flags: Int) {
    startActivity(Intent(this, T::class.java).putExtras(extras).setFlags(flags))
}

inline fun <reified T : Service> Context.startService() {
    startService(Intent(this, T::class.java))
}

inline fun <reified T : Service> Context.startService(flags: Int) {
    startService(Intent(this, T::class.java).setFlags(flags))
}

inline fun <reified T : Service> Context.startService(extras: Bundle) {
    startService(Intent(this, T::class.java).putExtras(extras))
}

inline fun <reified T : Service> Context.startService(extras: Bundle, flags: Int) {
    startService(Intent(this, T::class.java).putExtras(extras).setFlags(flags))
}

inline fun <reified T : Service> Context.stopService() {
    stopService(Intent(this, T::class.java))
}

inline fun <reified T : Activity> Activity.startForResult(code: Int) {
    startActivityForResult(Intent(this, T::class.java), code)
}

inline fun <reified T : Activity> Activity.startForResult(code: Int, flags: Int) {
    startActivityForResult(Intent(this, T::class.java).setFlags(flags), code)
}

inline fun <reified T : Activity> Activity.startForResult(code: Int, extras: Bundle) {
    startActivityForResult(Intent(this, T::class.java).putExtras(extras), code)
}

inline fun <reified T : Activity> Activity.startForResult(code: Int, extras: Bundle, flags: Int) {
    startActivityForResult(Intent(this, T::class.java).putExtras(extras).setFlags(flags), code)
}