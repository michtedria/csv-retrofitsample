package tayabas.anthony.retrofitsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import tayabas.anthony.retrofitsample.databinding.ActivityViewContactBinding
import tayabas.anthony.retrofitsample.model.Data

class ViewContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contact = intent.getParcelableExtra<Data>(EXTRA_MESSAGE)
        contact.let {
            with(binding) {
                val name = "${it?.firstName} ${it?.lastName}"
                val id = it?.id
                val email = it?.email
                val image = it?.avatar
                tvName.text = "Name: $name"
                tvId.text = "ID: $id"
                tvEmail.text = "Email: $$email"
                Glide.with(this@ViewContactActivity)
                    .load(image)
                    .into(ivAvatar)
            }
        }
    }
    companion object {
        const val EXTRA_MESSAGE = "MESSAGE"
    }
}
