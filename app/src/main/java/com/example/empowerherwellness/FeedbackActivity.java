package com.example.empowerherwellness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    private RadioGroup radioGroupSatisfaction, radioGroupFeatures, radioGroupImprovement, radioGroupUsefulness;
    private EditText editTextComments;
    private Button btnSubmitFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // Initialize views
        radioGroupSatisfaction = findViewById(R.id.radioGroupSatisfaction);
        radioGroupFeatures = findViewById(R.id.radioGroupFeatures);
        radioGroupImprovement = findViewById(R.id.radiogroupIntuitiveNavigation);
        radioGroupUsefulness = findViewById(R.id.radiogroupUsefulApp);
        editTextComments = findViewById(R.id.editTextComments);
        btnSubmitFeedback = findViewById(R.id.btnSubmitFeedback);

        // Set up button click listener
        btnSubmitFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Process the feedback
                processFeedback();
            }
        });
    }

    private void processFeedback() {
        // Get selected satisfaction
        int selectedSatisfactionId = radioGroupSatisfaction.getCheckedRadioButtonId();
        RadioButton selectedSatisfaction = findViewById(selectedSatisfactionId);
        String satisfactionFeedback = selectedSatisfaction != null ? selectedSatisfaction.getText().toString() : "No answer";

        // Get selected feature
        int selectedFeatureId = radioGroupFeatures.getCheckedRadioButtonId();
        RadioButton selectedFeature = findViewById(selectedFeatureId);
        String featureFeedback = selectedFeature != null ? selectedFeature.getText().toString() : "No answer";

        // Get selected improvement suggestion
        int selectedImprovementId = radioGroupImprovement.getCheckedRadioButtonId();
        RadioButton selectedImprovement = findViewById(selectedImprovementId);
        String improvementFeedback = selectedImprovement != null ? selectedImprovement.getText().toString() : "No answer";

        // Get selected usefulness
        int selectedUsefulnessId = radioGroupUsefulness.getCheckedRadioButtonId();
        RadioButton selectedUsefulness = findViewById(selectedUsefulnessId);
        String usefulnessFeedback = selectedUsefulness != null ? selectedUsefulness.getText().toString() : "No answer";

        // Get additional comments
        String comments = editTextComments.getText().toString();

        // Display the feedback (You can replace this with your logic to store or send the feedback)
        String feedback = "Satisfaction: " + satisfactionFeedback + "\n" +
                "Feature of Interest: " + featureFeedback + "\n" +
                "Improvement Suggestion: " + improvementFeedback + "\n" +
                "Usefulness: " + usefulnessFeedback + "\n" +
                "Comments: " + comments;


        Button submitButton = findViewById(R.id.btnSubmitFeedback);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic to process the feedback

                // Once feedback is submitted, navigate to ThankYouActivity
                Intent intent = new Intent(FeedbackActivity.this, ThankYouActivity.class);
                startActivity(intent);
            }
        });
    }
}

