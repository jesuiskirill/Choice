package com.iwuvhugs.choice.question.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.iwuvhugs.choice.databinding.ViewQuestionListItemBinding
import com.iwuvhugs.choice.model.Question

class QuestionListAdapter : RecyclerView.Adapter<QuestionViewHolder>() {

    private var questionList = ArrayList<Question>()

    fun addQuestions(list: List<Question>) {
        questionList.clear()
        questionList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = ViewQuestionListItemBinding.inflate(LayoutInflater.from(parent.context))
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int = questionList.size

    override fun onBindViewHolder(holder: QuestionViewHolder?, position: Int) {
        holder?.bindQuestion(questionList.get(position))
    }
}

class QuestionViewHolder(private var binding: ViewQuestionListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindQuestion(question: Question) {
        binding.questionTitle.text = question.description
    }

}
