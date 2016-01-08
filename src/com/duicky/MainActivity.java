package com.duicky;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * C ���� Java ����
 * 
 * @author luxiaofeng
 *
 */
public class MainActivity extends Activity {
	//Ҳ������mk�����ļ��е�  LOCAL_MODULE    := NDK_03
	private static final String libSoName = "NDK_04";
	private static final String tag = "MainActivity";
	
	public static Context mContext = null;
	private Button btnClickStatic = null;
	private Button btnClick = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mContext = this;
        //��ʼ���ؼ�
        initViews();
    }
    
    /**
     * ��ʼ���ؼ�
     */
    private void initViews() {
        btnClick = (Button) this.findViewById(R.id.btn_click);
        btnClick.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				sayHello();
			}
		});
        
        
        btnClickStatic = (Button) this.findViewById(R.id.btn_click_static);
        btnClickStatic.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				getTime();
			}
		});
	}

    public native void getTime() ;
    
    public native void sayHello() ;
    
    /**
     * ����JNI���ɵ�so���ļ�
     */
    static {
        System.loadLibrary(libSoName);
    }
    
}