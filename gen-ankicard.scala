#!/bin/sh
exec scala "$0" "$@"
!#

import scala.io.Source

if (args.length != 1) {
  println("usage: gen-ankicard.scala macmillan7000word.list")
  sys.exit(-1)
}

var wordDirMerge = "wordmerge"
var ankicard = "macmillan7000word.card"

Source.fromFile(args(0)).getLines().toList.par.foreach(word => {
  var lines = Source.fromFile(wordDirMerge + "/" + word + ".txt").getLines().toList
  println(lines(0))
})
