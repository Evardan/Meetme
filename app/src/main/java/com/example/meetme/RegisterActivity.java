package com.example.meetme;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;  // Lottie importieren

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Referenzen zu den UI-Elementen
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        EditText confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        Button registerButton = findViewById(R.id.registerButton);

        // Referenz zur Lottie-Animation
        LottieAnimationView animationView = findViewById(R.id.animationView);

        // Button-Klicklistener hinzufügen
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Eingabewerte holen
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                // Validierung der Eingabefelder
                if (name.isEmpty()) {
                    nameEditText.setError("Bitte Name eingeben");
                } else if (email.isEmpty()) {
                    emailEditText.setError("Bitte E-Mail eingeben");
                } else if (password.isEmpty()) {
                    passwordEditText.setError("Bitte Passwort eingeben");
                } else if (confirmPassword.isEmpty()) {
                    confirmPasswordEditText.setError("Bitte Passwort bestätigen");
                } else if (!password.equals(confirmPassword)) {
                    confirmPasswordEditText.setError("Passwörter stimmen nicht überein");
                } else {
                    // Registrierung erfolgreich (jetzt kannst du hier die Daten weiterverarbeiten)
                    Toast.makeText(RegisterActivity.this, "Registrierung erfolgreich!", Toast.LENGTH_SHORT).show();

                    // Animation anzeigen und starten
                    animationView.setVisibility(View.VISIBLE);  // Animation sichtbar machen
                    animationView.playAnimation();  // Animation abspielen

                    // Warten Sie 5 Sekunden und kehren dann zum Login-Bildschirm zurück
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();  // Schließt die aktuelle Activity und kehrt zum Login zurück
                        }
                    }, 3000);  // 5000 Millisekunden = 3 Sekunden
                }
            }
        });
    }
}
