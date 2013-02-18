package dsyn.lib_anim;



import dsyn.lib_anim.AnimationViewList.AnimationView;
import android.app.Activity;
import android.content.Context;

import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;

import android.widget.ScrollView;

public class ScrolView extends ScrollView {
	
	public Activity curentActivity;
	
	Context context;
public ScrolView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		if(curentActivity==null)
		{
		curentActivity=(AnimationLibActivity)context;
		}
		
		if(this.context==null)
		{
		this.context=context;
	}
	}

	public ScrolView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		if(curentActivity==null)
		{
		curentActivity=(AnimationLibActivity)context;
		}
		
		if(this.context==null)
		{
		this.context=context;
	}
	}	
	
	
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		// TODO Auto-generated method stub
		super.onScrollChanged(l, t, oldl, oldt);
		
	
		for(int i=0;i<AnimationViewList.animationViews_list.size();i++)
		{
			
			AnimationView view=AnimationViewList.animationViews_list.get(i);
			//View myView=(View)curentActivity.findViewById(view.getparentviewId()).findViewById(view.getviewId());
			
			View myView=(View)curentActivity.findViewById(view.getviewId());
			
			 final View maintext=(View)curentActivity.findViewById(view.getmaintextviewId());
				 
				 final View subtext=(View)curentActivity.findViewById(view.getsubtextviewId());
			
			final View childView=(View)curentActivity.findViewById(view.getchildviewId());
			
			//final View childLayout=(View)curentActivity.findViewById(view.getparentviewId()).findViewById(view.getchildlayoutId());
			myView.getLocationOnScreen(view.loc);
			maintext.getLocationOnScreen(view.loc_text);
			
	
		if(AnimationViewList.executionBol==true)
		{
			
		if(t<oldt)    // scroll down
		{
			
			if(view.loc[1]>AnimationViewList.bot)
			{
				if(view.get_down()==false)
				{
					System.out.println("<<<<iffffffff_downnnnnnnnn"+i);
				view.set_down(true);
				view.set_up(false);
			
				
				//myView.startAnimation(view.get_animation_view_down());
				view.childview_state=false;
				
				childView.startAnimation(view.get_animation_childview());
				
				
				
				}
				
				
				
			}
			
			
			
			//if(view.loc_text[1]>AnimationViewList.bot+(AnimationViewList.bot/30))
			    if(view.loc_text[1]>AnimationViewList.bot+120)
			    	{
				if(view.get_textdown()==false)
				{
					System.out.println("<<<<iffffffff_downnnnnnnnn"+i);
				view.set_textdown(true);
				view.set_textup(false);
			
				
				
				maintext.startAnimation(AnimationViewList.animation_fadedown);
					subtext.startAnimation(AnimationViewList.animation_fadedown);
				
				
				}
				
				
				
			}
			
			
		}
		else        // scroll up
		{	
			
			
			if(view.loc[1]<AnimationViewList.top)
			{
				if(view.get_up()==false)
				{
					System.out.println("<<<<iffffffff_upppppppppp"+i);
				view.set_up(true);
				view.set_down(false);
				
				
				
				myView.startAnimation(view.get_animation_view_up());
				
			
				}
				
				
				
			}
			
			
			
			//if(view.loc_text[1]<AnimationViewList.top+(AnimationViewList.bot/30))
			    if(view.loc_text[1]<AnimationViewList.top+120)
			    	{
				if(view.get_textup()==false)
				{
					System.out.println("<<<<iffffffff_upppppppppp"+i);
				view.set_textup(true);
				view.set_textdown(false);
				
				
				maintext.startAnimation(AnimationViewList.animation_fadeup);
				subtext.startAnimation(AnimationViewList.animation_fadeup);
			
				}
				
				
				
			}
			
			
		}
		
		}
		
			
			
		
		}
		
		
	}

}
