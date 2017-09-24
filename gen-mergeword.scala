#!/bin/sh
exec scala "$0" "$@"
!#

import java.io.File

import scala.io.Source
import scala.sys.process._

if (args.length != 1) {
  println("usage: gen-mergeword.scala macmillan7000word.list")
  sys.exit(-1)
}

var wordDir = "word"
var wordDirMerge = "wordmerge"

Source.fromFile(args(0)).getLines().toList.par.foreach(word => {
  ("cat " + wordDir + "-zh/" + word + ".zh.txt") #> new File(wordDirMerge + "/" + word + ".txt") !

  ("cat " + wordDir + "-en/" + word + ".en.txt") #>> new File(wordDirMerge + "/" + word + ".txt") !
})
