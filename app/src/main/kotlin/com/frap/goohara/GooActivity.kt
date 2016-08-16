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

import android.content.Context
import android.support.v7.widget.Toolbar
import android.widget.Toast
import android.support.v7.app.AppCompatActivity as Activity

fun Context.toast(resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
}

fun Context.toast(text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Context.longToast(resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_LONG).show()
}

fun Context.longToast(text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Activity.setToolbar(toolbar: Toolbar, _title: String? = null) {
    setSupportActionBar(toolbar)
    supportActionBar?.title = _title
}

fun Activity.setToolbar(toolbar: Toolbar, _title: String? = null, hasBackKey: Boolean) {
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        title = _title
        setDisplayHomeAsUpEnabled(hasBackKey)
    }
}