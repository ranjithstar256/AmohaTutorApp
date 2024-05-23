package ran.am.amohatutorapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TutorsAdapter extends RecyclerView.Adapter<TutorsAdapter.TutorViewHolder> {

    private List<Tutor> tutorsList;

    public TutorsAdapter(List<Tutor> tutorsList) {
        this.tutorsList = tutorsList;
    }

    @NonNull
    @Override
    public TutorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutor, parent, false);
        return new TutorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TutorViewHolder holder, int position) {
        Tutor tutor = tutorsList.get(position);
        holder.textViewName.setText(tutor.getName());
        holder.textViewMobile.setText(tutor.getMobile());
        holder.textViewTechnicalExpertise.setText(tutor.getTechnicalExpertise());
        holder.textViewMail.setText(tutor.getMail());
        holder.textViewDescription.setText(tutor.getDescription());
    }

    @Override
    public int getItemCount() {
        return tutorsList.size();
    }

    class TutorViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewMobile, textViewTechnicalExpertise, textViewMail, textViewDescription;

        public TutorViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewMobile = itemView.findViewById(R.id.textViewMobile);
            textViewTechnicalExpertise = itemView.findViewById(R.id.textViewTechnicalExpertise);
            textViewMail = itemView.findViewById(R.id.textViewMail);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
