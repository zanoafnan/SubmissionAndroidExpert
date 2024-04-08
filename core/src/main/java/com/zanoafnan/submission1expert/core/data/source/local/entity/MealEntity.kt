package com.zanoafnan.submission1expert.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mea")
data class MeaEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "gists_url")
    var gistsUrl: String,

    @ColumnInfo(name = "repos_url")
    var reposUrl: String,

    @ColumnInfo(name = "following_url")
    var followingUrl: String,

    @ColumnInfo(name = "starred_url")
    var starredUrl: String,

    @ColumnInfo(name = "strMeal")
    var strMeal: String,

    @ColumnInfo(name = "followers_url")
    var followersUrl: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "subscriptions_url")
    var subscriptionsUrl: String,

    @ColumnInfo(name = "received_events_url")
    var receivedEventsUrl: String,

    @ColumnInfo(name = "avatar_url")
    var strMealThumb: String,

    @ColumnInfo(name = "events_url")
    var eventsUrl: String,

    @ColumnInfo(name = "html_url")
    var htmlUrl: String,

    @ColumnInfo(name = "site_admin")
    var siteAdmin: Boolean,

    @ColumnInfo(name = "gravatar_id")
    var gravatarId: String,

    @ColumnInfo(name = "node_id")
    var nodeId: String,

    @ColumnInfo(name = "organizations_url")
    var organizationsUrl: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean
)


@Entity(tableName = "meal")
data class MealEntity(
    @PrimaryKey
    @NonNull
    
    @ColumnInfo(name ="idMeal")
    val idMeal: String,

    @ColumnInfo(name ="strMeal")
    val strMeal: String,

    @ColumnInfo(name ="strDrinkAlternate")
    val strDrinkAlternate: String?,

    @ColumnInfo(name ="strCategory")
    val strCategory: String,

    @ColumnInfo(name ="strArea")
    val strArea: String,

    @ColumnInfo(name ="strInstructions")
    val strInstructions: String,

    @ColumnInfo(name ="strMealThumb")
    val strMealThumb: String,

    @ColumnInfo(name ="strTags")
    val strTags: String?,

    @ColumnInfo(name ="strYoutube")
    val strYoutube: String,

    @ColumnInfo(name ="strIngredient1")
    val strIngredient1: String,

    @ColumnInfo(name ="strIngredient2")
    val strIngredient2: String?,

    @ColumnInfo(name ="strIngredient3")
    val strIngredient3: String?,

    @ColumnInfo(name ="strIngredient4")
    val strIngredient4: String?,

    @ColumnInfo(name ="strIngredient5")
    val strIngredient5: String?,

    @ColumnInfo(name ="strIngredient6")
    val strIngredient6: String?,

    @ColumnInfo(name ="strIngredient7")
    val strIngredient7: String?,

    @ColumnInfo(name ="strIngredient8")
    val strIngredient8: String?,

    @ColumnInfo(name ="strIngredient9")
    val strIngredient9: String?,

    @ColumnInfo(name ="strIngredient10")
    val strIngredient10: String?,

    @ColumnInfo(name ="strIngredient11")
    val strIngredient11: String?,

    @ColumnInfo(name ="strIngredient12")
    val strIngredient12: String?,

    @ColumnInfo(name ="strIngredient13")
    val strIngredient13: String?,

    @ColumnInfo(name ="strIngredient14")
    val strIngredient14: String?,

    @ColumnInfo(name ="strIngredient15")
    val strIngredient15: String?,

    @ColumnInfo(name ="strIngredient16")
    val strIngredient16: String?,

    @ColumnInfo(name ="strIngredient17")
    val strIngredient17: String?,

    @ColumnInfo(name ="strIngredient18")
    val strIngredient18: String?,

    @ColumnInfo(name ="strIngredient19")
    val strIngredient19: String?,

    @ColumnInfo(name ="strIngredient20")
    val strIngredient20: String?,

    @ColumnInfo(name ="strMeasure1")
    val strMeasure1: String,

    @ColumnInfo(name ="strMeasure2")
    val strMeasure2: String?,

    @ColumnInfo(name ="strMeasure3")
    val strMeasure3: String?,

    @ColumnInfo(name ="strMeasure4")
    val strMeasure4: String?,

    @ColumnInfo(name ="strMeasure5")
    val strMeasure5: String?,

    @ColumnInfo(name ="strMeasure6")
    val strMeasure6: String?,

    @ColumnInfo(name ="strMeasure7")
    val strMeasure7: String?,

    @ColumnInfo(name ="strMeasure8")
    val strMeasure8: String?,

    @ColumnInfo(name ="strMeasure9")
    val strMeasure9: String?,

    @ColumnInfo(name ="strMeasure10")
    val strMeasure10: String?,

    @ColumnInfo(name ="strMeasure11")
    val strMeasure11: String?,

    @ColumnInfo(name ="strMeasure12")
    val strMeasure12: String?,

    @ColumnInfo(name ="strMeasure13")
    val strMeasure13: String?,

    @ColumnInfo(name ="strMeasure14")
    val strMeasure14: String?,

    @ColumnInfo(name ="strMeasure15")
    val strMeasure15: String?,

    @ColumnInfo(name ="strMeasure16")
    val strMeasure16: String?,

    @ColumnInfo(name ="strMeasure17")
    val strMeasure17: String?,

    @ColumnInfo(name ="strMeasure18")
    val strMeasure18: String?,

    @ColumnInfo(name ="strMeasure19")
    val strMeasure19: String?,

    @ColumnInfo(name ="strMeasure20")
    val strMeasure20: String?,

    @ColumnInfo(name ="strSource")
    val strSource: String?,

    @ColumnInfo(name ="strImageSource")
    val strImageSource: String?,

    @ColumnInfo(name ="strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String?,

    @ColumnInfo(name ="dateModified")
    val dateModified: String?,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean
)
