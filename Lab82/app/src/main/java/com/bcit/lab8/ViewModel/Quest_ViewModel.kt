package com.bcit.lab8.ViewModel

import androidx.lifecycle.ViewModel
import com.bcit.lab8.ITEM
import com.bcit.lab8.Interface.QuestResultListener
import com.bcit.lab8.Objects.Quest
import com.bcit.lab8.PrepareFragment
import com.bcit.lab8.SIDEKICK
import kotlin.random.Random

class Quest_ViewModel : ViewModel() {

    var quests = ArrayList<Quest>()


    fun startNewQuest(item: ITEM?, sideKick: SIDEKICK?, prepareFragment: PrepareFragment){

        var saved: Boolean = didSaveHyurle(item, sideKick, prepareFragment)
        var currentQuest = Quest(Random.nextInt(1, 999), sideKick, item, saved)
        quests.add(currentQuest)
    }

    private fun didSaveHyurle(item: ITEM?, sideKick: SIDEKICK?, questResultListener: QuestResultListener): Boolean{
        if (item == ITEM.POTION && sideKick == SIDEKICK.GORON){
            questResultListener.onSavedHyrule()
            return true
        }
        questResultListener.onDidNotSaveHyrule()
        return false
    }

}