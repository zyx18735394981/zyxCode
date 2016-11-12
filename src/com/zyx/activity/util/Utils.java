package com.zyx.activity.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;
/**
 * 在屏幕中央显示一个Toast
 * @param text
 */
public class Utils {
	public static void showToast(Context context,CharSequence text){
		Toast toast=Toast.makeText(context, text, Toast.LENGTH_SHORT);
		//显示在屏幕中央
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

}
