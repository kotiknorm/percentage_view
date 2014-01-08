package net.zel.testLibrary;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import net.zel.percentage.PercentageButton;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final TextView textHeight = (TextView) findViewById(R.id.text_height);
        final TextView textWidth = (TextView) findViewById(R.id.text_width);

        textWidth.setText(String.format(getString(R.string.text_width),  "50"));
        textHeight.setText(String.format(getString(R.string.text_height),  "50"));

        String seekBarString;

        final PercentageButton percentageButton = (PercentageButton) findViewById(R.id.button);

        SeekBar seekBarWidth = (SeekBar) findViewById(R.id.width);
        seekBarWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("PercentageButton SeekBar", "" + seekBar.getProgress());
                percentageButton.setPercentageWidth(seekBar.getProgress());

                String seekBarString  =  String.format(getString(R.string.text_width),  seekBar.getProgress());
                textWidth.setText(seekBarString);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        SeekBar seekBarHeight = (SeekBar) findViewById(R.id.height);
        seekBarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("PercentageButton SeekBar", "" + seekBar.getProgress());
                percentageButton.setPercentageHeight(seekBar.getProgress());
                String seekBarString  =  String.format(getString(R.string.text_height),  seekBar.getProgress());
                textHeight.setText(seekBarString);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
