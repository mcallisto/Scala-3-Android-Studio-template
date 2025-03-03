package com.example.core

import sttp.client3.SttpBackendOptions

import scala.util.Try

case class Description(description: String, stars: Int, topic: List[String] = List.empty) derives upickle.default.ReadWriter

object Foo:

  import sttp.client3.HttpClientSyncBackend

  val backend = HttpClientSyncBackend(options = SttpBackendOptions.Default.copy(proxy = None))
  import sttp.client3.*
  import sttp.client3.upicklejson._

  val bar: Int = (1 to 11).toList.sum

  def getProjectInfo(org: String, repo: String): Either[String, Description] =
    Right(Description("Hello", 500, Nil))
    /*Try {
      basicRequest.get(uri"https://index.scala-lang.org/api/v1/projects/$org/$repo").response(asJson[Description]).send(backend).body.left.map(_.getMessage)
    }.toEither.left.map(_.getMessage).flatten*/