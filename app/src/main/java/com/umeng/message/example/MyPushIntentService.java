package com.umeng.message.example;

import org.android.agoo.client.BaseConstants;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;

import com.umeng.common.message.Log;
import com.umeng.message.UmengBaseIntentService;
import com.umeng.message.entity.UMessage;

/**
 * Developer defined push intent service. 
 * Remember to call {@link com.umeng.message.PushAgent#setPushIntentServiceClass(Class)}. 
 * @author lucas
 *
 */
public class MyPushIntentService extends UmengBaseIntentService{
	private static final String TAG = "FrozenFrog";
//MyPushIntentService.class.getName()
	@Override
	protected void onMessage(Context context, Intent intent) {
		super.onMessage(context, intent);
		try {
			String message = intent.getStringExtra(BaseConstants.MESSAGE_BODY);
			UMessage msg = new UMessage(new JSONObject(message));
			Log.e(TAG, "message="+message);
			Log.e(TAG, "custom="+msg.custom);
			Log.e(TAG, "接收到推送");
			// code  to handle message here
			// ...
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			Log.e(TAG, "异常");
		}
	}
}
