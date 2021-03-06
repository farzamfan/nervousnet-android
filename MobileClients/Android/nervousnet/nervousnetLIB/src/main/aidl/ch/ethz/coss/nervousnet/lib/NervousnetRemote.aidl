package ch.ethz.coss.nervousnet.lib;

import ch.ethz.coss.nervousnet.lib.SensorReading;
import ch.ethz.coss.nervousnet.lib.RemoteCallback;

import java.util.List;

interface NervousnetRemote
	{
		/*
	 	* Returns latest Sensor values using callback
	    * sensorType = type of Sensor. Check LibConstants for types.
	    * startTime = from time , endTime = to time
	    * cb = Callback object with list that will contain the returned object of SensorReading
	    */
	    void getReading(long sensorType, RemoteCallback cb);
	    
	    /*
	 	* Returns Sensor values in a List of SensorReading Objects using callback
	    * sensorType = type of Sensors. Check LibConstants for types.
	    * startTime = from time , endTime = to time
	    * cb = Callback object with list that will contain the returned objects of SensorReadings
	    */
	    void getReadings(long sensorType, long startTime, long endTime,  RemoteCallback cb);
	    
	       
	   	/*
       	 	* Returns latest Sensor values.
       	    * sensorType = type of Sensor. Check LibConstants for types.
       	    * startTime = from time , endTime = to time
       	    * returns SensorReading object
       	    */
       	 SensorReading getLatestReading(long sensorType);
	}
	/*Methods to be added
	getAverage, getCorrelation, getEntropy, getKMeans,
	 getLargest, getMaxValue, getMeanSquare, getMedian,
	getMinValue, getRankLargest, getRankSmallest, getRms,
	 getRmsError, getSensorDescriptorList, getSmallest, getSum,
	  getSumSquare, getTimeRange, sd, var*/