package sunny.example.helloandroidheroesxmlshape;
//�Զ���һ����װ�࣬��Ӹ�Ҫ���ж�����view����������û�е�get��set����
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
