package dsyn.lib_anim;

import java.security.PublicKey;
import java.util.ArrayList;


import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;



public class AnimationViewList {
	
	int animation_out[]={R.anim.scalenew,R.anim.scalenew,R.anim.scalenew,R.anim.scalenew};
	int animation_in[]={R.anim.scaledown,R.anim.scaledown,R.anim.scaledown,R.anim.scaledown};
	int viewIds[]={R.id.imageViewmain_screen1,R.id.imageViewmain_screen2,R.id.imageViewmain_screen3,R.id.imageViewmain_screen4};
	
	int childviewIds[]={R.id.imageViewchild_screen1,R.id.imageViewchild_screen2,R.id.imageViewchild_screen3,R.id.imageViewchild_screen4};
	int maintextview[]={R.id.text_main_screen1,R.id.text_main_screen2,R.id.text_main_screen3,R.id.text_main_screen4};
	
	int subtextview[]={R.id.text_sub_screen1,R.id.text_sub_screen2,R.id.text_sub_screen3,R.id.text_sub_screen4};
	//int childlayoutIds[]={R.id.layout_screen1,R.id.layout_screen2,R.id.layout_screen3,R.id.layout_screen4};
	
	//int parentviewIds[]={R.id.cell1,R.id.cell2,R.id.cell3,R.id.cell4};
	
	ArrayList<View> arrayList=new ArrayList<View>();
	

	
	
	
	public static ArrayList<AnimationView> animationViews_list=new ArrayList<AnimationViewList.AnimationView>();
	
	public static int top,bot;
	
	public static int top_text,bot_text;
	
	
	public static Animation animation_down;
	public static Animation animation_childview;
	
	public Activity curentActivity;
	
	public static boolean executionBol=false;
	
	public static Animation animation_fadeup,animation_fadedown;
	Context context;
	
	public AnimationViewList(Context context,ScrolView scrolView)
	{
		this.context=context;
		executionBol=false;
		System.out.println("<<<<constructorrrrrr");
		
		
		curentActivity=(AnimationLibActivity)context;
		animationViews_list.clear();
		
		
		
		
		final ScrolView scrolView2=scrolView;
		
	
	animation_fadedown=AnimationUtils.loadAnimation(context, R.anim.alpha_down);
	
	animation_fadeup=AnimationUtils.loadAnimation(context, R.anim.alpha_up);
	
	
	
	
	  
	  animation_down=AnimationUtils.loadAnimation(context,R.anim.scaledown);
	  
	  animation_down.setAnimationListener(new AnimationListener() {
		
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			System.out.println("<<<<start_animationdowneeeeee");
			
		}
		
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
		    
		    View view=(curentActivity).findViewById(viewIds[1]);
		    
		    view.setVisibility(View.VISIBLE);
			
		}
	});
	  
	  
  
	  
	  
	 // animation_childview=AnimationUtils.loadAnimation(context,R.anim.scaledown_child);
	
	
	for(int i=0;i<viewIds.length;i++)
	{
		
		final AnimationView animationView=new AnimationView();
		
		animationView.setanimation_outid(animation_out[i]);
		
		animationView.setanimation_inid(animation_in[i]);
		
		animationView.setviewId(viewIds[i]);
		//animationView.setparentviewId(parentviewIds[i]);
		animationView.setchildviewId(childviewIds[i]);
		//animationView.setchildlayoutId(childlayoutIds[i]);
		
		animationView.setmaintextviewId(maintextview[i]);
		
		animationView.setsubtextviewId(subtextview[i]);
		
	//	final View childLayout=(View)curentActivity.findViewById(animationView.getparentviewId()).findViewById(animationView.getchildlayoutId());
		final View childview=(View)curentActivity.findViewById(animationView.getchildviewId());
		
		final View view=(View)curentActivity.findViewById(animationView.getviewId());
		
		Animation animation_view=AnimationUtils.loadAnimation(context,R.anim.scaledown_child);
	
		animation_view.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				System.out.println("<<<<start animaaaaa_childview");
				/*if(animationView.childview_state==false)
				{
				childview.setVisibility(View.VISIBLE);
				}*/
				
			}
			
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				
				childview.setVisibility(View.GONE);
				if(animationView.childview_state==false)
				{
				    view.startAnimation(animationView.get_animation_view_down());
				}
				
				
				
				
				
				
			}
		});
		animationView.set_animation_childview(animation_view);
		
		
		
		
		
		Animation animation_childview_up=AnimationUtils.loadAnimation(context,R.anim.scaleup);
	
		animation_childview_up.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				System.out.println("<<<<start animaaaaa");
				childview.setVisibility(View.VISIBLE);
				
			}
			
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				//childLayout.setVisibility(View.GONE);
			
				
			}
		});
		animationView.set_animation_childview_up(animation_childview_up);
		
		
		
		Animation animation_view_up=AnimationUtils.loadAnimation(context,R.anim.scalenew);
	
		animation_view_up.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				System.out.println("<<<<start animaaaaa");
				
			}
			
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				//childLayout.setVisibility(View.GONE);
			  
				childview.startAnimation(animationView.get_animation_childview_up());
				
			  
				
				
			}
		});
		animationView.set_animation_view_up(animation_view_up);
		
		
		
		
		
		Animation animation_view_down=AnimationUtils.loadAnimation(context,R.anim.scaledown);
		
		animation_view_down.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				System.out.println("<<<<start animaaaaa");
				//childview.startAnimation(animationView.get_animation_childview());
				
			}
			
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				//childLayout.setVisibility(View.GONE);
				//childview.startAnimation(animationView.get_animation_childview());
				
			}
		});
		animationView.set_animation_view_down(animation_view_down);
		
		
		
		animationViews_list.add(animationView);
		
	
		
		
	}
	
	
	
	scrolView2.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
	       
        public void onGlobalLayout() {
        	System.out.println("onglobal_layouttt");
    		
    		top=scrolView2.getHeight()-scrolView2.getHeight()/8;
    		bot=scrolView2.getHeight()-scrolView2.getHeight()/11;
    		
    		
    		top_text=scrolView2.getHeight()-scrolView2.getHeight()/5;
    		bot_text=scrolView2.getHeight()-scrolView2.getHeight()/8;
    		
    	   
    		
    		System.out.println("toppppppppppp="+scrolView2.getTop()+"botom="+scrolView2.getBottom());
    	
    		System.out.println("<<<<bolll_outerrr="+executionBol);
    		 
    		if(top>0 && bot>0)
    		{
    			System.out.println("<<<<bolll_inner_first="+executionBol);
    			if(executionBol==false)
    			{
    				System.out.println("<<<<bolll_inner_seconddd="+executionBol);
    		
    			for(int i=0;i<2;i++)
    			{
    				final int j=i;
    				AnimationView view=animationViews_list.get(i);
    				
    			/*	View myView=(View)curentActivity.findViewById(view.getparentviewId()).findViewById(view.getviewId());
    				
    				final View childView=(View)curentActivity.findViewById(view.getparentviewId()).findViewById(view.getchildviewId());
    				
    				final View childLayout=(View)curentActivity.findViewById(view.getparentviewId()).findViewById(view.getchildlayoutId());*/
    				
    				
                                 View myView=(View)curentActivity.findViewById(view.getviewId());
    				
    				final View childView=(View)curentActivity.findViewById(view.getchildviewId());
    				
    				 final View maintext=(View)curentActivity.findViewById(view.getmaintextviewId());
    				 
    				 final View subtext=(View)curentActivity.findViewById(view.getsubtextviewId());
    				
    				//final View childLayout=(View)curentActivity.findViewById(view.getchildlayoutId());
    				
    				//arrayList.add(childLayout);
    				
    				System.out.println("view="+view+"myview="+myView+"i===="+i);
    				
    				
    				
    				myView.getLocationOnScreen(view.loc);
    			
    				//Myimage view=(Myimage)mLayout.getChildAt(i);
    				myView.getLocationOnScreen(view.loc);
    				
    				System.out.println("xxxxxxx="+view.loc[0]+"yyyy="+view.loc[1]+"i=="+i);
    				
    			
    				System.out.println("view_top="+myView.getTop()+"toppp="+top+"i=="+i);
    				if(view.loc[1]<top)
    				{
    				//if(myView.getTop()<top)
    				
    					System.out.println("<<<<iffffffff"+"i==="+j+"loc_y="+view.loc[1]+"focus="+myView.isFocused());
    					view.set_up(true);
    					view.set_textup(true);
    					
    					
    				}
    				else {
    					System.out.println("<<<<elseeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+"i==="+j+"loc_y="+view.loc[1]);
    				
   						 System.out.println("<<<<view top="+myView.getTop()+"width="+myView.getWidth());
   						 view.childview_state=true;
   						
   						myView.startAnimation(animation_down);
   					childView.startAnimation(view.get_animation_childview());
   						
   					
   					maintext.startAnimation(animation_fadedown);
   					subtext.startAnimation(animation_fadedown);
   						
   						
   					
   					
   					/*view.get_animation_childview().setStartTime(AnimationUtils.currentAnimationTimeMillis());
   						view.get_animation_childview().setStartTime(0);
   						//childView.startAnimation(view.get_animation_childview());
   						childView.postInvalidate();
   						System.out.println("<<<<child view_width="+childView.getWidth()+"hight="+childView.getHeight());
   						childView.setEnabled(true);
   						childView.setLayoutParams(new LinearLayout.LayoutParams(10,10));*/
   						
   						
   						
    					
    				
    				}
    				
    			
    			}
    			
    			executionBol=true;
    			
    			
    			}
    			
    		}
           
        }
    });
		
		
	}
	

	public class AnimationView
	{
		private Animation animation;
		private int animation_out_id,animation_in_id;
		private int viewId,parentviewId,childviewId,childlayoutId,maintextview_id,subtextview_id;
		
		private boolean is_up=false;
		private boolean is_down=false;
		
		
		private boolean is_up_text=false;
		private boolean is_down_text=false;
		
		
		public int loc[]=new int[2];
		
		public int loc_text[]=new int[2];
		
		private Animation animation_view;
		
		private Animation animation_child_up;
		
		private Animation animation_view_down;
		
		public boolean childview_state=false;
		
		public void setviewId(int viewId)
		{
			this.viewId=viewId;
			
			
		}
		
		public void setmaintextviewId(int maintextview_id)
		{
			this.maintextview_id=maintextview_id;
			
			
		}
		
		
		public void setsubtextviewId(int subtextview_id)
		{
			this.subtextview_id=subtextview_id;
			
			
		}
		public void setchildviewId(int childviewId)
		{
			this.childviewId=childviewId;
			
			
		}
		
		
	
		
		public void setchildlayoutId(int childlayoutId)
		{
			this.childlayoutId=childlayoutId;
			
			
		}
		
		
		public void setparentviewId(int parentviewId)
		{
			this.parentviewId=parentviewId;
			
			
		}
		
		
		public void setanimation_outid(int animation_out_id)
		{
			
			this.animation_out_id=animation_out_id;
			
		}
		
		public void setanimation_inid(int animation_in_id)
		{
			
			this.animation_in_id=animation_in_id;
			
		}
		
		
		
		
		public int getviewId()
		{
			return this.viewId;
			
			
		}
		
		
		public int getmaintextviewId()
		{
			return this.maintextview_id;
			
			
		}
		
		
		public int getsubtextviewId()
		{
			return this.subtextview_id;
			
			
		}
		
		public int getchildviewId()
		{
			return this.childviewId;
			
			
		}
		
		public int getchildlayoutId()
		{
			return this.childlayoutId;
			
			
		}
		
		
		public int getparentviewId()
		{
			return this.parentviewId;
			
			
		}
		
		
		public int getanimation_outid()
		{
			
			return this.animation_out_id;
			
		}
		
		public int getanimation_inid()
		{
			
			return this.animation_in_id;
			
		}
		
		public void set_up(boolean is_up)
		{
			this.is_up=is_up;
		}
		
		
		
		public boolean get_up()
		{
			return is_up;
		}
		
		
		
		public void set_down(boolean is_down)
		{
			this.is_down=is_down;
		}
		
		
		
		public boolean get_down()
		{
			return is_down;
		}
		
		
		
		
		
		
		
		
		
		public void set_textup(boolean is_up_text)
		{
			this.is_up_text=is_up_text;
		}
		
		
		
		public boolean get_textup()
		{
			return is_up_text;
		}
		
		
		
		public void set_textdown(boolean is_down_text)
		{
			this.is_down_text=is_down_text;
		}
		
		
		
		public boolean get_textdown()
		{
			return is_down_text;
		}
		
		
		
		
		
		
		
		
		
		
		
		public void set_animation_childview(Animation animation)
		{
			this.animation=animation;
		}
		
		public void set_animation_childview_up(Animation animation_child_up)
		{
			this.animation_child_up=animation_child_up;
		}
		
		public void set_animation_view_up(Animation animation_view)
		{
			this.animation_view=animation_view;
		}
		
		
		public void set_animation_view_down(Animation animation_view_down)
		{
			this.animation_view_down=animation_view_down;
		}
		
		
		public Animation get_animation_childview()
		{
			return this.animation;
		}
		
		public Animation get_animation_childview_up()
		{
			return this.animation_child_up;
		}
		
		
		public Animation get_animation_view_up()
		{
			return this.animation_view;
		}
		
		
		public Animation get_animation_view_down()
		{
			return this.animation_view_down;
		}


		
	
	}
	
	

}
