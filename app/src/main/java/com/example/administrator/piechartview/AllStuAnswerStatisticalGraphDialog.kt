package com.example.administrator.piechartview

import android.app.DialogFragment
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lwb.piechart.PieChartView.ItemType
import kotlinx.android.synthetic.main.activity_main.*


/**
 * 提问答题->全员答题报表
 */
class AllStuAnswerStatisticalGraphDialog() : DialogFragment() {
    var listener: DialogClickListener? = null
    override fun onStart() {
        super.onStart()
        val lp = dialog?.window?.attributes
        lp?.width = 1200
        lp?.height = 900
        dialog?.window?.attributes = lp
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }

   private val colors = arrayOf("#4CAF50", "#FFC107", "#E91E63", "#00BCD4", "#FF9800")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_main, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    private fun initView() {
        pie_chart_view.setCell(5);            //设置环形图的间距
        pie_chart_view.setInnerRadius(0.4f);  //设置环形图内环半径比例 0 - 1.0f
        pie_chart_view.addItemType(ItemType("苹果", 1, -0xdf4d56))
      //  pie_chart_view.addItemType(ItemType("华为", 17, -0x97dd75))
    }



    abstract class DialogClickListener {
        open fun onCancelClick() {}
        open fun onConfirmClick(channelId: String?, deskNumber: Int) {}
    }
}