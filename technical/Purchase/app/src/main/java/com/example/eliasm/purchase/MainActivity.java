package com.example.eliasm.purchase;


        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.util.Log;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    Button btn1, btn2, btn3;
    private Context mContext=this;
    private static final String TAG = "Android BillingService";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        startService(new Intent(mContext, BillingService.class));
        BillingHelper.setCompletedHandler(mTransactionHandler);
    }
    public Handler mTransactionHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            Log.i(TAG, "Transaction complete");
            Log.i(TAG, "Transaction status: "+BillingHelper.latestPurchase.purchaseState);
            Log.i(TAG, "Item purchased is: "+BillingHelper.latestPurchase.productId);

            if(BillingHelper.latestPurchase.isPurchased()){
                showItem();
            }
        };

    };
    @Override
    public void onClick(View v) {
        if (v == btn1) {
            if(BillingHelper.isBillingSupported()){
                BillingHelper.requestPurchase(mContext, "android.test.purchased");
            } else {
                Log.i(TAG,"Can't purchase on this device");
                btn1.setEnabled(false); // XXX press button before service started will disable when it shouldnt
            }
            Toast.makeText(this, "Shirt Button", Toast.LENGTH_SHORT).show();
        }
        if (v == btn2) {
            if(BillingHelper.isBillingSupported()){
                BillingHelper.requestPurchase(mContext, "android.test.purchased");
            } else {
                Log.i(TAG,"Can't purchase on this device");
                btn2.setEnabled(false); // XXX press button before service started will disable when it shouldnt
            }
            Toast.makeText(this, "TShirt Button", Toast.LENGTH_SHORT).show();
        }
        if (v == btn3) {
            if(BillingHelper.isBillingSupported()){
                BillingHelper.requestPurchase(mContext, "android.test.purchased");
            } else {
                Log.i(TAG,"Can't purchase on this device");
                btn3.setEnabled(false); // XXX press button before service started will disable when it shouldnt
            }
            Toast.makeText(this, "Denim Button", Toast.LENGTH_SHORT).show();
        }

    }

    private void showItem() {
        //purchaseableItem.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause())");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        BillingHelper.stopService();
        super.onDestroy();
    }
}