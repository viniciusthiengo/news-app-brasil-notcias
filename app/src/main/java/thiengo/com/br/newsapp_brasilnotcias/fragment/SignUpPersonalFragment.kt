package thiengo.com.br.newsapp_brasilnotcias.fragment

import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sign_up_personal.*
import me.iwf.photopicker.PhotoPicker
import thiengo.com.br.newsapp_brasilnotcias.R
import thiengo.com.br.newsapp_brasilnotcias.logic.SignUpViewModel


class SignUpPersonalFragment :
        Fragment(),
        View.OnClickListener {

    var imgPath: String = ""
    var signUpViewModel: SignUpViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(
            R.layout.fragment_sign_up_personal,
            container,
            false)
        return view
    }

    override fun onClick(view: View?) {
        PhotoPicker.builder()
            .setPhotoCount(1)
            .setShowCamera(true)
            .setShowGif(true)
            .setPreviewEnabled(true)
            .start(activity, PhotoPicker.REQUEST_CODE);
    }

    fun updatePhoto( imgPath: String ){
        if( !imgPath.isEmpty() ){
            this.imgPath = imgPath
            iv_profile.setImageURI( Uri.parse( imgPath ) )
        }
    }


    override fun onStart() {
        super.onStart()

        signUpViewModel = ViewModelProviders
            .of(activity)
            .get(SignUpViewModel::class.java)

        iv_profile.setOnClickListener(this)
        updatePhoto( signUpViewModel?.user?.imagePath ?: "" )
        et_name.setText( signUpViewModel?.user?.name )
        et_profession?.setText( signUpViewModel?.user?.profession )
    }

    override fun onPause() {
        super.onPause()

        signUpViewModel?.updatePersonalData(
            imgPath,
            et_name.text.toString(),
            et_profession.text.toString() )
    }
}