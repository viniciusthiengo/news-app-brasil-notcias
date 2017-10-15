package thiengo.com.br.newsapp_brasilnotcias.domain


class User(
    var email: String = "",
    var password: String = "",
    var name: String = "",
    var profession: String = "",
    var imagePath: String = "",
    var statusTerms: Boolean = false )