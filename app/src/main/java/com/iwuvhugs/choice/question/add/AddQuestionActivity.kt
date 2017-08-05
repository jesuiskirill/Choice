package com.iwuvhugs.choice.question.add

import android.support.v4.app.Fragment
import com.iwuvhugs.choice.SingleFragmentActivity

class AddQuestionActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return AddQuestionFragment.newInstance()
    }
}
