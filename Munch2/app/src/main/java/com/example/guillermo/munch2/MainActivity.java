package com.example.guillermo.munch2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button bRes = (Button) this.findViewById(R.id.restaurants);
        bRes.bringToFront();

    }
    public void pagos(View v){
        Intent i = new Intent(this,payment_method.class);
        startActivity(i);
    }
    public void friends(View v){
        Intent i = new Intent(this,FriendList.class);
        startActivity(i);

    }
    private Dialog dialogo(String msj){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(
                msj)
                .setCancelable(false)
                .setPositiveButton("Ir",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                //to perform on ok

                                Intent actividad =null;
                                actividad = new Intent(MainActivity.this,InviteFriends.class);
                                startActivity(actividad);
                            }
                        })
                .setNegativeButton("Regresar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {

                                //dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        Dialog dialog;
        dialog = alert;
        dialog.show();
        return dialog;
    }
    GoogleMap.OnMarkerClickListener listener = new GoogleMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {
           Dialog mensaje = dialogo(marker.getTitle());
            mensaje.show();

            return true;
        }
    };
    @Override
    public void onMapReady(GoogleMap map) {
        map.setOnMarkerClickListener(listener);
        GPSTracker gps = new GPSTracker(this);
        LatLng sydney = new LatLng(gps.getLatitude(), gps.getLongitude());
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16));
        map.addMarker(new MarkerOptions()
                .title("Your location")
                .snippet("This is you.")
                .position(sydney));

        //Santa fe Garden 19.357018, -99.258413
        final LatLng SantaFeGarden = new LatLng(19.357018, -99.258413);
        Marker sfg = map.addMarker(new MarkerOptions()
                .position(SantaFeGarden)
                .title("Santa Fe Garden")
                .snippet("")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        //Cozumel mariscos 19.357534, -99.257196
        final LatLng CozumelMarisco = new LatLng(19.357534, -99.257196);
        Marker cm = map.addMarker(new MarkerOptions()
                .position(CozumelMarisco)
                .title("Mariscos Cozumel")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        //El Fogon 19.357802, -99.256702
        final LatLng Fogon = new LatLng(19.357802, -99.256702);
        Marker f = map.addMarker(new MarkerOptions()
                .position(Fogon)
                .title("El Fogon")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        //Restaurante Guria Santa Fe 19.364342, -99.260771
        final LatLng Guria = new LatLng(19.364342, -99.260771);
        Marker g = map.addMarker(new MarkerOptions()
                .position(Guria)
                .title("Restaurante Guria Santa Fe")
                .snippet("PROMOCION: Platillo niños $69.90\n" +
                        "Tel: 01 55 5292 5544\n" +
                        "Calle Javier Barros Sierra, 555\n" +
                        "Álvaro Obregón\n" +
                        "Sta Fé\n" +
                        "01210 Ciudad de México, D.F.")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        //Cocina la Fe del Coral 19.356507, -99.259909
        final LatLng FeCoral = new LatLng(19.356507, -99.259909);
        Marker fc = map.addMarker(new MarkerOptions()
                .position(FeCoral)
                .title("Cocina la Fel del Coral")
                .snippet("PROMOCION: Buffet Adulto 2x1\n" +
                        "Tel: 01 55 6308 5159\nAv.Tamaulipas 127\n" +
                        "Santa Lucía Reacomodo, Álvaro Obregón\n" +
                        "15000 Ciudad de México, D.F.")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        //Antojitos Conchita 19.357341, -99.256342
        final LatLng Conchita = new LatLng(19.357341, -99.256342);
        Marker c = map.addMarker(new MarkerOptions()
                .position(Conchita)
                .title("Antojitos Conchita")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

    }
}
