package com.example.empowerherwellness;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MealsActivity extends AppCompatActivity {
    private TextView textSelectedMeal;
    private Spinner spinnerMealType;
    private LinearLayout videoContainer;
    private Map<String, List<String>> mealVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_selection);

        // Initialize Views
        spinnerMealType = findViewById(R.id.spinner_meal_type);
        textSelectedMeal = findViewById(R.id.text_selected_meal);
        videoContainer = findViewById(R.id.video_container);

        // Meal Options
        String[] mealOptions = {"Select Meal Type", "Veg", "Non-Veg", "Vegan", "Keto"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mealOptions);
        spinnerMealType.setAdapter(adapter);

        // Define Meal Type Videos
        mealVideos = new HashMap<>();
        mealVideos.put("Veg", List.of(
                "https://www.youtube.com/embed/nzNQ5lTmg1Q",
                "https://www.youtube.com/embed/GZo06HY96ew",
                "https://www.youtube.com/embed/TKEgCMyU65Q",
                "https://www.youtube.com/embed/We9_kIaCDFM",
                "https://www.youtube.com/embed/vN25AxvLb0k"
        ));
        mealVideos.put("Non-Veg", List.of(
                "https://www.youtube.com/watch?v=s13rTGimsWg",
                "https://www.youtube.com/watch?v=dqSLK_bZ7vs&list=PLamMOXFyxbDPD6q_v3f_5vIY1lCL-Tnw9",
                "https://www.youtube.com/watch?v=o_WDr77iNI4",
                "https://www.youtube.com/watch?v=rMOpaeKeHVI&list=PLZQX2m3asPSj98BxG6aaeJCr4MBLd-ei0",
                "http://youtube.com/watch?v=Q9InpWw9OEk"
        ));
        mealVideos.put("Vegan", List.of(
                "https://www.youtube.com/watch?v=xhHEiKFneVQ",
                "https://www.youtube.com/shorts/Jk1GilOtpyc",
                "https://www.youtube.com/watch?v=AF8ykw6IKQQ",
                "https://www.youtube.com/shorts/c4VeNsuOhkw",
                "https://www.youtube.com/shorts/jxgXTBOWCUI"
        ));
        mealVideos.put("Keto", List.of(
                "https://www.youtube.com/watch?v=bC0JJlBQK6M",
                "https://www.youtube.com/watch?v=2-dovKW9bjo",
                "https://www.youtube.com/watch?v=8nDC336Dgb0",
                "https://www.youtube.com/shorts/5Ur5kAyXVBo"
        ));

        // Spinner Selection Listener
        spinnerMealType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedMeal = parent.getItemAtPosition(position).toString();
                textSelectedMeal.setText("You selected: " + selectedMeal);

                // Remove previous WebViews
                videoContainer.removeAllViews();

                if (mealVideos.containsKey(selectedMeal)) {
                    // Load all videos for the selected meal type
                    for (String videoUrl : mealVideos.get(selectedMeal)) {
                        addYouTubeVideo(videoUrl);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                videoContainer.removeAllViews();
            }
        });
    }

    // Method to Add YouTube Video WebView with Spacing
    private void addYouTubeVideo(String url) {
        WebView webView = new WebView(this);
        webView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                600 // Adjust height as needed
        ));

        // Enable JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        // Load the YouTube embed URL
        webView.loadUrl(url);

        // Add margin to create spacing between videos
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                500  // Adjust height as needed
        );
        params.setMargins(0, 20, 0, 30); // 20dp top & bottom spacing
        webView.setLayoutParams(params);

        // Add WebView to the container
        videoContainer.addView(webView);
    }
}
