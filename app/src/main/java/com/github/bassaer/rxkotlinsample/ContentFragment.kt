package layout

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.github.bassaer.rxkotlinsample.R

/**
 * Created by nakayama on 2018/04/14.
 */
class ContentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_content, container, false)

        val input = rootView?.findViewById<EditText>(R.id.input_box)

        val button = rootView?.findViewById<Button>(R.id.exec_button)

        val listView = rootView?.findViewById<ListView>(R.id.repo_list)

        val itemList = mutableListOf<String>()

        val adapter = ArrayAdapter(activity, android.R.layout.simple_list_item_1, itemList)

        listView?.adapter = adapter

        button?.setOnClickListener {
            adapter.add(input?.text.toString())
            adapter.notifyDataSetChanged()
            input?.setText("")
            hideKeyboard()
        }

        return rootView
    }

    private fun hideKeyboard() {
        val view = activity.currentFocus
        if (view != null) {
            val manager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}