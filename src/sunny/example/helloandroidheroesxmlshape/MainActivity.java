package sunny.example.helloandroidheroesxmlshape;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.AlphaAnimation;
//import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.AnimationSet;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;

//import android.widget.TextView;
//import android.animation.ValueAnimator;


public class MainActivity extends ActionBarActivity {

	private Button button;
	private View view,view1;
	//private TextView tv1;
	private Button button1,button2,button0,btn;
	private RotateAnimation rotateAnimation,rotateAnimation1,rotateAnimation2;//属于视图动画
	private AlphaAnimation alphaAnimation;
	private AnimationSet set;
	private ObjectAnimator objectAnimator;//属于属性动画
	private ObjectAnimator objectAnimator1;
	private PropertyValuesHolder h1,h2,h3;
	//private ValueAnimator valueAnimator;
	WrapperView viewWrapper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button0 = (Button)findViewById(R.id.b0);
		rotateAnimation1 = new RotateAnimation(0f,360f,RotateAnimation.RELATIVE_TO_SELF,1.0f,RotateAnimation.RELATIVE_TO_SELF,1.0f);
		button0.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rotateAnimation1.setInterpolator(new OvershootInterpolator());
				rotateAnimation1.setDuration(3000);
				button0.setAnimation(rotateAnimation1);
				button0.startAnimation(rotateAnimation1);
			}			
				
		});
		
		btn = (Button)findViewById(R.id.b);
		rotateAnimation2 = new RotateAnimation(0f,1080f,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rotateAnimation2.setInterpolator(new OvershootInterpolator());
				rotateAnimation2.setDuration(3000);
				btn.setAnimation(rotateAnimation2);
				btn.startAnimation(rotateAnimation2);
			}			
				
		});
		
		rotateAnimation = new RotateAnimation(0f,360f,RotateAnimation.ABSOLUTE,0.5F,RotateAnimation.ABSOLUTE,0.5F);
		alphaAnimation = new AlphaAnimation(0,1);
		 set = new AnimationSet(true);
		button2 = (Button)findViewById(R.id.b5);
		button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				set.addAnimation(alphaAnimation);
				set.addAnimation(rotateAnimation);
				set.setDuration(3000);
				button2.startAnimation(set);
			}
		});//动画集
		button = (Button)findViewById(R.id.b1);
		button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				rotateAnimation.setDuration(3000);
				rotateAnimation.setFillAfter(false);//动画结束后是否保持最后状态
				rotateAnimation.setInterpolator(new BounceInterpolator());//具有弹性效果，好玩
				button.setAnimation(rotateAnimation);
				button.startAnimation(rotateAnimation);
			}
		});//
		
		view = (View)findViewById(R.id.b2);
		view.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				objectAnimator = ObjectAnimator.ofFloat(view, "translationX", 300);
				objectAnimator.setRepeatCount(3);//ObjectAnimator.INFINITE
				//objectAnimator.setDuration(3000);//设置setRepeatCount后Duration不起作用了
				objectAnimator.start();
			}
		});
		button1 = (Button)findViewById(R.id.b3);
		viewWrapper = new WrapperView(button1);
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				objectAnimator1 = ObjectAnimator.ofInt(viewWrapper, "height", 100);//
				objectAnimator1.setDuration(3000).start();
				objectAnimator1.addListener(new AnimatorListener(){

					@Override
					public void onAnimationStart(Animator animation) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onAnimationEnd(Animator animation) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onAnimationCancel(Animator animation) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onAnimationRepeat(Animator animation) {
						// TODO Auto-generated method stub
						
					}
					
				});
			}
		});
		
		view1 = (View)findViewById(R.id.b4);
		view1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				h1 = PropertyValuesHolder.ofFloat("translationX", 300f);
				h2 = PropertyValuesHolder.ofFloat("scaleY", 1f,0.5f);
				h3 = PropertyValuesHolder.ofInt("alpha", 0,1);
				 ObjectAnimator.ofPropertyValuesHolder(view1,h1,h2,h3).start();
				
				
			}
		});
		
		
	}

	
}
