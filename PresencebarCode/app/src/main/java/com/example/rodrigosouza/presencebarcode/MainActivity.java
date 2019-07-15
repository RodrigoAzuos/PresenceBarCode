package com.example.rodrigosouza.presencebarcode;import android.Manifest;import android.app.Activity;import android.content.Intent;import android.graphics.Color;import android.hardware.Camera;import android.media.AudioManager;import android.media.ToneGenerator;import android.support.annotation.NonNull;import android.support.design.widget.AppBarLayout;import android.support.design.widget.FloatingActionButton;import android.support.design.widget.Snackbar;import android.support.v4.app.ActivityCompat;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.support.v7.widget.Toolbar;import android.view.View;import android.view.ViewTreeObserver;import android.widget.Button;import android.widget.FrameLayout;import android.widget.ImageButton;import android.widget.LinearLayout;import android.widget.ScrollView;import android.widget.TextView;import android.widget.Toast;import com.example.rodrigosouza.presencebarcode.api.ApiService;import com.example.rodrigosouza.presencebarcode.model.Registro;import com.example.rodrigosouza.presencebarcode.utils.Function;import com.google.zxing.BarcodeFormat;import com.google.zxing.Result;import java.util.ArrayList;import java.util.List;import java.util.Random;import me.dm7.barcodescanner.core.CameraUtils;import me.dm7.barcodescanner.zxing.ZXingScannerView;import pub.devrel.easypermissions.EasyPermissions;import pub.devrel.easypermissions.PermissionRequest;import retrofit2.Call;import retrofit2.Callback;import retrofit2.Response;public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler,        EasyPermissions.PermissionCallbacks, ActivityCompat.OnRequestPermissionsResultCallback {    private int REQUEST_CODE_CAMERA = 182;    private FrameLayout mFrameLayout;    private ZXingScannerView mZxingScannerView;    private LinearLayout mLinearLayout;    private TextView tVlabel;    private LinearLayout lLcontent;    private TextView tVcontent;    private TextView tVbarCodeType;    private ImageButton iBclear;    private Button bTopen;    private String[] permissionsList;    private String conteudo = "";    private AppBarLayout appBarLayout;    private ScrollView scrollViewMain;    private boolean scrollFlag = false;    private TextView tvToolbar;    private FloatingActionButton fab;    private Activity activity;    ApiService apiService;    Random random;    ArrayList<Integer> alunos;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);//        final Toolbar toolbar = findViewById(R.id.toolbar_main);//        setSupportActionBar(toolbar);        activity = this;        askCameraPermition();        bindView();        FloatingActionButton fab = findViewById(R.id.fab);        fab.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View view) {                Intent intent = new Intent(activity , HomeActivity.class);                activity.startActivityForResult(intent,0);                activity.overridePendingTransition(R.anim.rigthtoleft, R.anim.stable);                finish();            }        });        setupViews();//        appBarLayout = findViewById(R.id.app_bar_main);////        appBarLayout.bringToFront();////        getSupportActionBar().setHomeButtonEnabled(true);//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburgar);    }    @Override    protected void onResume() {        super.onResume();        mZxingScannerView.setResultHandler(this);        mZxingScannerView.startCamera();    }    @Override    protected void onPause() {        super.onPause();        mZxingScannerView.stopCamera();        Camera camera = CameraUtils.getCameraInstance();        if (camera != null)            camera.release();    }    @Override    public void handleResult(Result result) {        if( result == null ) {            Function.unrecognizedCode(this);            return;        }        processBarcodeResult(result.getText(),result.getBarcodeFormat().name());    }    private void processBarcodeResult(String text,String barcodeFormatName){        Result result = new Result(text,"1".getBytes(),null, BarcodeFormat.valueOf(barcodeFormatName));        this.conteudo += "Matricula: " + result.getText() + "\n";        tVcontent.setText("Matricula: " + result.getText());        tVlabel.setText(R.string.last_content_read);        processBarcodeType(true,result.getBarcodeFormat().name());        bip();        try {            Thread.sleep(1000);        }catch (Exception e){            e.printStackTrace();        }        mZxingScannerView.resumeCameraPreview(this);        Toast.makeText(this, "Matrícula Lida: "+result.getText() , Toast.LENGTH_LONG).show();        postRegistro(result.getText());    }    private void processBarcodeType(Boolean status, String barCode ) {        tVbarCodeType.setText(getString(R.string.barcode_format)+ barCode);        if (status) {            tVbarCodeType.setVisibility(View.VISIBLE);        } else {            tVbarCodeType.setVisibility(View.INVISIBLE);        }    }    @Override    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {        mZxingScannerView.startCamera();    }    @Override    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {        this.askCameraPermition();    }    @Override    public void onPointerCaptureChanged(boolean hasCapture) {    }    private void bindView() {        mFrameLayout = findViewById(R.id.fl_scanner);        mZxingScannerView = findViewById(R.id.z_xing_scanner);        mLinearLayout = findViewById(R.id.ll_info);        tVlabel = findViewById(R.id.tv_label);        lLcontent = findViewById(R.id.ll_content);        tVcontent = findViewById(R.id.tv_content);        tVbarCodeType = findViewById(R.id.tv_bar_code_type);        iBclear = findViewById(R.id.ib_clear);        bTopen = findViewById(R.id.bt_open);    }    private void askCameraPermition() {        if(!EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA))            EasyPermissions.requestPermissions(                    new PermissionRequest.Builder(this, REQUEST_CODE_CAMERA, Manifest.permission.CAMERA)                            .setRationale( getString(R.string.request_permission_description) )                            .setPositiveButtonText( getString(R.string.request_permission_button_ok) )                            .setNegativeButtonText( getString(R.string.request_permission_button_cancel) )                            .build());    }    public void onRequestPermissionsResult(int requestCode,                                           String[] permissions,                                           int[] grantResults){        super.onRequestPermissionsResult(requestCode,permissions,grantResults);        permissionsList = permissions;        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults);    }    public void clearContent(View view) {        tVcontent.setText(conteudo + "\n");        tVlabel.setText(R.string.all_readers);        processBarcodeType(false,"");    }    public void lockUnlock(View view) {    }    public void flashLight(View view) {    }    public void openFullscreen(View view) {    }    public void bip(){        try{            final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_MUSIC,100);            tg.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 100);        }catch (Exception e){            e.printStackTrace();        }    }    public void setupViews(){        apiService = new ApiService("");        alunos = new ArrayList<Integer>();        alunos.add(1);        alunos.add(2);        alunos.add(3);        alunos.add(3);        random = new Random();    }    public void postRegistro(String matricula){        int aluno = alunos.get(random.nextInt(4));        Registro registro = new Registro(false,2,1,1);        Call<Registro> call = apiService.registroEndPoint.postRegistro(registro);        call.enqueue(new Callback<Registro>() {            @Override            public void onResponse(Call<Registro> call, Response<Registro> response) {                if (response.isSuccessful()){                    Toast.makeText(getApplicationContext(),"Deu certo, deu certo",Toast.LENGTH_SHORT).show();                }            }            @Override            public void onFailure(Call<Registro> call, Throwable t) {                Toast.makeText(getApplicationContext(),"Deu certo não, deu certo não" + t.getMessage(),Toast.LENGTH_SHORT).show();            }        });    }//    private void  processButtonOpen(Result result){//        if (URLUtil.isValidUrl(result.getText())) {//        }//        else if////        }//    }}