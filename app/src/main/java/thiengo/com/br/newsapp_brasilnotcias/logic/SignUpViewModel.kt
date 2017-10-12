package thiengo.com.br.newsapp_brasilnotcias.logic

import android.arch.lifecycle.ViewModel
import thiengo.com.br.newsapp_brasilnotcias.domain.User


class SignUpViewModel: ViewModel() {

    val user: User

    init {
        user = User()
    }

    fun updatePersonalData(
        imagePath: String,
        name: String,
        profession: String){

        user.imagePath = imagePath
        user.name = name
        user.profession = profession
    }

    fun updateAccessData(email: String, password: String){
        user.email = email
        user.password = password
    }

    fun updateTermsData(terms: Boolean){
        user.statusTerms = terms
    }
}