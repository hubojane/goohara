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

import android.os.Build

private val version: Int
    get() = Build.VERSION.SDK_INT

fun ApiUnder(maxValue: Int, action: () -> Unit) {
    if (version <= maxValue) action()
}

fun ApiOver(minValue: Int, action: () -> Unit) {
    if (version >= minValue) action()
}

fun ApiRange(minValue: Int, maxValue: Int, action: () -> Unit) {
    if (minValue <= version && version <= maxValue) action()
}