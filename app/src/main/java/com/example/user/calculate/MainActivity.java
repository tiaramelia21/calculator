package com.example.user.calculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText n1, n2;
    double x1, x2, result;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }

    private void setupView() {
        n1 = (EditText)findViewById(R.id.n1);
        n2 = (EditText)findViewById(R.id.n2);
        txtHasil = (TextView)findViewById(R.id.txtHasil);
    }

    public void reset(View v){
        if (v.getId() == R.id.cc){
            n1.setText("");
            n2.setText("");
            txtHasil.setText("");
        }
    }

    public void klik(View v){
        n1.setError(null);
        n2.setError(null);

        if (TextUtils.isEmpty(n1.getText().toString())){
            n1.setError("Tidak Boleh Kosong");
            n1.requestFocus();
        }else if (TextUtils.isEmpty(n2.getText().toString())){
            n2.setError("Tidak Boleh Kosong");
            n2.requestFocus();
        }else {
            x1 = Double.parseDouble(n1.getText().toString());
            x2 = Double.parseDouble(n2.getText().toString());
            switch (v.getId()){
                case R.id.tambah:
                    result = x1 + x2;
                    txtHasil.setText("Hasil : " + result);
                    return;
                case R.id.kurang:
                    result = x1 - x2;
                    txtHasil.setText("Hasil : " + result);
                    return;
                case R.id.bagi:
                    result = x1 / x2;
                    txtHasil.setText("Hasil : " + result);
                    return;
                case R.id.kali:
                    result = x1 * x2;
                    txtHasil.setText("Hasil : " + result);
                    return;
                case R.id.persen:
                    result = x1 * 0.01;
                    n2.setText("0");
                    txtHasil.setText("Hasil : " + result);
                    return;
                case R.id.kuadrat:
                    result = x1 * x1;
                    n2.setText("0");
                    txtHasil.setText("Hasil : " + result);
                    return;
                case R.id.akar:
                    result = Math.sqrt(x1) ;
                    n2.setText("0");
                    txtHasil.setText("Hasil : " + result);
                    return;
                default:
                    return;
            }
        }
    }
}
