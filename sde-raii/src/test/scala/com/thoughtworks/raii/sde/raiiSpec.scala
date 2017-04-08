package com.thoughtworks.raii.sde

import com.thoughtworks.raii.ResourceFactory
import org.scalatest.{FreeSpec, Matchers}
import raii.using

import scalaz.{-\/, \/-}

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
final class raiiSpec extends FreeSpec with Matchers {

  "using" in {

    var count = 0
    var isClosed = true

    final class FakeResouce extends AutoCloseable {
      count += 1
      isClosed should be(true)
      isClosed = false
      override def close(): Unit = {
        isClosed should be(false)
        isClosed = true
      }
    }

    raii {
      isClosed should be(true)
      using(new FakeResouce)
      isClosed should be(false)
    }

    isClosed should be(true)
    count should be(1)

  }
}