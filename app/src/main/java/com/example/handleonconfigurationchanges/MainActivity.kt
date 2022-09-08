package com.example.handleonconfigurationchanges

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    /*bài học thay đổi cấu hình: khi ta xoay man hình, hiện bàn phím, thay đổi kích thướt làm cho
    activity fragment bị destroy vòng đời -> giải pháp có 2 cách
        + cách 1 (ưu tiên): giữ lại data khi xoay màn hình, data sẽ ko bị reset khi xoay màn hình,
        dùng viewModel(), onSaveInsanceState.
        + cách 2 (ko ưu tiên): dùng onConfigurationChange() của activity, khi xoay màn hình nó sẽ chay vô
        fun này từ đó ta quyết định làm gì.*/
    /*---------------------------------------------------------------------------------*/

    // vd cách 1
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

    }
    // vd cách 2
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "dsad", Toast.LENGTH_SHORT).show()
        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "123", Toast.LENGTH_SHORT).show()
        }
    }

}