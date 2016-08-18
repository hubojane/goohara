# Goohara
Android Kotlin Library for Code Diet
* really easy to use
* simplify your code
```kotlin
class ExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)

        d("Activity Created")
        setToolbar(tb_activity_exmaple, "example")

        vp_activity_example.setPagerAdapter(supportFragmentManager) {
            addPage(PostListFragment(), "post")
            addPage(NoticeListFragment(), "notice")
        }
        
        postDelayed(3000) {
            vp_activity_example.setCurrentItem(1, false)
        }
    }
}
```
## Getting started
### Dependency
```groovy
dependencies {
    compile 'com.frap:goohara:0.1.0'
}
```
## Usage in code
### pagerAdapter
```kotlin
yourViewPager.setPagerAdapter {
    addPage(FirstFragment(), "fistTitle")
    addPage(SecondFragment())
    addPage(ThirdFragment(), "thirdTitle")
    ...
}
```
### textWatcher
```kotlin
yourEditText.addTextWatcher {
    beforeTextChanged {
        textView.text = before.text
        ...
    }
    onTextChanged {
        countTextView.text = "${now.text}/100"
        isTextValid = now.text.isNullOrBlank().not()
        ...
    }
    ...
}
```
### toast
```kotlin
//short Toast
toast(R.string.toast_text)
toast("kara is best idol")

//long Toast
longToast(R.string.toast_text)
longToast("goohara is so beautiful")
```
### toolbar
```kotlin
//basic toolbar
setToolbar(yourToolbar)

//If you want to set toolbar Title
setToolbar(yourToolbar, "title")

//If you want to set displayHomeAsUpEnabled
setToolbar(yourToolbar, "title", true)
```
### handler
```kotlin
async {
    doSomething()
    ...
}

post {
    doSomething()
    ...
}

postAtTime(uptimeMillis) {
    doSomething()
    ...
}

postDelayed(delayMillis) {
    doSomething()
    ...
}
```
### log
```kotlin
v("Eontteut gwaenchanne nae nune jom deureoone")
d("Nune ttuine saljjak jogeum gwansimi gane")
i("Ttokttak ttokttak sigyeman jakkujakku heulleoga")
w("Heulkki teulkkit siseonman jakkujakku neol hyanghae")
e("Banggeut banggeut misoman useumgeuman heulligo")
wtf("Ijen ijen yeogilbwa Hey! ")
```
> lyrics : kara - mister

### intent
```kotlin
//basic intent
startActivity<SecondActivity>()

//intent with flags
startActivity<SecondActivity>(flags)

//intent with bundle
startActivity<SecondActivity>(bundle)

//intent with bundle and flags
startActivity<SecondActivity>(bundle, flags)

//use startService
startService<YourService>(bundle)
startService<YourServie>(flags)
startService<YourServie>(flags)
startService<YourService>(bundle, flags)

//use startActivityForResult
startForResult<SecondActivity>(code)
startForResult<SecondActivity>(code, flags)
startForResult<SecondActivity>(code, bundle)
startForResult<SecondActivity>(code, bundle, flags)
```
### api checker
```kotlin
//if minApi <= Build.VERSION.SDK_INT
ApiOver(Build.VERSION_CODES.FROYO) {
    doSomeThing()
    ...
}

//if maxApi >= Build.VERSION.SDK_INT
ApiUnder(Build.VERSION_CODES.LOLLIPOP) {
    doSomeThing()
    ...
}

//if minApi <= Build.VERSION.SDK_INT <= maxApi
ApiRange(Build.VERSION_CODES.FROYO, Build.VERSION_CODES.LOLLIPOP) {
    doSomeThing()
    ...
}
```
## License
```
Copyright 2016 Frap

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
