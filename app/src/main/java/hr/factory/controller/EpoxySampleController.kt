package hr.factory.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.example.epoxydashboard.cart
import com.example.epoxydashboard.description
import com.example.epoxydashboard.headerImage
import com.example.epoxydashboard.info
import com.example.epoxydashboard.item
import com.example.epoxydashboard.sectionTitle
import com.example.epoxydashboard.subtitle
import com.example.epoxydashboard.title
import hr.factory.*
import hr.factory.epoxy_models.*
import hr.factory.ui_models.*


class EpoxySampleController(private val listener: EpoxySampleControllerListener):
    TypedEpoxyController<List<BaseCell>>(){

        override fun buildModels(data: List<BaseCell>?) {
        data?.forEach { cellData->
            when(cellData){

                is HeaderCellData -> addHeader(cellData)
                is TitleCellData -> addTitle(cellData)
                is SubtitleCellData -> addSubtitle(cellData)
                is SectionTitleCellData -> addSectionTitle(cellData)
                is ChipGroupCellData -> addChipGroup(cellData)
                is InfoCellData -> addInfo(cellData)
                is CartCellData -> addCart(cellData, listener)
                is DescriptionCellData -> addDescription(cellData)
                is ItemCellData -> addItem(cellData, listener)

            }


        }
    }

    private fun addHeader(cellData: HeaderCellData){

        headerImage {

            id("header")
            data(cellData)

        }


    }



    private fun addTitle(cellData: TitleCellData){
 title {

     id("title")
     data(cellData)
 }
    }

    private fun addSubtitle(cellData: SubtitleCellData) {

        subtitle {
            id("subtitle")
            data(cellData)
        }

    }

    private fun addSectionTitle(cellData: SectionTitleCellData) {

        sectionTitle {
            id("section/${cellData.title}")
           data(cellData)

        }


     }

    private fun addInfo(cellData: InfoCellData) {

        info {
            id("info")
            data(cellData)
        }


    }

    private fun addCart(cellData: CartCellData, listener: EpoxySampleControllerListener) {
      cart {
          id("addToCart")
          numberOfItems(cellData.numberOfItems)
          onClickListener(listener)
      }


    }

    private fun addDescription(cellData: DescriptionCellData) {

        description {

            id("description")
            data(cellData)

        }


    }

    private fun addItem(cellData: ItemCellData, listener: EpoxySampleControllerListener) {

        item {

            id(cellData.id)
            data(cellData)
            onClickListener(listener)
        }


    }


    }


