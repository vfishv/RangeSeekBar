package com.jaygoo.demo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaygoo.demo.R
import com.jaygoo.demo.databinding.FragmentRangeBinding
import com.jaygoo.widget.OnRangeChangedListener
import com.jaygoo.widget.RangeSeekBar
import com.jaygoo.widget.SeekBar

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
class RangeSeekBarFragment: BaseFragment() {

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val binding = FragmentRangeBinding.inflate(inflater, container, false)

		binding.sbRange1.setProgress(0f, 100f)
		changeSeekBarThumb(binding.sbRange1.leftSeekBar, binding.sbRange1.leftSeekBar.progress)
		changeSeekBarThumb(binding.sbRange1.rightSeekBar, binding.sbRange1.rightSeekBar.progress)
		binding.sbRange1?.setOnRangeChangedListener(object : OnRangeChangedListener{
			override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
				changeSeekBarThumb(rangeSeekBar.leftSeekBar, leftValue)
				changeSeekBarThumb(rangeSeekBar.rightSeekBar, rightValue)
			}

			override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

			}

			override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

			}

		})

		binding.sbRange2?.setProgress(0f, 100f)

		binding.sbRange3?.setRange(-100f, 100f)
		binding.sbRange3?.setProgress(0f, 80f)
		binding.sbRange3?.setIndicatorTextDecimalFormat("0")

		binding.sbRange4?.setProgress(20f, 70f)

		binding.sbRange5?.setProgress(20f, 60f)

		binding.sbRange6?.setProgress(20f, 70f)

		binding.sbRange8?.setProgress(20f, 60f)
		binding.sbRange8?.leftSeekBar?.thumbDrawableId = R.drawable.step_1
		binding.sbRange8?.rightSeekBar?.thumbDrawableId = R.drawable.step_2

		return binding.root
	}

	private fun changeSeekBarThumb(seekbar: SeekBar, value: Float){
		if (value < 33){
			seekbar.setThumbDrawableId(R.drawable.thumb_green, seekbar.thumbWidth, seekbar.thumbHeight)
		}else if (value < 66){
			seekbar.setThumbDrawableId(R.drawable.thumb_yellow, seekbar.thumbWidth, seekbar.thumbHeight)
		}else{
			seekbar.setThumbDrawableId(R.drawable.thumb_red, seekbar.thumbWidth, seekbar.thumbHeight)
		}
	}

}