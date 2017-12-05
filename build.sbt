lazy val root = project.in( file( "." ) )
    .enablePlugins( AndroidLib )
    .settings( Settings.common )
    .settings(
        libraryDependencies ++=
            "com.android.support" % "support-annotations" % "26.1.0" % "compile" ::
            Nil,
        name := "icon-spinner",
        publishArtifact in ( Compile, packageDoc ) := false
    )

lazy val sample = project
    .enablePlugins( AndroidApp )
    .settings( Settings.common )
    .settings(
        organization := organization.value + ".icon_spinner.sample",
        run := ( run in Android ).evaluated
    )
    .dependsOn( root )
