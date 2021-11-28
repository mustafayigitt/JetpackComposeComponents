package com.mustafayigit.jetpackcomposecomponents.data.model

import androidx.annotation.DrawableRes
import com.mustafayigit.jetpackcomposecomponents.R

sealed class Animal(@DrawableRes val imageSrc: Int) {
    object Dog : Animal(R.drawable.image_dog)
    object Cat : Animal(R.drawable.image_cat)
}