package com.plantplaces.plantplaces14fs;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PlantSearchActivity extends PlantPlacesActivity {

	private static final int IMAGE_GALLERY = 100;
	private Bitmap selectedImage;
	private ImageView imgPlantSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.plantsearch_layout);
		imgPlantSearch = (ImageView) findViewById(R.id.imgPlantSearch);

	}


	@Override
	public int getCurrentMenuID() {
		// TODO Auto-generated method stub
		return R.id.plantSearch;
	}

	/**
	 * This method is invoked when the select a picture button is pressed.
	 * @param v
	 */
	public void onImageGalleryClicked(View v) {

		// we want to pick an image from a gallery, so specify the action pick.
		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

		// specify where to find the image, using data.

		// give me the path (file system directory) where we store images.
		String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();

		// Convert to URI, because that's what our Gallery is expecting.
		Uri picturesDirectory = Uri.parse(path);

		// set the data and type on this intent, so we tell it where to look for files, and 
		// what file types we want.
		photoPickerIntent.setDataAndType(picturesDirectory, "image/*");

		// start the activity, and tell it we want a result.
		startActivityForResult(photoPickerIntent, IMAGE_GALLERY);


	}

	public void onCameraClicked(View v) {

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			if (requestCode == IMAGE_GALLERY) {
				// if we are here, we got a response from the image gallery.

				// find the path of the selected image.
				Uri photoLocation = data.getData();

				// open this as a stream of data/bytes
				try {
					// a stream of data from the file.
					InputStream openInputStream = getContentResolver().openInputStream(photoLocation);
					// take a stream of data, and convert it to a Bitmap.
					selectedImage = BitmapFactory.decodeStream(openInputStream);

					// assign this image to our image view.
					imgPlantSearch.setImageBitmap(selectedImage);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					// alert the user that something went wrong.
					Toast.makeText(this, R.string.unable_to_open_image, Toast.LENGTH_LONG).show();
				}
			}
		}

	}

}
