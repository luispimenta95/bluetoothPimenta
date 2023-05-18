package com.example.bluetoothpimenta;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txtBluetooth;
    private Button btnBluetooth;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        txtBluetooth = (TextView) findViewById(R.id.txtBluetooth);
        btnBluetooth = (Button) findViewById(R.id.btnBluetooth);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        btnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if(bluetoothAdapter== null){
                showMessage("Nenhum dispositivo Bluetooth encontrado");

             }
             if(bluetoothAdapter.isEnabled()){
                 showMessage("Bluetooh está ligado");

             }

            }
        });

}

    public void showMessage(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}