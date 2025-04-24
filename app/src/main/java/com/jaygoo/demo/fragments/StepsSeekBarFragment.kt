package com.jaygoo.demo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaygoo.demo.R
import com.jaygoo.demo.databinding.FragmentStepBinding
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
 * 创建日期：2019-06-14
 * 描    述:
 * =====================================================
 */
class StepsSeekBarFragment : BaseFragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val binding = FragmentStepBinding.inflate(inflater, container, false)
		val stepsDrawables = ArrayList<Int>()
		stepsDrawables.add(R.drawable.step_1)
		stepsDrawables.add(R.drawable.step_2)
		stepsDrawables.add(R.drawable.step_3)
		stepsDrawables.add(R.drawable.step_4)
		binding.sbSteps1.setStepsDrawable(stepsDrawables)
		binding.sbSteps2.setStepsDrawable(stepsDrawables)
		return binding.root
	}


}