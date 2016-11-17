package mojolly.inflector

import org.scalatest.{FunSuite, Matchers}
import org.scalatest.prop.{TableDrivenPropertyChecks, TableFor2}


final class InflectorSuite
  extends FunSuite
  with    Matchers
  with    TableDrivenPropertyChecks {

  val dasherization = Table(
    ("source",                  "target"),
    ("some_title",              "some-title"),
    ("some-title",              "some-title"),
    ("some_title_goes_here",    "some-title-goes-here"),
    ("some_title_and_another",  "some-title-and-another"))

  val humanization = Table(
    ("source",             "target"),
    ("some_title",         "Some title"),
    ("some-title",         "Some-title"),
    ("someTitle",          "Sometitle"),
    ("someTitle_Another",  "Sometitle another"))

  val stringOrdinalization = Table(
    ("source",   "target"),
    (   "0",     "0th"),
    (   "1",     "1st"),
    (   "2",     "2nd"),
    (   "3",     "3rd"),
    (   "4",     "4th"),
    (   "5",     "5th"),
    (   "6",     "6th"),
    (   "7",     "7th"),
    (   "8",     "8th"),
    (   "9",     "9th"),
    (  "10",    "10th"),
    (  "11",    "11th"),
    (  "12",    "12th"),
    (  "13",    "13th"),
    (  "14",    "14th"),
    (  "20",    "20th"),
    (  "21",    "21st"),
    (  "22",    "22nd"),
    (  "23",    "23rd"),
    (  "24",    "24th"),
    ( "100",   "100th"),
    ( "101",   "101st"),
    ( "102",   "102nd"),
    ( "103",   "103rd"),
    ( "104",   "104th"),
    ( "110",   "110th"),
    ("1000",  "1000th"),
    ("1001",  "1001st"))

  val intOrdinalization = Table(
    ("source", "target"),
    (   0,     "0th"),
    (   1,     "1st"),
    (   2,     "2nd"),
    (   3,     "3rd"),
    (   4,     "4th"),
    (   5,     "5th"),
    (   6,     "6th"),
    (   7,     "7th"),
    (   8,     "8th"),
    (   9,     "9th"),
    (  10,    "10th"),
    (  11,    "11th"),
    (  12,    "12th"),
    (  13,    "13th"),
    (  14,    "14th"),
    (  20,    "20th"),
    (  21,    "21st"),
    (  22,    "22nd"),
    (  23,    "23rd"),
    (  24,    "24th"),
    ( 100,   "100th"),
    ( 101,   "101st"),
    ( 102,   "102nd"),
    ( 103,   "103rd"),
    ( 104,   "104th"),
    ( 110,   "110th"),
    (1000,  "1000th"),
    (1001,  "1001st"))

  val pascalization = Table(
    ("source",                          "target"),
    ("customer",                        "Customer"),
    ("CUSTOMER",                        "CUSTOMER"),
    ("CUStomer",                        "CUStomer"),
    ("customer_name",                   "CustomerName"),
    ("customer_first_name",             "CustomerFirstName"),
    ("customer_first_name_goes_here",   "CustomerFirstNameGoesHere"),
    ("customer name",                   "Customer name"))

  val camelization = Table(
    ("source",                         "target"),
    ("customer",                       "customer"),
    ("CUSTOMER",                       "cUSTOMER"),
    ("CUStomer",                       "cUStomer"),
    ("customer_name",                  "customerName"),
    ("customer_first_name",            "customerFirstName"),
    ("customer_first_name_goes_here",  "customerFirstNameGoesHere"),
    ("customer name",                  "customer name"))

  val titleization = Table(
    ("source",                    "target"),
    ("some title",                "Some Title"),
    ("some title",                "Some Title"),
    ("sometitle",                 "Sometitle"),
    ("some-title: The begining",  "Some Title: The Begining"),
    ("some_title:_the_begining",  "Some Title: The Begining"),
    ("some title: The_begining",  "Some Title: The Begining"))

  val uncapitalization = Table(
    ("source",                "target"),
    ("some title",            "some title"),
    ("some Title",            "some Title"),
    ("SOMETITLE",             "sOMETITLE"),
    ("someTitle",             "someTitle"),
    ("some title goes here",  "some title goes here"),
    ("some TITLE",            "some TITLE"))

  val underscoring: TableFor2[String, String] = Table(
    ("source",                               "target"),
    ("SomeTitle",                            "some_title"),
    ("some title",                           "some_title"),
    ("some title that will be underscored",  "some_title_that_will_be_underscored"),
    ("SomeTitleThatWillBeUnderscored",       "some_title_that_will_be_underscored"))

  val pluralAndSingular = Table(
    ("singular",     "plural"),
    ("search",       "searches"),
    ("switch",       "switches"),
    ("fix",          "fixes"),
    ("box",          "boxes"),
    ("process",      "processes"),
    ("address",      "addresses"),
    ("case",         "cases"),
    ("stack",        "stacks"),
    ("wish",         "wishes"),
    ("fish",         "fish"),
    ("category",     "categories"),
    ("query",        "queries"),
    ("ability",      "abilities"),
    ("agency",       "agencies"),
    ("movie",        "movies"),
    ("archive",      "archives"),
    ("index",        "indices"),
    ("wife",         "wives"),
    ("safe",         "saves"),
    ("half",         "halves"),
    ("move",         "moves"),
    ("salesperson",  "salespeople"),
    ("person",       "people"),
    ("spokesman",    "spokesmen"),
    ("man",          "men"),
    ("woman",        "women"),
    ("basis",        "bases"),
    ("diagnosis",    "diagnoses"),
    ("datum",        "data"),
    ("medium",       "media"),
    ("analysis",     "analyses"),
    ("node_child",   "node_children"),
    ("child",        "children"),
    ("experience",   "experiences"),
    ("day",          "days"),
    ("comment",      "comments"),
    ("foobar",       "foobars"),
    ("newsletter",   "newsletters"),
    ("old_news",     "old_news"),
    ("news",         "news"),
    ("series",       "series"),
    ("species",      "species"),
    ("quiz",         "quizzes"),
    ("perspective",  "perspectives"),
    ("ox",           "oxen"),
    ("photo",        "photos"),
    ("buffalo",      "buffaloes"),
    ("tomato",       "tomatoes"),
    ("dwarf",        "dwarves"),
    ("elf",          "elves"),
    ("information",  "information"),
    ("equipment",    "equipment"),
    ("bus",          "buses"),
    ("status",       "statuses"),
    ("status_code",  "status_codes"),
    ("mouse",        "mice"),
    ("louse",        "lice"),
    ("house",        "houses"),
    ("octopus",      "octopi"),
    ("virus",        "viri"),
    ("alias",        "aliases"),
    ("portfolio",    "portfolios"),
    ("vertex",       "vertices"),
    ("matrix",       "matrices"),
    ("axis",         "axes"),
    ("testis",       "testes"),
    ("crisis",       "crises"),
    ("rice",         "rice"),
    ("shoe",         "shoes"),
    ("horse",        "horses"),
    ("prize",        "prizes"),
    ("edge",         "edges"),
    ("goose",        "geese"),
    ("deer",         "deer"),
    ("sheep",        "sheep"),
    ("wolf",         "wolves"),
    ("volcano",      "volcanoes"),
    ("aircraft",     "aircraft"),
    ("alumna",       "alumnae"),
    ("alumnus",      "alumni"),
    ("fungus",       "fungi"))

  tableTest(dasherization)("dasherization", Inflector.dasherize)
  tableTest(humanization)("humanization", Inflector.humanize)
  tableTest(stringOrdinalization)("stringOrdinalization", Inflector.ordinalize)
  tableTest(intOrdinalization)("intOrdinalization", Inflector.ordinalize)
  tableTest(pascalization)("pascalization", Inflector.pascalize)
  tableTest(camelization)("camelization", Inflector.camelize)
  tableTest(titleization)("titleization", Inflector.titleize)
  tableTest(uncapitalization)("uncapitalization", Inflector.uncapitalize)
  tableTest(underscoring)("underscoring", Inflector.underscore)

  test("pluralization") {
    forAll(pluralAndSingular) { (sin, plu) =>
      Inflector.pluralize(sin) should === (plu)
    }
  }

  test("singularization") {
    forAll(pluralAndSingular) { (sin, plu) =>
      Inflector.singularize(plu) should === (sin)
    }
  }

  def tableTest[A](table: TableFor2[A, String])(name: String, fn: A => String): Unit = {
    test(name) {
      forAll(table) { (src, tgt) =>
        fn(src) should === (tgt)
      }
    }
  }
}
