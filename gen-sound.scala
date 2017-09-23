#!/bin/sh
exec scala "$0" "$@"
!#

import scala.io.Source
import scala.sys.process._
import java.util.Date

var prefix = "macmillan7000"
var join = "_"
var soundDiskDir = "sound"

var startTime = new Date().getTime

Source.fromFile(args(0)).getLines().toList.par.foreach(word => {
  var filename = prefix + join + word;
  ("say " + word + " -o " + soundDiskDir + "/" + filename + ".m4a").!
})


println("usr time" + (new Date().getTime - startTime) /1000)
