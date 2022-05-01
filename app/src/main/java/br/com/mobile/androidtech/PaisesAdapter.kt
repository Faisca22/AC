package br.com.mobile.androidtech

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PaisesAdapter (
    val  paises: List<Pais>,
    val onClick: (Pais) -> Unit

):RecyclerView.Adapter<PaisesAdapter.PaisesViewHolder>() {
    class PaisesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg: ImageView
        val cardProgess: ProgressBar
        val cardView: CardView


        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_img)

            cardProgess = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_paises)
        }
    }

    override fun getItemCount() = this.paises.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_pais, parent, false)
        val holder = PaisesViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: PaisesViewHolder, position: Int) {
        val pais = paises [position]
        holder.cardNome.text = pais.nome
        holder.cardProgess.visibility = View.VISIBLE
        Picasso.with(holder.itemView.context).load(pais.bandeira).into(holder.cardImg, object: com.squareup.picasso.Callback{
            override fun onSuccess() {
                holder.cardProgess.visibility = View.GONE
            }
            override fun onError() {

                holder.cardProgess.visibility = View.GONE
            }
        })
        holder.itemView.setOnClickListener{onClick(pais)}
    }
}
