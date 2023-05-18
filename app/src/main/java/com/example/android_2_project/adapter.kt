import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_2_project.Book
import com.example.android_2_project.R

class BookAdapter(private val documents: List<Book>) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
       // val image: TextView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

//        val root = LayoutInflater.from(activity).inflate(R.layout.Book.item,parent,false)
//        return ViewHolder(root)
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val document = documents[position]
        holder.nameTextView.text = document.name
        holder.descriptionTextView.text = document.description
      //  holder.image.text = document.image

    }

    override fun getItemCount() = documents.size
}
