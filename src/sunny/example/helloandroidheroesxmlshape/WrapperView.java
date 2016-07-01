package sunny.example.helloandroidheroesxmlshape;
//自定义一个包装类，间接给要进行动画的view增加它本身没有的get、set属性
import android.view.View;
public class WrapperView {
	private View mTarget;
	
	public WrapperView(View v){
		this.mTarget = v;
	}

	public int getHeight(){
		return mTarget.getLayoutParams().height;
	}
	public void setHeight(int height){
		mTarget.getLayoutParams().height = height;
		mTarget.requestLayout();
	}
}
