package com.example.core

import sttp.client4.upicklejson.default.asJson

import scala.util.Try

case class Description(
                        description: String,
                        stars: Int,
                        topic: List[String] = List.empty
                      ) derives upickle.default.ReadWriter

object Foo:

  val bar: Int = 42

  val either: Either[String, Int] = Right(42)

  import sttp.client4.okhttp.OkHttpSyncBackend

  val backend = OkHttpSyncBackend()

  import sttp.client4.*
  import sttp.client4.upicklejson.*

  def getProjectInfo(org: String, repo: String): Either[String, Description] =
    basicRequest
      .get(uri"https://index.scala-lang.org/api/v1/projects/$org/$repo")
      .response(asJson[Description])
      .send(backend)
      .body
      .left
      .map(_.toString)
