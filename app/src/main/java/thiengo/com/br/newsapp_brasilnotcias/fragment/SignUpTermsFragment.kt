package thiengo.com.br.newsapp_brasilnotcias.fragment

import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_sign_up_terms.*
import me.drakeet.materialdialog.MaterialDialog
import thiengo.com.br.newsapp_brasilnotcias.R
import thiengo.com.br.newsapp_brasilnotcias.logic.SignUpViewModel


class SignUpTermsFragment :
        Fragment(),
        CompoundButton.OnCheckedChangeListener,
        View.OnClickListener {

    var signUpViewModel: SignUpViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(
            R.layout.fragment_sign_up_terms,
            container,
            false)

        return view
    }

    override fun onCheckedChanged(
        view: CompoundButton?,
        status: Boolean) {

        bt_send.isEnabled = status
    }

    override fun onClick(view: View?) {

        val layout = LayoutInflater
            .from(activity)
            .inflate(R.layout.dialog_personal, null, false)

        val tvName = layout.findViewById<TextView>(R.id.tv_name)
        tvName.text = signUpViewModel?.user?.name

        val tvProfession = layout.findViewById<TextView>(R.id.tv_profession)
        tvProfession.text = signUpViewModel?.user?.profession

        val uriImg = Uri.parse( signUpViewModel?.user?.imagePath )
        val ivProfile = layout.findViewById<ImageView>(R.id.iv_profile)
        ivProfile.setImageURI( uriImg )

        MaterialDialog(activity)
            .setContentView( layout )
            .setCanceledOnTouchOutside(true)
            .show()
    }


    override fun onStart() {
        super.onStart()

        signUpViewModel = ViewModelProviders
            .of(activity)
            .get(SignUpViewModel::class.java)

        /**
         * COM AS LINHAS DE CÓDIGO ABAIXO FORAM REMOVIDOS OS findViewById()
         * DO onCreateView().
         */
        cb_terms.setOnCheckedChangeListener(this)
        bt_send.setOnClickListener(this)

        onCheckedChanged(null, signUpViewModel?.user?.statusTerms ?: false)
    }

    override fun onPause() {
        super.onPause()

        signUpViewModel?.updateTermsData( cb_terms.isChecked )
    }
}