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

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.addTextWatcher(init: GooTextWatcher.() -> Unit) {
    addTextChangedListener(GooTextWatcher().apply(init))
}

class GooTextWatcher : TextWatcher {
    private var mBeforeAction: (() -> Unit)? = null
    private var mNowAction: (() -> Unit)? = null
    private var mAfterAction: (() -> Unit)? = null

    var before: Before = Before(null, 0, 0, 0)
    var now: Now = Now(null, 0, 0, 0)
    var after: After = After(null)

    override fun beforeTextChanged(_text: CharSequence?, _start: Int, _count: Int, _after: Int) {
        before.run {
            text = _text
            start = _start
            count = _count
            after = _after
        }
        mBeforeAction?.invoke()
    }

    override fun onTextChanged(_text: CharSequence?, _start: Int, _before: Int, _count: Int) {
        now.run {
            text = _text
            start = _start
            before = _before
            count = _count
        }
        mNowAction?.invoke()
    }

    override fun afterTextChanged(_editable: Editable?) {
        after.editable = _editable
        mAfterAction?.invoke()
    }

    fun beforeTextChanged(action: () -> Unit) {
        mBeforeAction = action
    }

    fun onTextChanged(action: () -> Unit) {
        mNowAction = action
    }

    fun afterTextChanged(action: () -> Unit) {
        mAfterAction = action
    }

    inner class Before(var text: CharSequence?, var start: Int, var count: Int, var after: Int)
    inner class Now(var text: CharSequence?, var start: Int, var before: Int, var count: Int)
    inner class After(var editable: Editable?)
}