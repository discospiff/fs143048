package com.plantplaces.plantplaces14fs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

public class GPSAPlantActivity extends PlantPlacesActivity implements LocationListener {

	private static final int CAMERA_ACTIVITY = 10;
	private AutoCompleteTextView actPlantName;
	private ImageView imgPlantPhoto;
	private LocationManager locationManager;
	private TextView txtLatitude;
	private TextView txtLongitudeValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gpsaplant);
		
		txtLongitudeValue = (TextView) findViewById(R.id.txtLongitudeValue);
		txtLongitudeValue.setText("1");
		
		txtLatitude = (TextView) findViewById(R.id.txtLatidude);
	
		// this will give us access to widgets that are on our form
		actPlantName = (AutoCompleteTextView) findViewById(R.id.actPlantName);
		
		imgPlantPhoto = (ImageView) findViewById(R.id.imgPlantPhoto);
		
		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
	
	}

	/**
	 * This method will be invoked when the search button is clicked.
	 * This will handle searching for the given plant
	 * @param v
	 */
	public void btnSearchClicked(View v) {
		// get the text that the user entered into the auto complete text.
		String plantName = actPlantName.getText().toString();
		
		// make a popup
		// Toast.makeText(this, plantName, Toast.LENGTH_LONG).show();
		
		Intent plantResults = new Intent(this, PlantResultsActivity.class);
		plantResults.putExtra("PLANT_NAME", plantName);
		startActivity(plantResults);
	}

	@Override
	public int getCurrentMenuID() {
		// TODO Auto-generated method stub
		return R.id.gpsAPlant;
	}

	public void takePhotoClicked(View v) {
		// We are invoking the camera, but we are NOT saving the image to the SDCard, because we did not pass in 
		// an EXTRA indicating where to save the image.
		Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(cameraIntent, CAMERA_ACTIVITY);

	}
	
	@Override
 	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
 		if (resultCode == RESULT_OK) {
 			if (requestCode == CAMERA_ACTIVITY) {
 				// get the image that the user took
 				Bitmap cameraImage = (Bitmap) data.getExtras().get("data");
 				// show this image to the user.
 				imgPlantPhoto.setImageBitmap(cameraImage);
 			}
 		}
 	}

	/**
	 * Tell the LocationListener about the LocationManager.
	 */
	private void requestUpdates() {
		if (locationManager != null) {
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60 * 1000, 0, this);
		}
	}
	
	@Override
	public void onLocationChanged(Location location) {
		txtLatitude.setText("" + location.getLatitude());
		txtLongitudeValue.setText("" + location.getLongitude());
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		removeLocationUpdates();
	}

	private void removeLocationUpdates() {
		locationManager.removeUpdates(this);
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		requestUpdates();
	}
	
}
