package com.miraclehinn.dietdiary;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.miraclehinn.dietdiary.adapters.ViewPagerAdapter;;

public class GuideActivity extends Activity implements OnPageChangeListener {

	private ViewPager vp;
	private ViewPagerAdapter vpAdapter;
	private List<View> views;

	// �ײ�С��ͼƬ
	private ImageView[] dots;

	// ��¼��ǰѡ��λ��
	private int currentIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide);

		// ��ʼ��ҳ��
		initViews();

		// ��ʼ���ײ�С��
		initDots();
	}

	private void initViews() {
		LayoutInflater inflater = LayoutInflater.from(this);

		views = new ArrayList<View>();
		// ��ʼ������ͼƬ�б�
		views.add(inflater.inflate(R.layout.guide_one, null));
		views.add(inflater.inflate(R.layout.guide_two, null));
		views.add(inflater.inflate(R.layout.guide_three, null));
		views.add(inflater.inflate(R.layout.guide_four, null));

		// ��ʼ��Adapter
		vpAdapter = new ViewPagerAdapter(views, this);
		
		vp = (ViewPager) findViewById(R.id.GuideViewPager);
		vp.setAdapter(vpAdapter);
		
		// �󶨻ص�
		vp.setOnPageChangeListener(this);
	}

	private void initDots() {
		LinearLayout guideLinearLayout = (LinearLayout) findViewById(R.id.GuideLinearLayout);

		dots = new ImageView[views.size()];

		// ѭ��ȡ��С��ͼƬ
		for (int i = 0; i < views.size(); i++) {
			dots[i] = (ImageView) guideLinearLayout.getChildAt(i);
			dots[i].setEnabled(false);// ����Ϊwhite
		}

		currentIndex = 0;
		dots[currentIndex].setEnabled(true);// ����Ϊdark����ѡ��״̬
	}

	private void setCurrentDot(int position) {
		if (position < 0 || position > views.size() - 1
				|| currentIndex == position) {
			return;
		}

		dots[position].setEnabled(true);
		dots[currentIndex].setEnabled(false);

		currentIndex = position;
	}

	// ������״̬�ı�ʱ����
	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	// ����ǰҳ�汻����ʱ����
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	// ���µ�ҳ�汻ѡ��ʱ����
	@Override
	public void onPageSelected(int arg0) {
		// ���õײ�С��ѡ��״̬
		setCurrentDot(arg0);
	}
}