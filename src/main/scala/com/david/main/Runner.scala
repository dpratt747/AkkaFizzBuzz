package com.david.main

import akka.actor.{ActorSystem, Props}
import com.david.receive.FizzOrBuzz

object Runner extends App {

  case class Fizz(n: Int)
  case class Buzz(n: Int)
  case class FizzBuzz(n: Int)

  val system = ActorSystem("FizzBuzzActor")
  val fizzOrBuzz = system.actorOf(Props[FizzOrBuzz], "fizzOrBuzz")
  val rangeFromAtoB = (a: Int, b: Int) => (a to b).toVector

  rangeFromAtoB(1,10).foreach{ number =>
    number match {
      case fizz if number % 3 == 0 => fizzOrBuzz ! Fizz(fizz)
      case buzz if number % 5 == 0 => fizzOrBuzz ! Buzz(buzz)
      case fizzBuzz if number % 15 == 0 => fizzOrBuzz ! FizzBuzz(fizzBuzz)
      case _ =>
    }
  }
}
