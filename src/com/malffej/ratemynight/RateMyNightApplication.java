package com.malffej.ratemynight;

import android.app.Application;
import com.parse.Parse;

public class RateMyNightApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Parse.initialize(this, "yVfFYBKscczRe0qOIml6SxgDgcaCNWdD39HRkhUT",
				"dK6TSmrg5676sbJLFrpx1qbBXPzh5B9FVpofPHf5");
	}
}
