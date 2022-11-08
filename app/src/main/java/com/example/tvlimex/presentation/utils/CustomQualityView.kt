package com.example.tvlimex.presentation.utils

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.tvlimex.R
import com.example.tvlimex.databinding.CustomQualityLayoutBinding

enum class QualityAction {
    AUTO, NHD, VGA, HD, FULL_HD
}

typealias OnQualityActionListener = (QualityAction) -> Unit

class CustomQualityView(
    context: Context,
    attributes: AttributeSet?,
    defStyle: Int
) : CardView(context, attributes, defStyle) {

    private var onQualityActionListener: OnQualityActionListener? = null
    private var binding: CustomQualityLayoutBinding
    private val colorActive = ContextCompat.getColor(context, R.color.custom_quality_button_background)
    private val colorDisable = ContextCompat.getColor(context, R.color.white)

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributes: AttributeSet?) : this(context, attributes, 0)

    private fun initListeners() {
        binding.buttonAuto.setOnClickListener {
            buttonIsActive(QualityAction.AUTO)
            this.onQualityActionListener?.invoke(QualityAction.AUTO)
        }

        binding.buttonNHD.setOnClickListener {
            buttonIsActive(QualityAction.NHD)
            this.onQualityActionListener?.invoke(QualityAction.NHD)
        }

        binding.buttonVga.setOnClickListener {
            buttonIsActive(QualityAction.VGA)
            this.onQualityActionListener?.invoke(QualityAction.VGA)
        }

        binding.buttonHd.setOnClickListener {
            buttonIsActive(QualityAction.HD)
            this.onQualityActionListener?.invoke(QualityAction.HD)
        }

        binding.buttonFullHd.setOnClickListener {
            buttonIsActive(QualityAction.FULL_HD)
            this.onQualityActionListener?.invoke(QualityAction.FULL_HD)
        }
    }

    private fun buttonIsActive(qualityAction: QualityAction) {
        resetButtonColors()
        when (qualityAction) {
            QualityAction.AUTO ->{
                binding.buttonAuto.setBackgroundColor(colorActive)
            }
            QualityAction.NHD ->{
                binding.buttonNHD.setBackgroundColor(colorActive)
            }
            QualityAction.VGA -> {
                binding.buttonVga.setBackgroundColor(colorActive)
            }
            QualityAction.HD -> {
                binding.buttonHd.setBackgroundColor(colorActive)
            }
            QualityAction.FULL_HD -> {
                binding.buttonFullHd.setBackgroundColor(colorActive)
            }
        }
    }

    private fun resetButtonColors(){
        with(binding) {
            buttonAuto.setBackgroundColor(colorDisable)
            buttonNHD.setBackgroundColor(colorDisable)
            buttonVga.setBackgroundColor(colorDisable)
            buttonHd.setBackgroundColor(colorDisable)
            buttonFullHd.setBackgroundColor(colorDisable)
        }
    }

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.custom_quality_layout, this, true)
        binding = CustomQualityLayoutBinding.bind(this)
        initListeners()
    }
}