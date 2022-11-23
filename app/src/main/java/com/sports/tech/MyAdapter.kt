package com.sports.tech

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sports.tech.databinding.ListItemBinding
import java.lang.StringBuilder
import java.time.Instant
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class MyAdapter(var list: List<Answer>): RecyclerView.Adapter<MyAdapter.Companion.MyHolder>() {

    companion object {
        class MyHolder(var binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

            public fun bind(ans: Answer) {
                binding.textView.text = ans.op1
                binding.textView2.text = ans.op2
                binding.textView3.text = ans.chemp
                var sb = StringBuilder("")
                for(i in ans.date.toCharArray()) if(i in '0'..'9') sb = sb.append(i)
                val instant: Instant = Instant.ofEpochSecond(sb.toString().toLong())
                binding.textView4.text = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("HH:mm"))

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return  list.size
    }
}