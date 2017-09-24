#!/bin/sh
exec scala "$0" "$@"
!#

import java.io.PrintWriter

import scala.io.Source
import scala.sys.process._


if (args.length != 2) {
  println("usage: gen-word.scala macmillan7000word.list zh|en")
  sys.exit(-1)
}

var wordDir = "word"

Source.fromFile(args(0)).getLines().toList.par.foreach(word => {
  var result = ("python dict.py " + word).!!
  var out = new PrintWriter("word/" + word + "."+ args(1) + ".txt")
  out.print(result)
  out.close()
})
