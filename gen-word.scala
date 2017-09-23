#!/bin/sh
exec scala "$0" "$@"
!#

import java.io.PrintWriter

import scala.io.Source
import scala.sys.process._

var wordDir = "word"
if (args.length != 1) {
  println("usage: gen-word.scala macmillan7000word.list")
  sys.exit(-1)
}

Source.fromFile(args(0)).getLines().toList.par.foreach(word => {
  var result = ("python dict.py " + word).!!
  var out = new PrintWriter("word/" + word + ".zh.txt")
  out.print(result)
  out.close()
})
