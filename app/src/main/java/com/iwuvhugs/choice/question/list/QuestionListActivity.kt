package com.iwuvhugs.choice.question.list

import android.support.v4.app.Fragment
import com.iwuvhugs.choice.SingleFragmentActivity

class QuestionListActivity : SingleFragmentActivity() {
    
    override fun createFragment(): Fragment {
        return QuestionListFragment.newInstance()
    }
}
