package com.iwuvhugs.choice.question.add

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.*
import com.iwuvhugs.choice.ChoiceApplication
import com.iwuvhugs.choice.R
import com.iwuvhugs.choice.model.Question
import kotlinx.android.synthetic.main.fragment_add_question.*

class AddQuestionFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment {
            return AddQuestionFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_add_question, container, false)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_question_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_question -> {
                val title = question_title.editText?.text.toString()
                val description = question_description.editText?.text.toString()
                val question = Question(0, title, description)
                val handler = Handler()
                Thread({
                    ChoiceApplication.db?.questionDao()?.insert(question)
                    handler.post({
                        activity?.finish()
                    })
                }).start()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}