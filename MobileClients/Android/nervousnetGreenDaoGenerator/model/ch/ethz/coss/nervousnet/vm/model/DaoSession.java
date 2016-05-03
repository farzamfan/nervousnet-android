package ch.ethz.coss.nervousnet.vm.model;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import ch.ethz.coss.nervousnet.vm.model.Config;
import ch.ethz.coss.nervousnet.vm.model.Authentication;
import ch.ethz.coss.nervousnet.vm.model.LocationData;
import ch.ethz.coss.nervousnet.vm.model.AccelData;
import ch.ethz.coss.nervousnet.vm.model.BatteryData;
import ch.ethz.coss.nervousnet.vm.model.BeaconData;
import ch.ethz.coss.nervousnet.vm.model.ConnectivityData;
import ch.ethz.coss.nervousnet.vm.model.GyroData;
import ch.ethz.coss.nervousnet.vm.model.HumidityData;
import ch.ethz.coss.nervousnet.vm.model.LightData;
import ch.ethz.coss.nervousnet.vm.model.MagneticData;
import ch.ethz.coss.nervousnet.vm.model.NoiseData;
import ch.ethz.coss.nervousnet.vm.model.PressureData;
import ch.ethz.coss.nervousnet.vm.model.ProximityData;
import ch.ethz.coss.nervousnet.vm.model.TemperatureData;
import ch.ethz.coss.nervousnet.vm.model.Packet;

import ch.ethz.coss.nervousnet.vm.model.ConfigDao;
import ch.ethz.coss.nervousnet.vm.model.AuthenticationDao;
import ch.ethz.coss.nervousnet.vm.model.LocationDataDao;
import ch.ethz.coss.nervousnet.vm.model.AccelDataDao;
import ch.ethz.coss.nervousnet.vm.model.BatteryDataDao;
import ch.ethz.coss.nervousnet.vm.model.BeaconDataDao;
import ch.ethz.coss.nervousnet.vm.model.ConnectivityDataDao;
import ch.ethz.coss.nervousnet.vm.model.GyroDataDao;
import ch.ethz.coss.nervousnet.vm.model.HumidityDataDao;
import ch.ethz.coss.nervousnet.vm.model.LightDataDao;
import ch.ethz.coss.nervousnet.vm.model.MagneticDataDao;
import ch.ethz.coss.nervousnet.vm.model.NoiseDataDao;
import ch.ethz.coss.nervousnet.vm.model.PressureDataDao;
import ch.ethz.coss.nervousnet.vm.model.ProximityDataDao;
import ch.ethz.coss.nervousnet.vm.model.TemperatureDataDao;
import ch.ethz.coss.nervousnet.vm.model.PacketDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig configDaoConfig;
    private final DaoConfig authenticationDaoConfig;
    private final DaoConfig locationDataDaoConfig;
    private final DaoConfig accelDataDaoConfig;
    private final DaoConfig batteryDataDaoConfig;
    private final DaoConfig beaconDataDaoConfig;
    private final DaoConfig connectivityDataDaoConfig;
    private final DaoConfig gyroDataDaoConfig;
    private final DaoConfig humidityDataDaoConfig;
    private final DaoConfig lightDataDaoConfig;
    private final DaoConfig magneticDataDaoConfig;
    private final DaoConfig noiseDataDaoConfig;
    private final DaoConfig pressureDataDaoConfig;
    private final DaoConfig proximityDataDaoConfig;
    private final DaoConfig temperatureDataDaoConfig;
    private final DaoConfig packetDaoConfig;

    private final ConfigDao configDao;
    private final AuthenticationDao authenticationDao;
    private final LocationDataDao locationDataDao;
    private final AccelDataDao accelDataDao;
    private final BatteryDataDao batteryDataDao;
    private final BeaconDataDao beaconDataDao;
    private final ConnectivityDataDao connectivityDataDao;
    private final GyroDataDao gyroDataDao;
    private final HumidityDataDao humidityDataDao;
    private final LightDataDao lightDataDao;
    private final MagneticDataDao magneticDataDao;
    private final NoiseDataDao noiseDataDao;
    private final PressureDataDao pressureDataDao;
    private final ProximityDataDao proximityDataDao;
    private final TemperatureDataDao temperatureDataDao;
    private final PacketDao packetDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        configDaoConfig = daoConfigMap.get(ConfigDao.class).clone();
        configDaoConfig.initIdentityScope(type);

        authenticationDaoConfig = daoConfigMap.get(AuthenticationDao.class).clone();
        authenticationDaoConfig.initIdentityScope(type);

        locationDataDaoConfig = daoConfigMap.get(LocationDataDao.class).clone();
        locationDataDaoConfig.initIdentityScope(type);

        accelDataDaoConfig = daoConfigMap.get(AccelDataDao.class).clone();
        accelDataDaoConfig.initIdentityScope(type);

        batteryDataDaoConfig = daoConfigMap.get(BatteryDataDao.class).clone();
        batteryDataDaoConfig.initIdentityScope(type);

        beaconDataDaoConfig = daoConfigMap.get(BeaconDataDao.class).clone();
        beaconDataDaoConfig.initIdentityScope(type);

        connectivityDataDaoConfig = daoConfigMap.get(ConnectivityDataDao.class).clone();
        connectivityDataDaoConfig.initIdentityScope(type);

        gyroDataDaoConfig = daoConfigMap.get(GyroDataDao.class).clone();
        gyroDataDaoConfig.initIdentityScope(type);

        humidityDataDaoConfig = daoConfigMap.get(HumidityDataDao.class).clone();
        humidityDataDaoConfig.initIdentityScope(type);

        lightDataDaoConfig = daoConfigMap.get(LightDataDao.class).clone();
        lightDataDaoConfig.initIdentityScope(type);

        magneticDataDaoConfig = daoConfigMap.get(MagneticDataDao.class).clone();
        magneticDataDaoConfig.initIdentityScope(type);

        noiseDataDaoConfig = daoConfigMap.get(NoiseDataDao.class).clone();
        noiseDataDaoConfig.initIdentityScope(type);

        pressureDataDaoConfig = daoConfigMap.get(PressureDataDao.class).clone();
        pressureDataDaoConfig.initIdentityScope(type);

        proximityDataDaoConfig = daoConfigMap.get(ProximityDataDao.class).clone();
        proximityDataDaoConfig.initIdentityScope(type);

        temperatureDataDaoConfig = daoConfigMap.get(TemperatureDataDao.class).clone();
        temperatureDataDaoConfig.initIdentityScope(type);

        packetDaoConfig = daoConfigMap.get(PacketDao.class).clone();
        packetDaoConfig.initIdentityScope(type);

        configDao = new ConfigDao(configDaoConfig, this);
        authenticationDao = new AuthenticationDao(authenticationDaoConfig, this);
        locationDataDao = new LocationDataDao(locationDataDaoConfig, this);
        accelDataDao = new AccelDataDao(accelDataDaoConfig, this);
        batteryDataDao = new BatteryDataDao(batteryDataDaoConfig, this);
        beaconDataDao = new BeaconDataDao(beaconDataDaoConfig, this);
        connectivityDataDao = new ConnectivityDataDao(connectivityDataDaoConfig, this);
        gyroDataDao = new GyroDataDao(gyroDataDaoConfig, this);
        humidityDataDao = new HumidityDataDao(humidityDataDaoConfig, this);
        lightDataDao = new LightDataDao(lightDataDaoConfig, this);
        magneticDataDao = new MagneticDataDao(magneticDataDaoConfig, this);
        noiseDataDao = new NoiseDataDao(noiseDataDaoConfig, this);
        pressureDataDao = new PressureDataDao(pressureDataDaoConfig, this);
        proximityDataDao = new ProximityDataDao(proximityDataDaoConfig, this);
        temperatureDataDao = new TemperatureDataDao(temperatureDataDaoConfig, this);
        packetDao = new PacketDao(packetDaoConfig, this);

        registerDao(Config.class, configDao);
        registerDao(Authentication.class, authenticationDao);
        registerDao(LocationData.class, locationDataDao);
        registerDao(AccelData.class, accelDataDao);
        registerDao(BatteryData.class, batteryDataDao);
        registerDao(BeaconData.class, beaconDataDao);
        registerDao(ConnectivityData.class, connectivityDataDao);
        registerDao(GyroData.class, gyroDataDao);
        registerDao(HumidityData.class, humidityDataDao);
        registerDao(LightData.class, lightDataDao);
        registerDao(MagneticData.class, magneticDataDao);
        registerDao(NoiseData.class, noiseDataDao);
        registerDao(PressureData.class, pressureDataDao);
        registerDao(ProximityData.class, proximityDataDao);
        registerDao(TemperatureData.class, temperatureDataDao);
        registerDao(Packet.class, packetDao);
    }
    
    public void clear() {
        configDaoConfig.getIdentityScope().clear();
        authenticationDaoConfig.getIdentityScope().clear();
        locationDataDaoConfig.getIdentityScope().clear();
        accelDataDaoConfig.getIdentityScope().clear();
        batteryDataDaoConfig.getIdentityScope().clear();
        beaconDataDaoConfig.getIdentityScope().clear();
        connectivityDataDaoConfig.getIdentityScope().clear();
        gyroDataDaoConfig.getIdentityScope().clear();
        humidityDataDaoConfig.getIdentityScope().clear();
        lightDataDaoConfig.getIdentityScope().clear();
        magneticDataDaoConfig.getIdentityScope().clear();
        noiseDataDaoConfig.getIdentityScope().clear();
        pressureDataDaoConfig.getIdentityScope().clear();
        proximityDataDaoConfig.getIdentityScope().clear();
        temperatureDataDaoConfig.getIdentityScope().clear();
        packetDaoConfig.getIdentityScope().clear();
    }

    public ConfigDao getConfigDao() {
        return configDao;
    }

    public AuthenticationDao getAuthenticationDao() {
        return authenticationDao;
    }

    public LocationDataDao getLocationDataDao() {
        return locationDataDao;
    }

    public AccelDataDao getAccelDataDao() {
        return accelDataDao;
    }

    public BatteryDataDao getBatteryDataDao() {
        return batteryDataDao;
    }

    public BeaconDataDao getBeaconDataDao() {
        return beaconDataDao;
    }

    public ConnectivityDataDao getConnectivityDataDao() {
        return connectivityDataDao;
    }

    public GyroDataDao getGyroDataDao() {
        return gyroDataDao;
    }

    public HumidityDataDao getHumidityDataDao() {
        return humidityDataDao;
    }

    public LightDataDao getLightDataDao() {
        return lightDataDao;
    }

    public MagneticDataDao getMagneticDataDao() {
        return magneticDataDao;
    }

    public NoiseDataDao getNoiseDataDao() {
        return noiseDataDao;
    }

    public PressureDataDao getPressureDataDao() {
        return pressureDataDao;
    }

    public ProximityDataDao getProximityDataDao() {
        return proximityDataDao;
    }

    public TemperatureDataDao getTemperatureDataDao() {
        return temperatureDataDao;
    }

    public PacketDao getPacketDao() {
        return packetDao;
    }

}