#!/bin/sh
exec scala "$0" "$@"
!#

import scala.io.Source
import scala.sys.process._
import java.util.Date

var prefix = "macmillan7000"
var join = "_"
var soundDiskDir = "sound"

if (args.length != 2) {
  println("usage: gen-sound.scala macmillan7000word.list")
  sys.exit(-1)
}

Source.fromFile(args(0)).getLines().toList.par.foreach(word => {
  var filename = prefix + join + word;
  ("say " + word + " -o " + soundDiskDir + "/" + filename + ".m4a").!
})
