package com.iwuvhugs.choice.question.list

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.iwuvhugs.choice.ChoiceApplication
import com.iwuvhugs.choice.R
import com.iwuvhugs.choice.question.add.AddQuestionActivity
import kotlinx.android.synthetic.main.fragment_question_list.*

class QuestionListFragment : Fragment() {

    private var questionListAdapter: QuestionListAdapter? = null

    companion object {
        fun newInstance(): Fragment {
            return QuestionListFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        questionListAdapter = QuestionListAdapter()
    }

    override fun onResume() {
        super.onResume()
        val handler = Handler()
        Thread({
            val questions = ChoiceApplication.db?.questionDao()?.getQuestions()
            handler.post({
                if (questions != null) {
                    questionListAdapter!!.addQuestions(questions)
                }
            })
        }).start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question_list, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.question_list_menu, menu)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        question_list.layoutManager = LinearLayoutManager(context)
        question_list.adapter = questionListAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_question -> {
                val intent = Intent(context, AddQuestionActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}