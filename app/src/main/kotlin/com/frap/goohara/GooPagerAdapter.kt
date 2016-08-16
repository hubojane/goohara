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

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager

fun ViewPager.setPagerAdapter(fm: FragmentManager, init: GooPagerAdapter.() -> Unit) {
    adapter = GooPagerAdapter(fm).apply(init)
}

class GooPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val mPages = arrayListOf<Page>()

    override fun getCount(): Int
            = mPages.size

    override fun getItem(position: Int): Fragment
            = mPages[position].fragment

    override fun getPageTitle(position: Int): CharSequence?
            = mPages[position].title

    fun addPage(fragment: Fragment, title: String? = null) {
        mPages.add(Page(fragment, title))
    }
}

class Page(val fragment: Fragment, val title: String?)