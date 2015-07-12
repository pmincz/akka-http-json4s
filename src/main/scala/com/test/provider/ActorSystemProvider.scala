package com.test.provider

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory

/**
 * Created by pmincz on 7/12/15.
 */
trait ActorSystemProvider {

  implicit val system = ActorSystem("akka-http-test")

  implicit val executionContext = system.dispatcher
  implicit val materializer = ActorMaterializer()

  lazy val config = ConfigFactory.load()

}

object ActorSystemProvider extends ActorSystemProvider
