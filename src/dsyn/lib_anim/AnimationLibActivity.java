package dsyn.lib_anim;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;




public class AnimationLibActivity extends Activity {
    /** Called when the activity is first created. */
	
	public static View view1,view2,view3,view4;
	AnimationViewList animationViewList;
	
	ScrolView scrolView;
	Activity activity;
	  ImageView viewmain_screen2;
	  Animation animation;
	  Myimg imageViewww;
	    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_new);
        
 
      
        
      /*  view1=(View)findViewById(R.id.cell1);
         view2=(View)findViewById(R.id.cell2);
         view3=(View)findViewById(R.id.cell3);
         view4=(View)findViewById(R.id.cell4);*/
        
    /*    ImageView viewmain_screen1=(ImageView)findViewById(R.id.cell1).findViewById(R.id.imageViewmain_screen1);
        
         viewmain_screen2=(ImageView)view2.findViewById(R.id.imageViewmain_screen2);
        
        ImageView viewmain_screen3=(ImageView)view1.findViewById(R.id.imageViewmain_screen3);
        
        ImageView viewmain_screen4=(ImageView)view1.findViewById(R.id.imageViewmain_screen4);*/
      
        
       
        scrolView=(ScrolView)findViewById(R.id.scrollView1);
       animationViewList=new AnimationViewList(AnimationLibActivity.this, scrolView);
       
        
     
    }
    
    
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
    	// TODO Auto-generated method stub
    	super.onWindowFocusChanged(hasFocus);
    
    }
}