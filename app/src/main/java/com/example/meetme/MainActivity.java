package com.example.meetme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenzen zu den UI-Elementen
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button signInButton = findViewById(R.id.signInButton);

        // Button-Klicklistener hinzufügen
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validierung: Prüfen, ob die Felder ausgefüllt sind
                if (email.isEmpty()) {
                    emailEditText.setError("Bitte Email eingeben");
                } else if (password.isEmpty()) {
                    passwordEditText.setError("Bitte Passwort eingeben");
                } else {
                    // Mock-Login-Prozess (später Firebase-Integration)
                    if (email.equals("test@example.com") && password.equals("password123")) {
                        Toast.makeText(MainActivity.this, "Login erfolgreich!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Ungültige Anmeldedaten", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
