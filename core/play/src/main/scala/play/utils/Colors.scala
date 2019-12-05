/*
 * Copyright (C) 2009-2019 Lightbend Inc. <https://www.lightbend.com>
 */

package play.utils
class Colors(logNoFormat: String) extends scala.io.AnsiColor{
  val isANSISupported: Boolean = {
    Option(System.getProperty(logNoFormat))
      .map(_ != "true")
      .orElse {
        Option(System.getProperty("os.name"))
          .map(_.toLowerCase(java.util.Locale.ENGLISH))
          .filter(_.contains("windows"))
          .map(_ => false)
      }
      .getOrElse(true)
  }

  def make(code: String, str: String) = if (isANSISupported) code + str + scala.io.AnsiColor.RESET else str
}

object Colors extends Colors("sbt.log.noformat")
