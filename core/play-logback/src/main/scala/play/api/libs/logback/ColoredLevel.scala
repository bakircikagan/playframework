/*
 * Copyright (C) 2009-2019 Lightbend Inc. <https://www.lightbend.com>
 */

package play.api.libs.logback

import ch.qos.logback.classic._
import ch.qos.logback.classic.pattern._
import ch.qos.logback.classic.spi._

/**
 * A logback converter generating colored, lower-case level names.
 *
 * Used for example as:
 * {{{
 * %coloredLevel %logger{15} - %message%n%xException{5}
 * }}}
 */
class ColoredLevel extends ClassicConverter {

  import play.utils.Colors

  def convert(event: ILoggingEvent): String = {
    event.getLevel match {
      case Level.TRACE => "[" + Colors.make(Colors.BLUE, "trace") + "]"
      case Level.DEBUG => "[" + Colors.make(Colors.CYAN, "debug") + "]"
      case Level.INFO  => "[" + Colors.make(Colors.WHITE, "info") + "]"
      case Level.WARN  => "[" + Colors.make(Colors.YELLOW,"warn") + "]"
      case Level.ERROR => "[" + Colors.make(Colors.RED, "error") + "]"
    }
  }

}
