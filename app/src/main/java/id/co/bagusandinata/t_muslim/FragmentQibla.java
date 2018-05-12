package id.co.bagusandinata.t_muslim;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentQibla extends Fragment implements SensorEventListener {

    ImageView img_compass;
    TextView txt_degree;
    int mDegree;
    private SensorManager mSensorManager;
    private Sensor mRotation, mAccelerometer, mMagnetometer;
    float[] rMat = new float[9];
    float[] orientation = new float[9];
    private float[] mLastAccelerometer = new float[3];
    private float[] mLastMagnetometer = new float[3];
    private boolean haveSensor = false;
    private boolean haveSensor2 = false;
    private boolean mLastAccelerometerSet = false;
    private boolean mLastMagnetometerSet = false;
    private Context mContext;
    private String direction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_qibla, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = getView().getContext();

        mSensorManager = (SensorManager) getContext().getSystemService(mContext.SENSOR_SERVICE);
        img_compass = view.findViewById(R.id.compass);
        txt_degree = view.findViewById(R.id.degree_compass);

        start();

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR){
            SensorManager.getRotationMatrixFromVector(rMat, event.values);
            mDegree = (int) ((Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0])+360)%360);
        }

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            System.arraycopy(event.values,0, mLastAccelerometer, 0, event.values.length);
            mLastAccelerometerSet=true;
        }else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            System.arraycopy(event.values,0, mLastMagnetometer, 0, event.values.length);
            mLastMagnetometerSet=true;
        }

        if (mLastMagnetometerSet && mLastAccelerometerSet){
            SensorManager.getRotationMatrix(rMat, null, mLastAccelerometer, mLastMagnetometer);
            SensorManager.getOrientation(rMat, orientation);
            mDegree = (int) ((Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0])+360)%360);
        }

        mDegree = Math.round(mDegree);
        img_compass.setRotation(-mDegree);

        direction = "NO";
        if (mDegree >= 350 || mDegree <= 10)
            direction = "N";
        if (mDegree < 350 && mDegree > 280)
            direction = "NW";
        if (mDegree <= 280 && mDegree > 260)
            direction = "W";
        if (mDegree <= 260 && mDegree > 190)
            direction = "SW";
        if (mDegree <= 190 && mDegree > 170)
            direction = "S";
        if (mDegree <= 170 && mDegree > 200)
            direction = "SE";
        if (mDegree <= 100 && mDegree > 80)
            direction = "E";
        if (mDegree <= 80 && mDegree > 10)
            direction = "NE";

        txt_degree.setText(Integer.toString(mDegree)+"° "+direction);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    public void start(){
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)==null){
            if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)==null || mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)==null){
                noSensorAlert();
            }else {
                mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

                haveSensor = mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
                haveSensor2 = mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_UI);
            }
        }else {
            mRotation = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            haveSensor = mSensorManager.registerListener(this, mRotation, SensorManager.SENSOR_DELAY_UI);
        }
    }

    private void noSensorAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setMessage("Your device doesn't support the compass")
                .setCancelable(false)
                .setNegativeButton("Keluar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                });
    }

    public void stop() {
        if (haveSensor && haveSensor2){
            mSensorManager.unregisterListener(this, mAccelerometer);
            mSensorManager.unregisterListener(this, mMagnetometer);
        }else {
            if (haveSensor){
                mSensorManager.unregisterListener(this, mRotation);
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        stop();
    }

    @Override
    public void onResume() {
        super.onResume();
        start();
    }
}
