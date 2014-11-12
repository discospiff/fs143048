package com.plantplaces.plantplaces14fs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

public class PlantDetailFragment extends WebViewFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = super.onCreateView(inflater, container, savedInstanceState);
		
		// get the GUID from the managing activity.
		Bundle arguments = getArguments();
		int guid = arguments.getInt(PlantResultsManager.GUID2);
		
		// open the webview to the correct page.
		WebView webView = getWebView();
		webView.loadUrl("http://www.plantplaces.com/perl/viewplantdetails.pl?filter=plant&plant_ID=" + guid + "&source=mobile");
		webView.getSettings().setJavaScriptEnabled(true);
		
		return view;
	}

}
