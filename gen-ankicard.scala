#!/bin/sh
exec scala "$0" "$@"
!#

import java.io.FileWriter

import scala.io.Source

if (args.length != 1) {
  println("usage: gen-ankicard.scala macmillan7000word.list")
  sys.exit(-1)
}

var wordDirMerge = "wordmerge"
var ankicardName = "macmillan7000word.card.txt"

var ankicard = new FileWriter(ankicardName, false)

Source.fromFile(args(0)).getLines().toList.foreach(word => {

  var lines = Source.fromFile(wordDirMerge + "/" + word + ".txt").getLines().toList

  if (lines.length >= 3) {

    var cardword = lines(0).replaceAll("\n| ", "")
    var cardsymbol = lines(1).replaceAll("\n", "")

    if (cardsymbol == "1 ") {
      cardsymbol = lines(2).replaceAll("\n", "")
      lines = lines.drop(3) //第二行可能是 "1 "移除掉
    } else {
      lines = lines.drop(2)
    }

    var cardsound = "[sound:macmillan7000_" + word + ".mp3]"

    //正面
    ankicard.write("\"" + cardword + "<span style=\"\"display:none\"\">macmillan7000</span>\"\t")
    ankicard.write("\"" + cardsymbol + "\"\t")
    ankicard.write("\"" + cardsound + "\"\t")

    //反面
    ankicard.write("\"")
    lines.foreach(line => {
      if (line.length > 0)
        ankicard.write(line + "<br />")
    })
    ankicard.write("\"\n")
  } else {
    println("这个单词卡不足3行: " + word)
  }

})

ankicard.close()
