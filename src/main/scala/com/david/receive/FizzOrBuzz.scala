package com.david.receive

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import com.david.main.Runner.{Buzz, Fizz, FizzBuzz}

class FizzOrBuzz extends Actor {
  override def receive: Unit = {
    case Fizz(n) => println(s"fizzle: $n")
    case Buzz(n) => println(s"buzzzzzz: $n")
    case FizzBuzz(n) => println(s"fizzle and buzzzzzz: $n")
  }
}
