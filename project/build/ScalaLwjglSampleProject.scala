import sbt._
import java.io.File

class ScalaLwjglSampleProject(info: ProjectInfo) extends DefaultProject(info) {
  override def fork = Some(new ForkScalaRun {
    val os = System.getProperty("os.name").split(" ")(0).toLowerCase match {
      case "linux" => "linux"
      case "mac" => "macosx"
      case "windows" => "windows"
      case "sunos" => "solaris"
      case x => x
    }

    val newPath = System.getProperty("java.library.path") + ":" + ("lib"/"lwjgl"/"native"/os)

    override def runJVMOptions = super.runJVMOptions ++ Seq("-Djava.library.path=" + newPath)

    override def scalaJars = buildScalaInstance.libraryJar :: buildScalaInstance.compilerJar :: Nil
  })
}
