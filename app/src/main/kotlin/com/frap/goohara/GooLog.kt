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

import android.util.Log

private val Any.tag: String
    get() = javaClass.simpleName

fun Any.v(msg: String) {
    if (Log.isLoggable(tag, Log.VERBOSE)) Log.v(tag, msg)
}

fun Any.d(msg: String) {
    if (Log.isLoggable(tag, Log.DEBUG)) Log.d(tag, msg)
}

fun Any.i(msg: String) {
    if (Log.isLoggable(tag, Log.INFO)) Log.i(tag, msg)
}

fun Any.w(msg: String) {
    if (Log.isLoggable(tag, Log.WARN)) Log.w(tag, msg)
}

fun Any.e(msg: String) {
    if (Log.isLoggable(tag, Log.ERROR)) Log.e(tag, msg)
}

fun Any.wtf(msg: String) {
    Log.wtf(tag, msg)
}