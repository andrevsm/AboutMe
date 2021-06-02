package br.com.avsm.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import br.com.avsm.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.doneButton.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(view: View) {
        dataBinding.apply {
            dataBinding.nicknameText.text = dataBinding.nicknameEdit.text
            invalidateAll()
            dataBinding.nicknameEdit.visibility = View.GONE
            dataBinding.doneButton.visibility = View.GONE
            dataBinding.nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}