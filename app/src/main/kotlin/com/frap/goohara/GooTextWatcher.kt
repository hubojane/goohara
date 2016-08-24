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
    private var mBeforeListener: ((CharSequence?, Int, Int, Int) -> Unit)? = null
    private var mNowListener: ((CharSequence?, Int, Int, Int) -> Unit)? = null
    private var mAfterListener: ((Editable?) -> Unit)? = null

    override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {
        mBeforeListener?.invoke(text, start, count, after)
    }

    override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
        mNowListener?.invoke(text, start, before, count)
    }

    override fun afterTextChanged(editable: Editable?) {
        mAfterListener?.invoke(editable)
    }

    fun beforeTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        mBeforeListener = listener
    }

    fun onTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        mNowListener = listener
    }

    fun afterTextChanged(listener: (Editable?) -> Unit) {
        mAfterListener = listener
    }
}