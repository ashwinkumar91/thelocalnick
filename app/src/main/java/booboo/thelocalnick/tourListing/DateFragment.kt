package booboo.thelocalnick.tourListing

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import booboo.thelocalnick.R



class DateFragment : DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mainview = inflater.inflate(R.layout.date_picker_layout, container, false)
        return mainview
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            dialog.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val saveButton = view.findViewById(R.id.date_save)
        saveButton.setOnClickListener{
            val date = view.findViewById(R.id.datePicker) as DatePicker
            val dateText = activity.findViewById(R.id.date) as TextView
            val dateEdited = date.month.toString() + "/" + date.dayOfMonth + "/" + date.year
            dateText.text = dateEdited
            dismiss()
        }
    }
}
