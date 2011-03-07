package org.karatachi.scala

import org.lwjgl._
import org.lwjgl.opengl._
import org.lwjgl.opengl.GL11._

object SampleProgram1 {
  val WIDTH     = 640 // ウィンドウの幅
  val HEIGHT    = 480 // ウィンドウの高さ
  val FRAMERATE = 60  // フレームレート(FPS)

  def main(args: Array[String]): Unit = {
    // 画面の設定と初期化
    Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT))
    Display.create

    while (!Display.isCloseRequested) {
      // 画面の更新
      Display.update
      display
      // フレームレートに沿うように待機
      Display.sync(FRAMERATE)
    }

    // 後始末
    Display.destroy
  }

  def display(): Unit = {
    // 画面の消去
    glClear(GL_COLOR_BUFFER_BIT)

    // 三角形を描く
    glRender(GL_TRIANGLES) {
      glColor3f(1.0f, 0.0f, 0.0f)
      glVertex3f(0.0f, 1.0f, 0.0f)
      glColor3f(0.0f, 1.0f, 0.0f)
      glVertex3f(-1.0f, -1.0f, 0.0f)
      glColor3f(0.0f, 0.0f, 1.0f)
      glVertex3f(1.0f, -1.0f, 0.0f)
    }
  }

  def glRender(mode: Int)(block: => Unit): Unit = {
    glBegin(mode)
    block
    glEnd
  }
}
