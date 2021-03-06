/*******************************************************************************
 * *     Nervousnet - a distributed middleware software for social sensing.
 * *      It is responsible for collecting and managing data in a fully de-centralised fashion
 * *
 * *     Copyright (C) 2016 ETH Zürich, COSS
 * *
 * *     This file is part of Nervousnet Framework
 * *
 * *     Nervousnet is free software: you can redistribute it and/or modify
 * *     it under the terms of the GNU General Public License as published by
 * *     the Free Software Foundation, either version 3 of the License, or
 * *     (at your option) any later version.
 * *
 * *     Nervousnet is distributed in the hope that it will be useful,
 * *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 * *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * *     GNU General Public License for more details.
 * *
 * *     You should have received a copy of the GNU General Public License
 * *     along with NervousNet. If not, see <http://www.gnu.org/licenses/>.
 * *
 * *
 * * 	Contributors:
 * * 	Prasad Pulikal - prasad.pulikal@gess.ethz.ch  -  Initial API and implementation
 *******************************************************************************/

package ch.ethz.coss.nervousnet.hub.ui;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v13.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import ch.ethz.coss.nervousnet.hub.Application;
import ch.ethz.coss.nervousnet.hub.Constants;
import ch.ethz.coss.nervousnet.hub.R;
import ch.ethz.coss.nervousnet.hub.ui.adapters.CollectionRateSettingItemAdapter;
import ch.ethz.coss.nervousnet.vm.NNLog;
import ch.ethz.coss.nervousnet.vm.NervousnetVMConstants;

/**
 * @author prasad
 */

public class CollectionRateSettingsActivity extends BaseActivity {

    final private int REQUEST_CODE_ASK_PERMISSIONS_LOC = 1;
    final private int REQUEST_CODE_ASK_PERMISSIONS_NOISE = 2;
    ImageButton globalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_rate);
        final ListView listview = (ListView) findViewById(R.id.coll_rate_listview);
        final CollectionRateSettingItemAdapter adapter = new CollectionRateSettingItemAdapter(
                CollectionRateSettingsActivity.this, NervousnetVMConstants.sensor_labels, Constants.icon_array_sensors);
        listview.setAdapter(adapter);

        globalButton = (ImageButton) findViewById(R.id.globalOptionsButton);
        globalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NNLog.d("CollectionRateSettingsActivity", "Global collection rate Options button clicked");
                createDialog().show();
            }
        });

        if (((Application) getApplication()).nn_VM.getState() == NervousnetVMConstants.STATE_PAUSED) {
            globalButton.setAlpha(.4f);
            globalButton.setClickable(false);
        }

    }

    public Dialog createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(Constants.collection_rate_global_options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int itemClicked) {
                String[] option_array = Constants.collection_rate_global_options;
                String optionSelected = option_array[itemClicked];
                ((Application) getApplication()).nn_VM.updateAllSensorConfig(
                        (byte) itemClicked);

                finish();
                startActivity(getIntent());
                requestPermissions();
            }
        });
        return builder.create();
    }

    // Android 6.0 permission request
    public void requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_CODE_ASK_PERMISSIONS_LOC
                );
            }
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO)) {
                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.RECORD_AUDIO},
                        REQUEST_CODE_ASK_PERMISSIONS_NOISE
                );
            }
        }
    }

}
