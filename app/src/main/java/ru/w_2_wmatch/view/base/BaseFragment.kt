package ru.w_2_wmatch.view.base

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import ru.w_2_wmatch.view.activity.OnHeaderChangeListener

abstract class BaseFragment : Fragment() {
    var listener: OnHeaderChangeListener? = null

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

        if (context is OnHeaderChangeListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnTextChangeListener")
        }
    }
}