package com.example.templateapplication.toolbar

import android.content.Context
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import com.example.templateapplication.R

class MainToolBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = androidx.appcompat.R.attr.toolbarStyle
) : Toolbar(context, attrs, defStyleAttr) {

    init {
        title = context.getString(R.string.app_name)
        subtitle = context.getString(R.string.app_slogan)
        background = AppCompatResources.getDrawable(context, R.color.themePrimary)
        navigationIcon = AppCompatResources.getDrawable(context, R.drawable.baseline_arrow_back_24)
    }

    fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    fun onOptionsItemSelected(item: MenuItem): Boolean {
        val selectedItem = when(item.itemId){
            R.id.menu_item_setting -> {
                true
            }
            else -> {true}
        }
        return selectedItem
    }
}
