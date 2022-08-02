package tayabas.anthony.retrofitsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tayabas.anthony.retrofitsample.databinding.ItemUserBinding
import tayabas.anthony.retrofitsample.model.Data

class ContactsAdapter (
    private val dataset: List<Data>,
 //   private val onItemClick: (position: Int, view: View) -> Unit
    ): RecyclerView.Adapter<ContactsAdapter.ListOfContactsViewHolder>() {

    class ListOfContactsViewHolder(val binding: ItemUserBinding
 //       onItemClick: (position: Int, view: View) -> Unit
    ) : RecyclerView.ViewHolder(binding.root)

    /*{
        init {
            itemView.setOnClickListener { view ->
                onItemClick(adapterPosition, view)
            }
        }
    }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfContactsViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListOfContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListOfContactsViewHolder, position: Int) {
        val item = dataset[position]
        holder.itemView.apply {
            with(holder.binding) {
                val name = "${item.firstName} ${item.lastName}"
                tvName.text = "Name: $name"
                tvEmail.text = item.email
                val url = item.avatar
                Glide.with(context)
                    .load(url)
                    .into(ivAvatar)
            }
            setOnClickListener{
                onItemClickListener?.let {
                    it(item)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
    private var onItemClickListener: ((Data) -> Unit)? = null
    fun  setOnItemClickListener(listener: (Data) -> Unit) {
        onItemClickListener = listener
    }
}

