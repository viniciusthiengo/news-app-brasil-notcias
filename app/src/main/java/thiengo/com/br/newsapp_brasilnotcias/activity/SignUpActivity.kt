package thiengo.com.br.newsapp_brasilnotcias.activity

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_sign_up.*
import me.iwf.photopicker.PhotoPicker
import thiengo.com.br.newsapp_brasilnotcias.R
import thiengo.com.br.newsapp_brasilnotcias.conf.SectionsPagerAdapter
import thiengo.com.br.newsapp_brasilnotcias.fragment.SignUpPersonalFragment
import thiengo.com.br.newsapp_brasilnotcias.logic.SignUpViewModel


class SignUpActivity : AppCompatActivity() {

    /**
     * O [android.support.v4.view.PagerAdapter] é que vai prover
     * fragments para cada seção / tab. Nós utilizamos um
     * {@link FragmentPagerAdapter} derivado, que vai manter
     * em memória todos os fragments carregados. Se isso se tornar
     * muito intenso na memória, pode ser uma melhor escolha
     * troca-lo por [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setSupportActionBar(toolbar)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)



        val signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)


        // Cria o adapter que vai retornar um fragment para cada uma das três
        // seções da atividade
        mSectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)

        // Configurando o ViewPager com as seções do adapter.
        container.adapter = mSectionsPagerAdapter

        container
            .addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs
            .addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

    override fun onStart() {
        super.onStart()
        toolbar.title = resources.getString(R.string.title_activity_sign_up)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(
            requestCode: Int,
            resultCode: Int,
            data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK
                && requestCode == PhotoPicker.REQUEST_CODE) {

            if (data != null) {
                val photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS)
                val fragment = supportFragmentManager
                        .findFragmentByTag("android:switcher:${container.id}:${mSectionsPagerAdapter?.getItemId(0)}")
                            as SignUpPersonalFragment

                fragment.updatePhoto( photos[0] )
            }
        }
    }
}
