package com.jakubdziworski

/**
  * Created by kuba on 21.09.16.
  */

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.jakubdziworski.service.GameService
import com.typesafe.config.{Config, ConfigFactory}

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object Server {

  object Config {
    val config: Config = ConfigFactory.defaultApplication()
    val port: Int = config.getInt("server.port")
    val host: String = config.getString("server.host")
  }

  def main(args: Array[String]) {
    implicit val system: ActorSystem = ActorSystem()
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val gameService = new GameService()
    val bindingFuture = Http().bindAndHandle(gameService.websocketRoute, Config.host,Config.port)
    println(s"Server online at ${Config.host}:${Config.port}\nPress RETURN to stop...")
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}
