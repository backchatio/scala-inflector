package mojolly.inflector

import java.util.Locale.ENGLISH

private[inflector] object Util {
  def ucase(str: String): String = str.toUpperCase(ENGLISH)
  def lcase(str: String): String = str.toLowerCase(ENGLISH)
}