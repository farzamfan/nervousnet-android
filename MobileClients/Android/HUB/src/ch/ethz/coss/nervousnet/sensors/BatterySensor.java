package ch.ethz.coss.nervousnet.sensors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Handler;
import android.util.Log;
import ch.ethz.coss.nervousnet.vm.BatteryReading;

public class BatterySensor implements SensorStatusImplementation{

	public static final long SENSOR_ID = 0x0000000000000001L;

	private Context context;

	private BatteryReading reading;

	public BatterySensor(Context context) {
		this.context = context;
	}
	


	private List<BatteryListener> listenerList = new ArrayList<BatteryListener>();
	private Lock listenerMutex = new ReentrantLock();

	public interface BatteryListener {
		public void batterySensorDataReady(BatteryReading reading);
	}

	public void addListener(BatteryListener listener) {
		listenerMutex.lock();
		listenerList.add(listener);
		listenerMutex.unlock();
	}

	public void removeListener(BatteryListener listener) {
		listenerMutex.lock();
		listenerList.remove(listener);
		listenerMutex.unlock();
	}

	public void clearListeners() {
		listenerMutex.lock();
		listenerList.clear();
		listenerMutex.unlock();
	}

	public void readBattery() {
		IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		Intent batteryStatus = context.registerReceiver(null, ifilter);
		int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
		int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
		int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
		boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING
				|| status == BatteryManager.BATTERY_STATUS_FULL;
		int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
		boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
		boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
		float batteryPct = level / (float) scale;

		reading = extractBatteryData(batteryStatus);
		dataReady();
		
	
	}
	
	BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
	    int scale = -1;
	    int level = -1;
	    int voltage = -1;
	    int temp = -1;
	    @Override
	    public void onReceive(Context context, Intent batteryStatus) {
	        
	    	reading = extractBatteryData(batteryStatus);

	    	   Log.d("BatterySensor", "Received braoadcast - "+ reading.toString());
		        Log.d("BatterySensor", "level is "+level+"/"+scale+", temp is "+temp+", voltage is "+voltage);
		    
	    }
		
	};
	
	private BatteryReading extractBatteryData(Intent batteryStatus) {
		int temp = batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
        int volt = batteryStatus.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
        byte health = (byte) batteryStatus.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
		int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
		int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
		boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING
				|| status == BatteryManager.BATTERY_STATUS_FULL;
		int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
		boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
		boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
		float batteryPct = level / (float) scale;

        reading = new BatteryReading((int) (System.currentTimeMillis() / 1000), batteryPct, isCharging, usbCharge, acCharge, temp, volt, health);
        return reading;
	}

	/**
	 * @param batteryReading
	 */
	private void dataReady() {
	       Log.d("BatterySensor", "Data Ready called - "+reading.toString());
	  	 	
		listenerMutex.lock();
		for (BatteryListener listener : listenerList) {
			listener.batterySensorDataReady(reading);
		}
		listenerMutex.unlock();
	}
	
	
	public void start() {

		readBattery(); // read initial values
		
		//Register to listen.
		IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		context.registerReceiver(batteryReceiver, filter);  


	}

	void stop() {
		 context.unregisterReceiver(batteryReceiver);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.ethz.coss.nervousnet.sensors.SensorStatusImplementation#doCollect()
	 */
	@Override
	public void doCollect() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return
	 */
	@Override
	public BatteryReading getReading() {
	
		return reading;
	}

}