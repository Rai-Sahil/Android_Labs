package com.bcit.lab5_sahil

class Battle(var fighterOne: Fighter, var fighterTwo: Fighter) {

    fun winner(): Fighter? {

        return if(fighterOne.power == fighterTwo.power) {
            null
        } else if(fighterOne.power!! > fighterTwo.power!!){
            fighterOne
        } else {
            fighterTwo
        }

    }

}