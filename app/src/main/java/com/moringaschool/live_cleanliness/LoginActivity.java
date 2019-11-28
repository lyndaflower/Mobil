package com.moringaschool.live_cleanliness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = LoginActivity.class.getSimpleName();

    private TextView registerEdit;
    private EditText mPasswordEdit;
    private EditText mEmailEdit;
    private Button mPassword;
private DatabaseReference RootRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registerEdit = (TextView) findViewById(R.id.registerTextView);
        mEmailEdit = (EditText) findViewById(R.id.email);
        mPassword = (Button) findViewById(R.id.loginButton);
        mPasswordEdit = (EditText) findViewById(R.id.password);
RootRef= FirebaseDatabase.getInstance().getReference();
        registerEdit.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        mPassword.setOnClickListener(this);
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
//                    Intent intent = new Intent(LogInActivity.this, newMainActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                    finish();
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        if (v == registerEdit) {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }
        if (v == mPassword) {
            loginWithPassword();
        }

    }

    private void loginWithPassword() {
        FirebaseUser user = mAuth.getCurrentUser();
        String email = mEmailEdit.getText().toString().trim();
        String password = mPasswordEdit.getText().toString().trim();

        if (email.equals("")) {
            mEmailEdit.setError("Please enter your email");
            return;
        }
        if (password.equals("")) {
            mPasswordEdit.setError("Password can not be blank ");
            return;
        }

//        }
        else {
String currentUserID=mAuth.getCurrentUser().getUid();
RootRef.child(currentUserID).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if (dataSnapshot.child("name").exists()){
            Toast.makeText(LoginActivity.this, " Welcome", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
            Toast.makeText(LoginActivity.this, "Verifiy your email",
                    Toast.LENGTH_SHORT).show();
            mAuth.signOut();

        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Intent intent = new Intent(LoginActivity.this,HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail", task.getException());
                            Toast.makeText(LoginActivity.this, "You log in to mobil...",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}