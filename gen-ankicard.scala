#!/bin/sh
exec scala "$0" "$@"
!#

import scala.io.Source
import java.io.{File, FileWriter}

if (args.length != 1) {
  println("usage: gen-ankicard.scala macmillan7000word.list")
  sys.exit(-1)
}

var wordDirMerge = "wordmerge"
var ankicardName = "macmillan7000word.card.txt"

var ankicard = new FileWriter(ankicardName,false)

Source.fromFile(args(0)).getLines().toList.foreach(word => {

  var lines = Source.fromFile(wordDirMerge + "/" + word + ".txt").getLines().toList

  var cardword = lines(0).replaceAll("\n| |\t","")
  var cardsymbol = lines(1).replaceAll("\n| |\t","")
  var cardsound = "[sound:macmillan7000_" + word + ".mp3]".replaceAll("\n| |\t","")

  //正面
  ankicard.write("\"" + cardword + "\"\t")
  ankicard.write("\"" + cardsymbol + "\"\t")
  ankicard.write("\"" + cardsound  + "\"\t")


  //反面
  ankicard.write("\"")

  lines.drop(2).foreach( e => {
    ankicard.write(e + "<br />")
  })

  ankicard.write("\"\n")


})

ankicard.close()
