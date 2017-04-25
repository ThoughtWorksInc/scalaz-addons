crossScalaVersions := Seq("2.11.11", "2.12.2")

lazy val CovariantT = crossProject.crossType(CrossType.Pure)

lazy val CovariantTJVM = CovariantT.jvm.addSbtFiles(file("../build.sbt.shared"))

lazy val CovariantTJS = CovariantT.js.addSbtFiles(file("../build.sbt.shared"))

lazy val EitherTNondeterminism = crossProject.crossType(CrossType.Pure)

lazy val EitherTNondeterminismJVM = EitherTNondeterminism.jvm.addSbtFiles(file("../build.sbt.shared"))

lazy val EitherTNondeterminismJS = EitherTNondeterminism.js.addSbtFiles(file("../build.sbt.shared"))

lazy val FreeTParallelApplicative = crossProject.crossType(CrossType.Pure)

lazy val FreeTParallelApplicativeJVM = FreeTParallelApplicative.jvm.addSbtFiles(file("../build.sbt.shared"))

lazy val FreeTParallelApplicativeJS = FreeTParallelApplicative.js.addSbtFiles(file("../build.sbt.shared"))

lazy val KleisliParallelApplicative = crossProject.crossType(CrossType.Pure)

lazy val KleisliParallelApplicativeJVM = KleisliParallelApplicative.jvm.addSbtFiles(file("../build.sbt.shared"))

lazy val KleisliParallelApplicativeJS = KleisliParallelApplicative.js.addSbtFiles(file("../build.sbt.shared"))

lazy val unidoc = project
  .enablePlugins(StandaloneUnidoc, TravisUnidocTitle)
  .settings(
    UnidocKeys.unidocProjectFilter in ScalaUnidoc in UnidocKeys.unidoc := {
      inProjects(CovariantTJVM, EitherTNondeterminismJVM, FreeTParallelApplicativeJVM, KleisliParallelApplicativeJVM)
    },
    addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3"),
    scalacOptions += "-Xexperimental"
  )

organization in ThisBuild := "com.thoughtworks.scalaz-addons"

publishArtifact := false
