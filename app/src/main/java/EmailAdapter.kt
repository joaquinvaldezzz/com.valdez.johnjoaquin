import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.valdez.johnjoaquin.R

class EmailAdapter(context: Context, private val emails: List<Email>) :
    ArrayAdapter<Email>(context, 0, emails) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val email = getItem(position)

        val view =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.email_item, parent, false)

        val emailFrom: TextView = view.findViewById(R.id.emailFrom)
        val emailSubject: TextView = view.findViewById(R.id.emailSubject)
        val emailPreview: TextView = view.findViewById(R.id.emailPreview)

        emailFrom.text = email?.from
        emailSubject.text = email?.subject
        emailPreview.text = email?.preview

        return view
    }
}