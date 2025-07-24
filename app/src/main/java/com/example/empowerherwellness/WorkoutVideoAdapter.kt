package com.example.empowerherwellness
import android.net.Uri
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkoutVideoAdapter(
    private val context: Context,
    private val videoList: List<WorkoutVideo>
) : RecyclerView.Adapter<WorkoutVideoAdapter.WorkoutViewHolder>() {

    class WorkoutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.video_title)
        val duration: TextView = view.findViewById(R.id.video_duration)
        val thumbnail: ImageView = view.findViewById(R.id.video_thumbnail)
        val playButton: ImageView = view.findViewById(R.id.btn_play_video)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_workout_video, parent, false)
        return WorkoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val video = videoList[position]
        holder.title.text = video.title
        holder.duration.text = video.duration
        holder.thumbnail.setImageResource(video.thumbnail)

        // Play Video on Click
        holder.playButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(video.videoUrl))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = videoList.size
}
