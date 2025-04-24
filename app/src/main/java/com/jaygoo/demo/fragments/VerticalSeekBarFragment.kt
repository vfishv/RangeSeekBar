package com.jaygoo.demo.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaygoo.demo.R
import com.jaygoo.demo.databinding.FragmentStepBinding
import com.jaygoo.demo.databinding.FragmentVerticalBinding
import com.jaygoo.widget.*
import java.util.ArrayList

/**
//                       _ooOoo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                       O\ = /O
//                   ____/`---'\____
//                 .   ' \\| |// `.
//                  / \\||| : |||// \
//                / _||||| -:- |||||- \
//                  | | \\\ - /// | |
//                | \_| ''\---/'' | |
//                 \ .-\__ `-` ___/-. /
//              ______`. .' /--.--\ `. . __
//           ."" '< `.___\_<|>_/___.' >'"".
//          | | : `- \`.;`\ _ /`;.`/ - ` : | |
//            \ \ `-. \_ __\ /__ _/ .-` / /
//    ======`-.____`-.___\_____/___.-`____.-'======
//                       `=---='
//
//    .............................................
//             佛祖保佑             永无BUG
 * =====================================================
 * 作    者：JayGoo
 * 创建日期：2019-06-13
 * 描    述:
 * =====================================================
 */
class VerticalSeekBarFragment: BaseFragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val binding = FragmentVerticalBinding.inflate(inflater, container, false)

		binding.sbVertical2?.setIndicatorTextDecimalFormat("0.0")
		binding.sbVertical2?.setProgress(0f, 100f)
		changeSeekBarThumb(binding.sbVertical2.leftSeekBar, binding.sbVertical2.leftSeekBar.progress)
		changeSeekBarThumb(binding.sbVertical2.rightSeekBar, binding.sbVertical2.rightSeekBar.progress)
		binding.sbVertical2?.setOnRangeChangedListener(object : OnRangeChangedListener {
			override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
				changeSeekBarThumb(rangeSeekBar.leftSeekBar, leftValue)
				changeSeekBarThumb(rangeSeekBar.rightSeekBar, rightValue)
			}

			override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

			}

			override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

			}

		})

		binding.sbVertical3?.setIndicatorTextDecimalFormat("0")
		binding.sbVertical4?.setIndicatorTextDecimalFormat("0")
		binding.sbVertical4?.setIndicatorTextStringFormat("%s%%")
		binding.sbVertical4?.setProgress(30f, 60.6f)

		binding.sbVertical6?.setProgress(30f)

		binding.sbVertical7?.setProgress(40f, 80f)

		binding.sbVertical8?.setIndicatorTextDecimalFormat("0.0")

		val stepsDrawables = ArrayList<Int>()
		stepsDrawables.add(R.drawable.step_1)
		stepsDrawables.add(R.drawable.step_2)
		stepsDrawables.add(R.drawable.step_3)
		stepsDrawables.add(R.drawable.step_1)
		binding.sbVertical9?.setStepsDrawable(stepsDrawables)
		changeSeekBarIndicator(binding.sbVertical9.leftSeekBar, binding.sbVertical9.leftSeekBar.progress)
		changeSeekBarIndicator(binding.sbVertical9.rightSeekBar, binding.sbVertical9.rightSeekBar.progress)
		binding.sbVertical9?.setOnRangeChangedListener(object : OnRangeChangedListener {
			override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
				changeSeekBarIndicator(rangeSeekBar.leftSeekBar, leftValue)
				changeSeekBarIndicator(rangeSeekBar.rightSeekBar, rightValue)
			}

			override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

			}

			override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

			}

		})

		return binding.root
	}

	private fun changeSeekBarThumb(seekbar: SeekBar, value: Float){
		if (value < 33){
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorAccent)
			seekbar.setThumbDrawableId(R.drawable.thumb_green, seekbar.thumbWidth, seekbar.thumbHeight)
		}else if (value < 66){
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorProgress)
			seekbar.setThumbDrawableId(R.drawable.thumb_yellow, seekbar.thumbWidth, seekbar.thumbHeight)
		}else{
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorRed)
			seekbar.setThumbDrawableId(R.drawable.thumb_red, seekbar.thumbWidth, seekbar.thumbHeight)
		}
	}


	private fun changeSeekBarIndicator(seekbar: SeekBar, value: Float){
		seekbar.showIndicator(true)
		if (Utils.compareFloat(value, 0f, 3) == 0 || Utils.compareFloat(value, 100f, 3) == 0){
			seekbar.setIndicatorText("smile")
		}else if (Utils.compareFloat(value, 100/3f, 3) == 0){
			seekbar.setIndicatorText("naughty")
		}else if (Utils.compareFloat(value, 200/3f, 3) == 0){
			seekbar.setIndicatorText("lovely")
		}else{
			seekbar.showIndicator(false)
		}
	}
}