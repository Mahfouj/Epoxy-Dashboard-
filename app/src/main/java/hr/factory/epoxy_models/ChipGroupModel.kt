package hr.factory.epoxy_models

import android.R.id
import android.view.LayoutInflater
import androidx.core.view.ViewCompat
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.TypedEpoxyController
import com.example.epoxydashboard.R
import com.example.epoxydashboard.databinding.CellChipGroupBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import hr.factory.ui_models.ChipGroupCellData


@EpoxyModelClass
abstract class ChipGroupModel : DataBindingEpoxyModel(){
   @EpoxyAttribute
 lateinit   var  chips: List<String>

    override fun getDefaultLayout() = R.layout.cell_chip_group

    override fun setDataBindingVariables(binding: ViewDataBinding?) {

        (binding as? CellChipGroupBinding)?.apply {

            addChipsCells(this.chipGroup)
        }
    }

    private fun addChipsCells(chipGroup: ChipGroup){
      chipGroup.removeAllViews()
     val inflater = LayoutInflater.from(chipGroup.context)

    chips.forEachIndexed { index, label->

        val  chip = inflater.inflate(R.layout.view_chip,chipGroup,false) as Chip

        chip.id=index
       chip.text=label
       chip.isAllCaps=true
       chip.isCheckable=false
        ViewCompat.setElevation(chip,0.0f)
        chipGroup.addView(chip)
    }


    }



}

fun TypedEpoxyController<*>.addChipGroup(cell : ChipGroupCellData){


    chipGroup {
        id("chipGroup")
        chips(cell.chips)
    }
}




