package com.daniel.ankolayout

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)
                val name = editText {
                    hint = "What's your name?"
                }

                button("Say Hello") {
                    backgroundColor = ContextCompat.getColor(context,R.color.colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        toast("Hello, ${name.text}!")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
                button("Show Alert")
                {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        alert("Happy Coding", "My name, ${name.text}!"){
                            yesButton { toast("Oh.. yess") }
                            noButton {  }
                        }.show()
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                button("Show Selector"){
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        val club = listOf("Barcelona", "Real Madril", "MU","PSMS MEDAN")
                        selector("Hello, ${name.text}! What's footbal club do you love? ", club){ _,i ->
                            toast("So you love ${club[i]}, right?")
                        }
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
                button("Show Snackbar"){
                    backgroundColor = ContextCompat.getColor(context,R.color.colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        snackbar("hello, ${name.text}!")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
                button("Go to Second Activity"){
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
            }
        }

    }
}
