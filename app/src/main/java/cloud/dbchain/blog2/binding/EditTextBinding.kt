package cloud.dbchain.blog2.binding

import android.widget.EditText
import android.widget.TextView

/**
 * @author: Xiao Bo
 * @date: 23/8/2021
 */
fun bindingLabelFocus(editText: EditText, labelTextView: TextView) {
    editText.setOnFocusChangeListener { _, hasFocus ->
        labelTextView.isSelected = hasFocus
    }
}