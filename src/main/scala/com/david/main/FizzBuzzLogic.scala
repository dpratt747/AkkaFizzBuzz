package com.david.main

import akka.actor.{ActorSystem, PoisonPill, Props}
import com.david.receive.FizzOrBuzz

class FizzBuzzLogic(val a: Int, val b: Int) {

  private val system = ActorSystem("FizzBuzzActor")
  private val fizzOrBuzz = system.actorOf(Props[FizzOrBuzz], "fizzOrBuzz")
  private val rangeFromAtoB = (a: Int, b: Int) => (a to b).toList
  private val notFizzOrBuzz = Nil

  rangeFromAtoB(a, b).foreach{ number  =>
    number match {
      case fizzBuzz if number % 15 == 0 => fizzOrBuzz ! FizzBuzz(fizzBuzz)
      case buzz if number % 5 == 0 => fizzOrBuzz ! Buzz(buzz)
      case fizz if number % 3 == 0 => fizzOrBuzz ! Fizz(fizz)
      case _ if number == b => fizzOrBuzz ! PoisonPill
      case x@_ => notFizzOrBuzz :+ x
    }
  }
}

