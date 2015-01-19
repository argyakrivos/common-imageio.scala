package com.blinkbox.books.imageio

import java.awt.image.BufferedImage
import java.io.InputStream
import javax.imageio.ImageIO

import org.scalatest.Assertions._

trait ImageChecks {
  /**
   * Check that the given data is readable as an image of the specified type,
   * and has the desired dimensions.
   */
  def checkImage(input: InputStream, fileType: String, size: Int): Unit = {
    val image = readImage(input, fileType)
    assert(image.getWidth == size || image.getHeight == size,
      s"Got image of (${image.getWidth}, ${image.getHeight}), expected one dimension to be ($size)")
  }

  /**
   * Check that the given data is readable as an image of the specified type,
   * and has the desired dimensions.
   */
  def checkImage(input: InputStream, fileType: String, width: Int, height: Int, details: String = ""): BufferedImage = {
    val image = readImage(input, fileType)
    assert(image.getWidth == width && image.getHeight == height, details)
    image
  }

  def readImage(input: InputStream, fileType: String): BufferedImage = {
    try {
      val reader = ImageIO.getImageReadersByFormatName(fileType).next
      val iis = ImageIO.createImageInputStream(input)
      reader.setInput(iis)
      reader.read(0)
    } finally {
      input.close()
    }
  }
}