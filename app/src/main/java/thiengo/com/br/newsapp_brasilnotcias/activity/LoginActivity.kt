package thiengo.com.br.newsapp_brasilnotcias.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import thiengo.com.br.newsapp_brasilnotcias.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun callSignUp( view: View ) {
        startActivity(Intent(this, SignUpActivity::class.java))
    }
}
