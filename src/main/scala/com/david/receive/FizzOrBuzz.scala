package com.david.receive

import akka.actor.Actor
import com.david.main.{Buzz, Fizz, FizzBuzz}

class FizzOrBuzz extends Actor{
  override def receive = {
    case Fizz(n) => println(s"fizz: $n")
    case Buzz(n) => println(s"buzz: $n")
    case FizzBuzz(n) => println(s"fizz and buzz: $n")
  }
}
