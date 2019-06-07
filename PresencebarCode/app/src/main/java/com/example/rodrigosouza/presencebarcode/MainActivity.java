package com.example.rodrigosouza.presencebarcode;

import android.Manifest;
import android.hardware.Camera;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rodrigosouza.presencebarcode.util.Function;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;

import java.util.List;

import me.dm7.barcodescanner.core.CameraUtils;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler,
        EasyPermissions.PermissionCallbacks, ActivityCompat.OnRequestPermissionsResultCallback {

    private int REQUEST_CODE_CAMERA = 182;
    private FrameLayout mFrameLayout;
    private ZXingScannerView mZxingScannerView;
    private LinearLayout mLinearLayout;
    private TextView tVlabel;
    private LinearLayout lLcontent;
    private TextView tVcontent;
    private TextView tVbarCodeType;
    private ImageButton iBclear;
    private Button bTopen;
    private String[] permissionsList;
    private String conteudo = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askCameraPermition();
        bindView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mZxingScannerView.setResultHandler(this);
        mZxingScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();

        mZxingScannerView.stopCamera();

        Camera camera = CameraUtils.getCameraInstance();
        if (camera != null)
            camera.release();
    }

    @Override
    public void handleResult(Result result) {
        if( result == null ) {
            Function.unrecognizedCode(this);
            return;
        }

        processBarcodeResult(result.getText(),result.getBarcodeFormat().name());

    }

    private void processBarcodeResult(String text,String barcodeFormatName){

        Result result = new Result(text,"1".getBytes(),null, BarcodeFormat.valueOf(barcodeFormatName));
        this.conteudo += "Matricula: " + result.getText() + "\n";
        tVcontent.setText("Matricula: " + result.getText());
        tVlabel.setText(R.string.last_content_read);
        processBarcodeType(true,result.getBarcodeFormat().name());

        mZxingScannerView.resumeCameraPreview(this);

    }

    private void processBarcodeType(Boolean status, String barCode ) {
        tVbarCodeType.setText(getString(R.string.barcode_format)+ barCode);
        if (status) {
            tVbarCodeType.setVisibility(View.VISIBLE);
        } else {
            tVbarCodeType.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        mZxingScannerView.startCamera();

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        this.askCameraPermition();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void bindView() {
        mFrameLayout = findViewById(R.id.fl_scanner);
        mZxingScannerView = findViewById(R.id.z_xing_scanner);
        mLinearLayout = findViewById(R.id.ll_info);
        tVlabel = findViewById(R.id.tv_label);
        lLcontent = findViewById(R.id.ll_content);
        tVcontent = findViewById(R.id.tv_content);
        tVbarCodeType = findViewById(R.id.tv_bar_code_type);
        iBclear = findViewById(R.id.ib_clear);
        bTopen = findViewById(R.id.bt_open);
    }

    private void askCameraPermition() {
        if(!EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA))
            EasyPermissions.requestPermissions(
                    new PermissionRequest.Builder(this, REQUEST_CODE_CAMERA, Manifest.permission.CAMERA)
                            .setRationale( getString(R.string.request_permission_description) )
                            .setPositiveButtonText( getString(R.string.request_permission_button_ok) )
                            .setNegativeButtonText( getString(R.string.request_permission_button_cancel) )
                            .build());
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions,
                                           int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        permissionsList = permissions;
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults);


    }

    public void clearContent(View view) {
        tVcontent.setText(conteudo + "\n");
        tVlabel.setText(R.string.all_readers);
        processBarcodeType(false,"");
    }

    public void lockUnlock(View view) {
    }

    public void flashLight(View view) {
    }

    public void openFullscreen(View view) {
    }

//    private void  processButtonOpen(Result result){
//        if (URLUtil.isValidUrl(result.getText())) {
//        }
//        else if
//
//        }
//    }

}
