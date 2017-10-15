package thiengo.com.br.newsapp_brasilnotcias.conf

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import thiengo.com.br.newsapp_brasilnotcias.activity.SignUpActivity
import thiengo.com.br.newsapp_brasilnotcias.fragment.SignUpAccessFragment
import thiengo.com.br.newsapp_brasilnotcias.fragment.SignUpPersonalFragment
import thiengo.com.br.newsapp_brasilnotcias.fragment.SignUpTermsFragment


/**
 * Um [FragmentPagerAdapter] que retorna um fragment correspondente a
 * uma das seções/tabs/pages.
 */
class SectionsPagerAdapter(activity: SignUpActivity, fm: FragmentManager):
        FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem é invocado para instanciar o fragment da tab informada.

        return when( position ){
            0 -> SignUpPersonalFragment()
            1 -> SignUpAccessFragment()
            else -> SignUpTermsFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}
