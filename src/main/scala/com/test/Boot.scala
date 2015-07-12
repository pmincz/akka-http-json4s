package com.test

import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import com.test.domain.User
import com.test.json.JsonSupport
import com.test.provider.ActorSystemProvider

/**
 * Created by pmincz on 7/8/15.
 */
object Boot extends App with ActorSystemProvider with JsonSupport {

  lazy val route =
    get {
      path("users") {
        complete(User(1L, "name", "email"))
      }
    }

  Http(system).bindAndHandle(route, interface = config.getString("service.host"), port = config.getInt("service.port"))

}
