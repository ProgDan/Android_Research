package com.progdan.googlemapsv2;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {
	final int RQS_GooglePlayServices = 1;
	// Google Map
	private GoogleMap googleMap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Check status of Google Play Services
		int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

		// Check Google Play Service Available
		try {
		    if (status != ConnectionResult.SUCCESS) {
		        GooglePlayServicesUtil.getErrorDialog(status, this, RQS_GooglePlayServices).show();
		    }
		} catch (Exception e) {
		    Log.e("Error: GooglePlayServiceUtil: ", "" + e);
		}
		
		try {
			// Loading map
			initilizeMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// latitude and longitude
		double latitude = -23.633165;
		double longitude = -46.7394826;
		
		// create marker
		MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Igreja Batista do Morumbi");
		 
		// adding marker
		googleMap.addMarker(marker);
		
		// Moving Camera to a Location with animation
		CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latitude, longitude)).zoom(16).build();
		googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
		
		// Changing Map Type
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
		// Showing Current Location
		googleMap.setMyLocationEnabled(true);
		
		// Zooming Functionality
		googleMap.getUiSettings().setZoomGesturesEnabled(true);
		
		// Compass Functionality
		googleMap.getUiSettings().setCompassEnabled(true);
		
		// My Location Button
		googleMap.getUiSettings().setMyLocationButtonEnabled(true);
		
		// Map Rotate Gesture
		googleMap.getUiSettings().setRotateGesturesEnabled(true);
		
		googleMap.getUiSettings().setAllGesturesEnabled(true);
	}
	
    /**
     * function to load map. If map is not created it will create it for you
     **/
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
 
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),"Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
            }
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }
	

}
